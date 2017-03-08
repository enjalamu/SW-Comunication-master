package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

@SuppressWarnings("serial")
public class Pelis extends JFrame implements Observer{

	private JPanel contentPane;
	private Controller c;
	private JPanel aux;
	private ToolbarSup t;
	private Pelicula[] pelicula = new Pelicula[8];
	private int indp = 0;
	private Timer timer;
	private HashMap<Integer, ArrayList<String>> results;
	private String informacion;
	private static ArrayList<String> lista;
	private JPanel pelis;
	private JLabel tit = new JLabel ("Tï¿½tulo");
	private JTextField titF = new JTextField();
	private JLabel img = new JLabel("Imagen");
	private String[] args;
	private JPanel bots;
	private JButton anyadir = new JButton("Aï¿½adir pelï¿½culas");
	private JPanel dialog;
	private JButton cargarIm = new JButton("Cargar imagen");
	private ImageIcon iconPel;
	private KeyListener[] keyListener = new KeyListener[8];
	private MouseListener[] mouseListener = new MouseListener[8];
	private ImageIcon si;
	private MouseListener mgeneral;
	
	public Pelis(Controller controlador) {
		this.setExtendedState(MAXIMIZED_BOTH); //Para que se inicie siempre al tamaï¿½o mï¿½ximo.
		this.c = controlador;
		setTitle("PelÃ­culas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.si = new ImageIcon("src/imagenes/si.png");
		temporizador();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		anyadir.setFont(new Font("Roboto", Font.BOLD, 20));
		t = new ToolbarSup(c, 3,null);
		contentPane.add(t, BorderLayout.NORTH);
		aux = new JPanel();
		aux.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(aux, BorderLayout.CENTER);
		aux.setLayout(new GridLayout(2, 2, 10, 10));
		pelis = new JPanel();
		pelis.setLayout(new GridLayout(2,4,10,10));

			results = c.cargarDatos(); //Consigo las peliculas que hay en el xml, solo 8.
			if(results != null){
				for(int i = results.size()-1;i>=0 && i >= (results.size() - 8); i--){
					lista = results.get(i);// Cojo la primera pelï¿½cula
					//Solo hay titulo e imagen
					this.pelicula[indp] = new Pelicula(lista.get(0), lista.get(1)); //Peliculas actualmente visibles
					pelis.add(pelicula[indp]);
					indp++;
				}
			}
		contentPane.add(pelis, BorderLayout.CENTER);
	//Aï¿½ADIR NUEVAS PELICULAS (SI NO SE INTRODUCE UNA IMï¿½GEN, HABRï¿½A QUE TENER UNA POR DEFECTO).
	
		bots = new JPanel();
		bots.setLayout(new GridLayout(1,2));
		dialog = new JPanel(new GridLayout(2,2));
		args = new String[4]; // IMPORTANTE INICIALIZAR ESTE ARRAY DE STRINGS. 
		cargarIm.addActionListener(new ActionListener() { 
			
			public void actionPerformed(ActionEvent e)
            {
				JFileChooser fc = new JFileChooser();
		        int respuesta = fc.showOpenDialog(null);
		        
		        //Comprobar si se ha pulsado Aceptar
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            File logo = fc.getSelectedFile();   
		            args[1] = logo.getName();
		            
		            // Ahora guardamos la imagen en la carpeta de imagenes
		            try {
						c.mvImagen(logo);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
            }
        });
		dialog.add(tit);
		dialog.add(titF);
		dialog.add(Box.createHorizontalStrut(15));
		dialog.add(img);
		dialog.add(cargarIm);
		dialog.add(Box.createHorizontalStrut(15));
		iconPel = new ImageIcon("src/imagenes/pelicula.png");
		anyadir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean ok = false;
				int s;
				do{
					UIManager.put("OptionPane.minimumSize",new Dimension(200,200)); 
					s = JOptionPane.showConfirmDialog(null, dialog, 
				               "Aï¿½adir pelï¿½cula ", JOptionPane.OK_CANCEL_OPTION,0,iconPel);
					// Si es 2 o -1 esque ha pulsado a cancelar o cerrar.
					try{
						if(titF.getText().length() != 0){
							ok = true;
							args[0] = titF.getText();
							if(args[1] == null) args[1] = "defecto.jpg";
						} else{
							//Hay que forzar un error para que salte el catch.
							 @SuppressWarnings("unused")
							int n = Integer.parseInt("M");
						}

					}catch(Exception e1){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100)); 
						if(s != -1 && s != 2){
							JOptionPane.showMessageDialog(dialog, "Algï¿½n campo estï¿½ incompleto.", "Error", JOptionPane.ERROR_MESSAGE);
							ok = false;
						}
					}
				}while(s!= -1 && s!= 2 && !ok);
				 
				if(s!= -1 && s!= 2){
					//if(TratarXML.escribirXML(args)){
					if(c.escribirDatos(args)){
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La pelï¿½cula ha sido aï¿½adida con ï¿½xito.", "Success", JOptionPane.INFORMATION_MESSAGE);
						cerrarVentana();
						new Pelis(c);
					}else{
						UIManager.put("OptionPane.minimumSize",new Dimension(100,100));
						JOptionPane.showMessageDialog(dialog, "La pelï¿½cula no se ha aï¿½adido con ï¿½xito.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		bots.add(anyadir);
		contentPane.add(bots, BorderLayout.SOUTH);
		this.setVisible(true);
		this.c.addObserver(this);
		//Comprobar el modo al entrar
		if(c.getModo() == true){
			pelicula[0].activa();
			timer.start();
			listModNiño();
			this.anyadir.setEnabled(false);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].activa();
			}
			listModMadre();
		}
		this.setExtendedState(MAXIMIZED_BOTH);
	}
	
	private void listModMadre() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			if(pelicula[i] != null)
			pelicula[i].removeKeyListener(keyListener[i]);
		}
		for(indp = 0; indp < pelicula.length; indp++){
			mouseListener[indp] = new MouseAdapter(){
				@SuppressWarnings("unused")
				public void MouseClicked(MouseEvent e) { //al pulsar con el raton
					Pelicula o = (Pelicula) e.getSource();
					if(o.isActiva() == true){
						JOptionPane.showMessageDialog(null,o.getInfo(), "Seleccion", 0, si); 
					}
				}
			};
			if(pelicula[indp] != null)
			pelicula[indp].addMouseListener(mouseListener[indp]);
		}
	}

	private void listModNiño() {
		// TODO Auto-generated method stub
		for(int i = 0; i < pelicula.length; i++){
			if(pelicula[i] != null)
			pelicula[i].removeMouseListener(mouseListener[i]);
		}
		mgeneral = new MouseAdapter(){
			public void mouseClicked (MouseEvent e){
					mouseNiño();
			}
		};
		contentPane.addMouseListener(mgeneral);
		for(indp = 0; indp < pelicula.length; indp++){
			keyListener[indp] = new KeyAdapter(){
				public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
					timer.stop();
					Pelicula o = (Pelicula) e.getSource();
					if(o.isActiva() == true){
						JOptionPane.showMessageDialog(null,o.getInfo(), "Seleccion", 0, si); 
					}
					timer.restart();
				}
			};
			if(pelicula[indp] != null){
			pelicula[indp].addKeyListener(keyListener[indp]);
			pelicula[indp].addMouseListener(mgeneral);
			}
		}
	}

	private void temporizador() {
		// TODO Auto-generated method stub
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if(pelicula[0].isActiva() == true){
		    		pelicula[0].desactiva();
		    		if(pelicula[1] != null){
		    		pelicula[1].activa();
		    		pelicula[1].requestFocus();
		    		}
		    		else{
		    		pelicula[0].activa();
		    		pelicula[0].requestFocus();	
		    		}
		    	}
		    	else if(pelicula[1].isActiva() == true){
		    		pelicula[1].desactiva();
		    		if(pelicula[2] != null){
		    		pelicula[2].activa();
		    		pelicula[2].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();	
		    		}
		    	}
		    	else if(pelicula[2].isActiva() == true){
		    		pelicula[2].desactiva();
		    		if(pelicula[3] != null){
		    		pelicula[3].activa();
		    		pelicula[3].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();
		    		}
		    	}
		    	else if(pelicula[3].isActiva() == true){
		    		pelicula[3].desactiva();
		    		if(pelicula[4] != null){
		    		pelicula[4].activa();
		    		pelicula[4].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();
		    		}
		    	}
		    	else if(pelicula[4].isActiva() == true){
		    		pelicula[4].desactiva();
		    		if(pelicula[5] != null){
		    		pelicula[5].activa();
		    		pelicula[5].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();
		    		}
		    	}
		    	else if(pelicula[5].isActiva() == true){
		    		pelicula[5].desactiva();
		    		if(pelicula[6] != null){
		    		pelicula[6].activa();
		    		pelicula[6].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();
		    		}
		    	}
		    	else if(pelicula[6].isActiva() == true){
		    		pelicula[6].desactiva();
		    		if(pelicula[7] != null){
		    		pelicula[7].activa();
		    		pelicula[7].requestFocus();
		    		}
		    		else{
		    			pelicula[0].activa();
			    		pelicula[0].requestFocus();
		    		}
		    	}
		    	else if(pelicula[7].isActiva() == true){
		    		pelicula[7].desactiva();
		    		pelicula[0].activa();
		    		pelicula[0].requestFocus();
		    	}
	}
		});
		}
	public void cerrarVentana(){
		this.setVisible(false);
	}

	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op == 1){
			this.c.removeObserver(this);
			this.setVisible(false);
			new PrincipalView(c);
		}
	}

	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		if(c.getModo() == true){
			pelicula[0].activa();
			for(int i = 1; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].desactiva();
			}
			//temporizador();
			timer.start();
			t.disabledModo();
			listModNiño();
			this.anyadir.setEnabled(false);
		} else {
			for(int i = 0; i < pelicula.length; i++){
				if(pelicula[i] != null)
				pelicula[i].activa();
			}
			listModMadre();
			t.enabledModo();
			timer.stop();
			this.anyadir.setEnabled(true);
		}
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		c.setFrecuencia(f);
		temporizador();
	}

	@Override
	public void mouseNiño() {
		// TODO Auto-generated method stub
		timer.stop();
		for(indp = 0; indp < pelicula.length; indp++){
			if(pelicula[indp] != null){
			if(pelicula[indp].isActiva())
				JOptionPane.showMessageDialog(null,pelicula[indp].getInfo(), "Seleccion", 0, si); 
		}
		}
		timer.restart();
	}

	@Override
	public void atras() {
		// TODO Auto-generated method stub
		this.c.removeObserver(this);
		this.setVisible(false);
	}
}


