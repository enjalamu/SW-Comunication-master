package swComunicacion.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;
import swComunicacion.Voz;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PrincipalView extends JFrame implements Observer {

	/*public static int getFrecuencia() {
		return frecuencia;
	}*/
	
	private JPanel contentPane;
	private Controller c;
	private boolean vs1;
	private boolean vs2;
	private boolean vs3;
	private JButton btnOpcion_1;
	private JButton btnOpcion_2;
	private JButton btnOpcion_3;
	private Timer timer;
	private ToolbarSup t;
	private JPanel panel;
	private JPanel panelOp;
	private KeyListener kl1;
	private KeyListener kl2;
	private KeyListener kl3;
	private MouseListener ml1;
	private MouseListener ml2;
	private MouseListener ml3;
	private MouseListener mgeneral;
	private Voz voz;
	private JLabel text;
	
	public PrincipalView(Controller c2) {
		c = c2;
		setTitle("SW Comunicacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 353);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		text = new JLabel("Bienvenido a SWComunicacion");
		text.setBackground(Color.WHITE);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(new Font("Roboto", Font.PLAIN, 30));
		contentPane.add(text, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(10, 10));
		t = new ToolbarSup(c,0,null);
		panel.add(t, BorderLayout.NORTH);
		panelOp = new JPanel();
		panelOp.setBackground(Color.WHITE);
		panelOp.setLayout(new GridLayout(1, 3, 10, 20));
		btnOpcion_1 = new JButton("Respuestas rápidas");
		btnOpcion_1.setFont(new Font("Roboto", Font.BOLD, 50));
		
		btnOpcion_2 = new JButton("Teclado interactivo");
		btnOpcion_2.setFont(new Font("Roboto", Font.BOLD, 50));
		
		btnOpcion_3 = new JButton("Ocio/Películas");
		btnOpcion_3.setFont(new Font("Roboto", Font.BOLD, 50));
		
		if(c.getModo() == true) {
			inicializarBotones();
			listModNiño();
			temporizador();
			timer.start();
		}
		else {
			btnOpcion_1.setBackground(Color.GREEN);
    		btnOpcion_2.setBackground(Color.GREEN);
    		btnOpcion_3.setBackground(Color.GREEN);
			listModMadre();
		}
			
		panel.add(panelOp, BorderLayout.CENTER);
		setVisible(true);
		this.c.addObserver(this);
		//PrincipalView padre = this;
		btnOpcion_1.requestFocus();
		this.setExtendedState(MAXIMIZED_BOTH);
		/*
		 * VOZ:
		 * actualmente solo disponible voz en inglï¿½s
		 * pasar texto a decir como parï¿½metro en el constructor
		 */
		voz = new Voz("Welcome to software communication app");
		voz.Reproducir();
		
	}
private void cerrarVentana() {
		// TODO Auto-generated method stub
		//this.c.removeObserver(this);
		this.setVisible(false);
}
private void temporizador(){
	timer = new Timer (c.getFrecuencia(), new ActionListener () 
	{ 
	    public void actionPerformed(ActionEvent e) 
	    { 
	    	if(vs1 == true){
	    		btnOpcion_2.requestFocus();
	    		btnOpcion_1.setBackground(Color.RED);
	    		btnOpcion_2.setBackground(Color.GREEN);
	    		vs1 = false;
	    		vs2 = true;
	    	}
	    	else if(vs2 == true){
	    		btnOpcion_3.requestFocus();
	    		btnOpcion_2.setBackground(Color.RED);
	    		btnOpcion_3.setBackground(Color.GREEN);
	    		vs2 = false;
	    		vs3 = true;
	    	}
	    	else if(vs3 == true){
	    		btnOpcion_1.requestFocus();
	    		btnOpcion_3.setBackground(Color.RED);
	    		btnOpcion_1.setBackground(Color.GREEN);
	    		vs3 = false;
	    		vs1 = true;
	    	}
	     } 
	}); 
}
public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
	}
public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
	c.setModo(m);
		if(m == false){
			listModMadre();
			btnOpcion_1.setBackground(Color.GREEN);
    		btnOpcion_2.setBackground(Color.GREEN);
    		btnOpcion_3.setBackground(Color.GREEN);
			timer.stop();
			t.enabledModo();
		} else{
			listModNiño();
			inicializarBotones();
			timer.start();
			t.disabledModo();
		}
		this.repaint();
	}
