package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Opcion3 extends JFrame implements Observer{

	private JPanel contentPane;
	private Controller c;
	private JPanel aux;
	private JButton btn2;
	private JButton btn1;
	private JButton btn4;
	private JButton btn3;
	private boolean vs1;
	private boolean vs2;
	private boolean vs3;
	private boolean vs4;
	private Timer timer;
	private ToolbarSup t;
	//private Image tv;
	//private Graphics g;
	//TV, MUSICA, BAï¿½O, TAREAS
	
	public Opcion3(Controller controlador) {
		this.c = controlador;
		setTitle("Opcion 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		t = new ToolbarSup(c, 3,null);
		contentPane.add(t, BorderLayout.NORTH);
		aux = new JPanel();
		aux.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		getContentPane().add(aux, BorderLayout.CENTER);
		aux.setLayout(new GridLayout(2, 2, 10, 10));
		
		btn1 = new JButton("TV");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn1.setBackground(Color.GREEN);
		aux.add(btn1);
		vs1 = true;
		
		btn2 = new JButton("Musica");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn2.setBackground(Color.RED);
		aux.add(btn2);
		vs2 = false;
		
		btn4 = new JButton("Baï¿½o");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn4.setBackground(Color.RED);
		aux.add(btn4);
		vs4 = false;
		
		btn3 = new JButton("Tareas");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn3.setBackground(Color.RED);
		aux.add(btn3);
		vs3 = false;
		
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	/*
		    	 * 1-1 4-2 3-3
		    	 * TV-MUSICA-TAREAS-BAï¿½O
		    	 */
		    	if(vs1 == true){
		    		btn2.requestFocus();
		    		btn1.setBackground(Color.RED);
		    		btn2.setBackground(Color.GREEN);
		    		vs1 = false;
		    		vs2 = true;
		    	}
		    	else if(vs2 == true){
		    		btn3.requestFocus();
		    		btn2.setBackground(Color.RED);
		    		btn3.setBackground(Color.GREEN);
		    		vs2 = false;
		    		vs3 = true;
		    	}
		    	else if(vs3 == true){
		    		btn4.requestFocus();
		    		btn3.setBackground(Color.RED);
		    		btn4.setBackground(Color.GREEN);
		    		vs3 = false;
		    		vs4 = true;
		    	}
		    	else if(vs4 == true){
		    		btn1.requestFocus();
		    		btn4.setBackground(Color.RED);
		    		btn1.setBackground(Color.GREEN);
		    		vs4 = false;
		    		vs1 = true;
		    	}
		    	
		     } 
		}); 
		
		btn1.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
				if(vs1 == true){
					timer.stop();
					onCambioOpcion(3);
					new Pelis(c);
				}
			}
			});
		btn1.requestFocus();
		timer.start();
		this.setVisible(true);
		this.c.addObserver(this);
		this.setExtendedState(MAXIMIZED_BOTH);
	}


	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op == 3){
			this.c.removeObserver(this);
			this.setVisible(false);
			new PrincipalView(c);
		}
	}


	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		c.setModo(m);
	}


	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseNiño() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void atras() {
		// TODO Auto-generated method stub
		
	}

}