private void listModNiño(){
	
	btnOpcion_1.removeMouseListener(ml1);
	btnOpcion_2.removeMouseListener(ml2);
	btnOpcion_3.removeMouseListener(ml3);
	
	mgeneral = new MouseAdapter(){
		public void mouseClicked (MouseEvent e){
				mouseNiño();
		}
	};
	text.addMouseListener(mgeneral);
	contentPane.addMouseListener(mgeneral);
	panel.addMouseListener(mgeneral);
	panelOp.addMouseListener(mgeneral);
	btnOpcion_1.addMouseListener(mgeneral);
	btnOpcion_2.addMouseListener(mgeneral);
	btnOpcion_3.addMouseListener(mgeneral);
	
	kl1 = new KeyAdapter() {
	
		public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
			if(vs1 == true){
				timer.stop();
				cerrarVentana();
				c.onCambioOpcion(0);
				@SuppressWarnings("unused")
				Opcion1 v = new Opcion1(c,null);
			}
		}
	};
	btnOpcion_1.addKeyListener(kl1);
	

	kl2 = new KeyAdapter() {
		
		public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
			// TODO Auto-generated method stub
			
			if(vs2 == true){
				timer.stop();
				cerrarVentana();
				
				c.onCambioOpcion(0);
				@SuppressWarnings("unused")
				Opcion2 v = new Opcion2(c);
			}
		}
	};
	
	btnOpcion_2.addKeyListener(kl2);
	
	kl3 = new KeyAdapter() {
		
		public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
			
			if(vs3 == true){
				// TODO Auto-generated method stub
				timer.stop();
				cerrarVentana();
				c.onCambioOpcion(0);
				@SuppressWarnings("unused")
				Pelis v = new Pelis(c);
			}
		}
	};
	
	btnOpcion_3.addKeyListener(kl3);
}
private void listModMadre(){
	btnOpcion_1.removeKeyListener(kl1);
	btnOpcion_2.removeKeyListener(kl2);
	btnOpcion_3.removeKeyListener(kl3);
	text.removeMouseListener(mgeneral);
	contentPane.removeMouseListener(mgeneral);
	panel.removeMouseListener(mgeneral);
	panelOp.removeMouseListener(mgeneral);
	btnOpcion_1.removeMouseListener(mgeneral);
	btnOpcion_2.removeMouseListener(mgeneral);
	btnOpcion_3.removeMouseListener(mgeneral);
	
	ml1 = new MouseAdapter(){
		public void mouseClicked (MouseEvent e){
				mouseMadre(1);
		}
	};
	
	btnOpcion_1.addMouseListener(ml1);
	
	ml2 = new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
				timer.stop();
				cerrarVentana();
				c.onCambioOpcion(0);
				@SuppressWarnings("unused")
				Opcion2 v = new Opcion2(c);
		}
	};
		
	btnOpcion_2.addMouseListener(ml2);
	
	
	ml3 = new MouseAdapter() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
				timer.stop();
				cerrarVentana();
				c.onCambioOpcion(0);
				@SuppressWarnings("unused")
				Pelis v = new Pelis(c);
		}
		};
	btnOpcion_3.addMouseListener(ml3);
}
private void inicializarBotones(){
	
	btnOpcion_1.setBackground(Color.GREEN);
	panelOp.add(btnOpcion_1);
	vs1 = true;
	
	btnOpcion_2.setBackground(Color.RED);
	panelOp.add(btnOpcion_2);
	vs2 = false;
	
	btnOpcion_3.setBackground(Color.RED);
	panelOp.add(btnOpcion_3);
	vs3 = false;
}
public void onCambioFrecuencia(int f) {
	// TODO Auto-generated method stub
	c.setFrecuencia(f);
	temporizador();
}
public void mouseNiño(){
	//timer.stop();
	cerrarVentana();
	c.onCambioOpcion(0);
	Opcion1 v;
	Opcion2 v2;
	Pelis v3;
	if(vs1 == true)
	v = new Opcion1(c,this);
	else if(vs2 == true)
	v2 = new Opcion2(c);
	else
	v3 = new Pelis(c);	
}
@SuppressWarnings("unused")
public void mouseMadre(int n){
	//timer.stop();
	cerrarVentana();
	c.onCambioOpcion(0);
	Opcion1 v1;
	if(n == 1)
	v1 = new Opcion1(c,this);
}
@Override
public void atras() {
	// TODO Auto-generated method stub
	this.c.addObserver(this);
	this.setVisible(true);
}
}


