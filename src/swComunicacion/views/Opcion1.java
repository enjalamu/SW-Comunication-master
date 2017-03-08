package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Opcion1 extends JFrame implements Observer{

	private Timer timer;
	private JLabel pregunta;
	private JButton btnAtras = new JButton("Atrás");
	private JButton btnOpcion_1;
	private JButton btnOpcion_2;
	private JButton btnOpcion_3 = new JButton("Otra");
	private JButton btnOpcion_4 = new JButton("Otra");
	private boolean vs1;
	private boolean vs2;
	private boolean vs3;
	private boolean vs4;
	private boolean vsatras;
	private Controller c;
	private ImageIcon si;
	private ImageIcon no;
	private JTextField textSup;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private boolean editando;
	private JButton btnEditarOpciones;
	private JButton btnAdd;
	private JButton btnDel;
	private int iAdd = 0; 
	private ToolbarSup t;
	private KeyListener kl1;
	private KeyListener kl2;
	private KeyListener kl3;
	private KeyListener kl4;
	private KeyListener katras;
	private MouseListener ml1;
	private MouseListener ml2;
	private MouseListener ml3;
	private MouseListener ml4;
	private MouseListener matras;
	private MouseListener mgeneral;
	private JPanel panel;
	private JPanel contenido;
	private JPanel Sup;
	private JPanel Inf;
	private JPanel Med;
	public Opcion1(Controller controlador, JFrame padre) {
		this.c = controlador;
		setTitle("Opcion 1");
		this.si = new ImageIcon("src/imagenes/si.png");
		this.no = new ImageIcon("src/imagenes/no.png");
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBackground(Color.WHITE);
		panel.setBounds(100, 100, 450, 300);
		vs1 = true;
		vs2 = false;
		vs3 = false;
		vs4 = false;
		vsatras = false;
		temporizador();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 309);
		panel.setVisible(true);
		setContentPane(panel);
		editando = false;
		panel.setLayout(new BorderLayout(0, 0));
		
		contenido = new JPanel();
		contenido.setBackground(Color.WHITE);
		t = new ToolbarSup(c, 1, padre);
		panel.add(t, BorderLayout.NORTH);
		panel.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new GridLayout(3, 1, 0, 50));
		
		Sup = new JPanel();
		contenido.add(Sup);
		Sup.setBackground(Color.WHITE);
		Sup.setLayout(new GridLayout(2, 1, 0, 0));
		
		pregunta = new JLabel("Respuesta rápida");
		Sup.add(pregunta);
		pregunta.setHorizontalAlignment(SwingConstants.CENTER);
		pregunta.setFont(new Font("Roboto", Font.PLAIN, 40));
		textSup = new JTextField();
		textSup.setHorizontalAlignment(SwingConstants.CENTER);
		textSup.setFont(new Font("Roboto", Font.PLAIN, 40));
		Sup.add(textSup);
		textSup.setText(pregunta.getText());
		textSup.setColumns(10);
		textSup.setVisible(false);
		
		Med = new JPanel();
		contenido.add(Med);
		Med.setBackground(Color.WHITE);
		Med.setLayout(new GridLayout(1, 3, 20, 0));
		btnOpcion_1 = new JButton("SI");
		btnAtras.setFont(new Font("Roboto", Font.BOLD, 40));
		Med.add(btnAtras);
		Med.add(btnOpcion_1);
		btnOpcion_1.setFont(new Font("Roboto", Font.BOLD, 40));
		btnOpcion_1.setIcon(si);
		
		//Med.add(btnOpcion_3);
		btnOpcion_3.setFont(new Font("Roboto", Font.BOLD, 40));
		btnOpcion_3.setVisible(false);
		
		//Med.add(btnOpcion_4);
		btnOpcion_4.setFont(new Font("Roboto", Font.BOLD, 40));
		btnOpcion_4.setVisible(false);
		
		btnOpcion_2 = new JButton("NO");
		Med.add(btnOpcion_2);
		btnOpcion_2.setFont(new Font("Roboto", Font.BOLD, 40));
		btnOpcion_2.setIcon(no);
		
		text1 = new JTextField();
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		//Med.add(text1);
		text1.setText(btnOpcion_1.getText());
		text1.setColumns(10);
		text1.setVisible(false);
		text3 = new JTextField();
		text3.setHorizontalAlignment(SwingConstants.CENTER);
		text3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		//Med.add(text3);
		text3.setText(btnOpcion_3.getText());
		text3.setColumns(10);
		text3.setVisible(false);
		text4 = new JTextField();
		text4.setHorizontalAlignment(SwingConstants.CENTER);
		text4.setFont(new Font("Tahoma", Font.PLAIN, 40));
		//Med.add(text4);
		text4.setText(btnOpcion_4.getText());
		text4.setColumns(10);
		text4.setVisible(false);
		text2 = new JTextField();
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		//Med.add(text2);
		text2.setText(btnOpcion_2.getText());
		text2.setColumns(10);
		text2.setVisible(false);
		
		Inf = new JPanel();
		contenido.add(Inf);
		Inf.setBackground(Color.WHITE);
		Inf.setLayout(new GridLayout(0, 3, 400, 100));
			JLabel aux1 = new JLabel("");
			Inf.add(aux1);
			JLabel aux12 = new JLabel("");
			Inf.add(aux12);
				
				JLabel aux123 = new JLabel("");
				Inf.add(aux123);
			
				btnAdd = new JButton("Añadir Opción");
				btnAdd.setFont(new Font("Roboto", Font.PLAIN, 20));
				Inf.add(btnAdd);
				btnEditarOpciones = new JButton("Editar opciones");
				btnEditarOpciones.setFont(new Font("Roboto", Font.PLAIN, 20));
				Inf.add(btnEditarOpciones);
				btnDel = new JButton("Eliminar Opción");
				btnDel.setFont(new Font("Roboto", Font.PLAIN, 20));
				Inf.add(btnDel);
				
				// this.btnAdd.putClientProperty( SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
				/*botonPersonalizado bp = new botonPersonalizado("Rect", Color.darkGray, Color.gray,30,30);  
			    botonPersonalizado bp2 = new botonPersonalizado("Rect1", Color.MAGENTA, Color.gray,100,30); 
			    Inf.add(bp);
			   // Inf.add(bp2);*/
				btnEditarOpciones.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(editando == false){
						timer.stop();
						btnOpcion_2.setIcon(null);
						btnOpcion_1.setIcon(null);
						btnAtras.setBackground(Color.WHITE);
						textSup.setVisible(true);
						pregunta.setVisible(false);
						if(iAdd == 0){
							Med.remove(btnOpcion_1);
							Med.remove(btnOpcion_2);
							btnOpcion_1.setVisible(false);
							btnOpcion_2.setVisible(false);
							text1.setText(btnOpcion_1.getText());
							text2.setText(btnOpcion_2.getText());
							text1.setVisible(true);
							text2.setVisible(true);
							Med.add(text1); Med.add(text2);
						}
						else if(iAdd == 1){
							Med.remove(btnOpcion_1);
							Med.remove(btnOpcion_2);
							Med.remove(btnOpcion_3);
							btnOpcion_1.setVisible(false);
							btnOpcion_2.setVisible(false);
							btnOpcion_3.setVisible(false);
							text1.setText(btnOpcion_1.getText());
							text2.setText(btnOpcion_2.getText());
							text3.setText(btnOpcion_3.getText());
							text1.setVisible(true);
							text2.setVisible(true);
							text3.setVisible(true);
							Med.add(text1);  Med.add(text3); Med.add(text2);
						}
						else if(iAdd == 2){
							Med.remove(btnOpcion_1);
							Med.remove(btnOpcion_2);
							Med.remove(btnOpcion_3);
							Med.remove(btnOpcion_4);
							btnOpcion_1.setVisible(false);
							btnOpcion_2.setVisible(false);
							btnOpcion_3.setVisible(false);
							btnOpcion_4.setVisible(false);
							text1.setText(btnOpcion_1.getText());
							text2.setText(btnOpcion_2.getText());
							text3.setText(btnOpcion_3.getText());
							text4.setText(btnOpcion_4.getText());
							text1.setVisible(true);
							text2.setVisible(true);
							text3.setVisible(true);
							text4.setVisible(true);
							Med.add(text1);  Med.add(text3); Med.add(text4); Med.add(text2);
						}
						editando = true;
						btnAdd.setVisible(false);
						btnDel.setVisible(false);
						btnEditarOpciones.setText("Guardar");
						}
						else{
							btnEditarOpciones.setText("Editar opciones");
							pregunta.setText(textSup.getText());
							textSup.setVisible(false);
							pregunta.setVisible(true);
							if(iAdd == 0){
								Med.remove(text1);
								Med.remove(text2);
								text1.setVisible(false);
								text2.setVisible(false);
								btnOpcion_1.setText(text1.getText());
								btnOpcion_2.setText(text2.getText());
								btnOpcion_1.setVisible(true);
								btnOpcion_2.setVisible(true);
								Med.add(btnOpcion_1); Med.add(btnOpcion_2);
							}
							else if(iAdd == 1){
								Med.remove(text1);
								Med.remove(text2);
								Med.remove(text3);
								text1.setVisible(false);
								text2.setVisible(false);
								text3.setVisible(false);
								btnOpcion_1.setText(text1.getText());
								btnOpcion_2.setText(text2.getText());
								btnOpcion_3.setText(text3.getText());
								btnOpcion_1.setVisible(true);
								btnOpcion_2.setVisible(true);
								btnOpcion_3.setVisible(true);
								Med.add(btnOpcion_1); Med.add(btnOpcion_3); Med.add(btnOpcion_2);
							}
							else if(iAdd == 2){
								Med.remove(text1);
								Med.remove(text2);
								Med.remove(text3);
								Med.remove(text4);
								text1.setVisible(false);
								text2.setVisible(false);
								text3.setVisible(false);
								text4.setVisible(false);
								btnOpcion_1.setText(text1.getText());
								btnOpcion_2.setText(text2.getText());
								btnOpcion_3.setText(text3.getText());
								btnOpcion_4.setText(text4.getText());
								btnOpcion_1.setVisible(true);
								btnOpcion_2.setVisible(true);
								btnOpcion_3.setVisible(true);
								btnOpcion_4.setVisible(true);
								Med.add(btnOpcion_1); Med.add(btnOpcion_3); Med.add(btnOpcion_4); Med.add(btnOpcion_2);
							}
							editando = false;
							btnAdd.setVisible(true);
							btnDel.setVisible(true);
							btnOpcion_1.requestFocus();
						}
					}
				});
				btnAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (iAdd == 0){
							btnOpcion_1.setIcon(null);
							btnOpcion_2.setIcon(null);
							Med.setLayout(new GridLayout(1, 4, 20, 0));
							Med.remove(btnOpcion_1);
							Med.remove(btnOpcion_2);
							Med.add(btnOpcion_1);
							Med.add(btnOpcion_3);
							Med.add(btnOpcion_2);
							btnOpcion_1.setText("Opcion 1");
							btnOpcion_3.setText("Opcion 2");
							btnOpcion_2.setText("Opcion 3");
							btnOpcion_3.setVisible(true);
							iAdd++;
							btnDel.setEnabled(true);
						}
						else if(iAdd == 1){
							Med.setLayout(new GridLayout(1, 5, 20, 0));
							btnAdd.setEnabled(false);
							Med.remove(btnOpcion_2);
							Med.add(btnOpcion_4);
							Med.add(btnOpcion_2);
							btnOpcion_1.setText("Opcion 1");
							btnOpcion_3.setText("Opcion 2");
							btnOpcion_4.setText("Opcion 3");
							btnOpcion_2.setText("Opcion 4");
							btnOpcion_4.setVisible(true);
							iAdd++;
						}
						btnOpcion_1.requestFocus();
					}
				});
				btnDel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (iAdd == 1){
							btnOpcion_3.setVisible(false);
							btnOpcion_2.setText("Opcion 2");
							Med.setLayout(new GridLayout(1, 2, 20, 0));
							Med.remove(btnOpcion_3);
							btnDel.setEnabled(false);
							btnAdd.setEnabled(true);
							iAdd--;
						}
						else if(iAdd == 2){
							btnOpcion_4.setVisible(false);
							btnOpcion_2.setText("Opcion 3");
							btnOpcion_3.setText("Opcion 2");
							Med.setLayout(new GridLayout(1, 3, 20, 0));
							Med.remove(btnOpcion_4);
							btnAdd.setEnabled(true);
							iAdd--;
						}
						btnOpcion_1.requestFocus();
					}
				});
		
		if(c.getModo() == true){
			btnEditarOpciones.setEnabled(false);
			btnAdd.setEnabled(false);
			btnDel.setEnabled(false);
			btnAtras.setBackground(Color.RED);
			btnOpcion_1.setBackground(Color.GREEN);
			btnOpcion_2.setBackground(Color.RED);
			btnOpcion_3.setBackground(Color.RED);
			btnOpcion_4.setBackground(Color.RED);
			btnAtras.setEnabled(true);
			listModNiño();
			temporizador();
			timer.start();
		} else {
			btnEditarOpciones.setEnabled(true);
			btnAdd.setEnabled(true);
			btnDel.setEnabled(false);
			btnAtras.setVisible(true);
			btnAtras.setEnabled(false);
			btnAtras.setBackground(Color.WHITE);
			Med.setLayout(new GridLayout(1, 2, 20, 0));
			btnOpcion_1.setBackground(Color.GREEN);
			btnOpcion_2.setBackground(Color.GREEN);
			btnOpcion_3.setBackground(Color.GREEN);
			btnOpcion_4.setBackground(Color.GREEN);
			listModMadre();
		}
		this.setVisible(true);
		this.c.addObserver(this);
		btnOpcion_1.requestFocus();
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	private void temporizador(){
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if(iAdd == 0){
		    	if(vs1 == true){
		    		btnAtras.setBackground(Color.RED);
		    		btnOpcion_1.setBackground(Color.RED);
		    		btnOpcion_2.setBackground(Color.GREEN);
		    		vs1 = false;
		    		vs2 = true;
		    		vsatras = false;
		    		btnOpcion_2.requestFocus();
		    	}
		    	else if(vs2 == true){
		    		btnOpcion_2.setBackground(Color.RED);
		    		btnAtras.setBackground(Color.GREEN);
		    		btnOpcion_1.setBackground(Color.RED);
		    		vs2 = false;
		    		vs1 = false;
		    		vsatras = true;
		    		btnAtras.requestFocus();
		    	}
		    	else if(vsatras == true){
		    		btnOpcion_2.setBackground(Color.RED);
		    		btnAtras.setBackground(Color.RED);
		    		btnOpcion_1.setBackground(Color.GREEN);
		    		vs2 = false;
		    		vs1 = true;
		    		vsatras = false;
		    		btnOpcion_1.requestFocus();
		    	}
		     }
		    	else{
		    		if(iAdd == 1){
		    		if(vs1 == true){
			    		btnOpcion_1.setBackground(Color.RED);
			    		btnOpcion_3.setBackground(Color.GREEN);
			    		btnOpcion_2.setBackground(Color.RED);
			    		btnAtras.setBackground(Color.RED);
			    		vs1 = false;
			    		vs3 = true;
			    		vs2 = false;
			    		vsatras = false;
			    		btnOpcion_3.requestFocus();
			    	}
			    	else if(vs3 == true){
			    		btnOpcion_1.setBackground(Color.RED);
			    		btnOpcion_3.setBackground(Color.RED);
			    		btnOpcion_2.setBackground(Color.GREEN);
			    		btnAtras.setBackground(Color.RED);
			    		vs1 = false;
			    		vs3 = false;
			    		vs2 = true;
			    		vsatras = false;
			    		btnOpcion_2.requestFocus();
			    	}
			    	else if(vs2 == true){
			    		btnOpcion_1.setBackground(Color.RED);
			    		btnOpcion_3.setBackground(Color.RED);
			    		btnOpcion_2.setBackground(Color.RED);
			    		btnAtras.setBackground(Color.GREEN);
			    		vs1 = false;
			    		vs3 = false;
			    		vs2 = false;
			    		vsatras = true;
			    		btnAtras.requestFocus();
			    	}
			    	else if(vsatras == true){
			    		btnOpcion_1.setBackground(Color.GREEN);
			    		btnOpcion_3.setBackground(Color.RED);
			    		btnOpcion_2.setBackground(Color.RED);
			    		btnAtras.setBackground(Color.RED);
			    		vs1 = true;
			    		vs3 = false;
			    		vs2 = false;
			    		vsatras = false;
			    		btnOpcion_1.requestFocus();
			    	}
		    		}
		    		else if(iAdd == 2){
		    			if(vs1 == true){
				    		btnOpcion_1.setBackground(Color.RED);
				    		btnOpcion_3.setBackground(Color.GREEN);
				    		btnOpcion_4.setBackground(Color.RED);
				    		btnOpcion_2.setBackground(Color.RED);
				    		btnAtras.setBackground(Color.RED);
				    		vsatras = false;
				    		vs1 = false;
				    		vs3 = true;
				    		vs4 = false;
				    		vs2 = false;
				    		btnOpcion_3.requestFocus();
				    	}
				    	else if(vs3 == true){
				    		btnOpcion_1.setBackground(Color.RED);
				    		btnOpcion_3.setBackground(Color.RED);
				    		btnOpcion_4.setBackground(Color.GREEN);
				    		btnOpcion_2.setBackground(Color.RED);
				    		btnAtras.setBackground(Color.RED);
				    		vsatras = false;
				    		vs1 = false;
				    		vs3 = false;
				    		vs4 = true;
				    		vs2 = false;
				    		btnOpcion_4.requestFocus();
				    	}
				    	else if(vs4 == true){
				    		btnOpcion_1.setBackground(Color.RED);
				    		btnOpcion_3.setBackground(Color.RED);
				    		btnOpcion_4.setBackground(Color.RED);
				    		btnOpcion_2.setBackground(Color.GREEN);
				    		btnAtras.setBackground(Color.RED);
				    		vsatras = false;
				    		vs1 = false;
				    		vs3 = false;
				    		vs4 = false;
				    		vs2 = true;
				    		btnOpcion_2.requestFocus();
				    	}
				    	else if(vs2 == true){
				    		btnOpcion_1.setBackground(Color.RED);
				    		btnOpcion_3.setBackground(Color.RED);
				    		btnOpcion_4.setBackground(Color.RED);
				    		btnOpcion_2.setBackground(Color.RED);
				    		btnAtras.setBackground(Color.GREEN);
				    		vsatras = true;
				    		vs1 = false;
				    		vs3 = false;
				    		vs4 = false;
				    		vs2 = false;
				    		btnAtras.requestFocus();
				    	}
				    	else if(vsatras == true){
				    		btnOpcion_1.setBackground(Color.GREEN);
				    		btnOpcion_3.setBackground(Color.RED);
				    		btnOpcion_4.setBackground(Color.RED);
				    		btnOpcion_2.setBackground(Color.RED);
				    		btnAtras.setBackground(Color.RED);
				    		vsatras = false;
				    		vs1 = true;
				    		vs3 = false;
				    		vs4 = false;
				    		vs2 = false;
				    		btnOpcion_1.requestFocus();
				    	}
		    		}
		    	}
		    }
		}); 
	}
	
	private void listModNiño(){
		
		btnOpcion_1.removeMouseListener(ml1);
		btnOpcion_2.removeMouseListener(ml2);
		btnOpcion_3.removeMouseListener(ml3);
		btnOpcion_4.removeMouseListener(ml4);
		btnAtras.removeMouseListener(matras);
		mgeneral = new MouseAdapter(){
			public void mouseClicked (MouseEvent e){
					mouseNiño();
			}
		};
		//text.addMouseListener(mgeneral);
		panel.addMouseListener(mgeneral);
		contenido.addMouseListener(mgeneral);
		Sup.addMouseListener(mgeneral);
		Med.addMouseListener(mgeneral);
		Inf.addMouseListener(mgeneral);
		pregunta.addMouseListener(mgeneral);
		this.btnOpcion_1.addMouseListener(mgeneral);
		this.btnOpcion_2.addMouseListener(mgeneral);
		this.btnOpcion_3.addMouseListener(mgeneral);
		this.btnOpcion_4.addMouseListener(mgeneral);
		this.btnAtras.addMouseListener(mgeneral);
		this.btnAdd.addMouseListener(mgeneral);
		this.btnDel.addMouseListener(mgeneral);
		this.btnEditarOpciones.addMouseListener(mgeneral);
		kl1 = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { //al pulsar cualquier tecla
				timer.stop();
				if(vs1 == true){
					JOptionPane.showMessageDialog(null,btnOpcion_1.getText(), "Seleccion", 0, si); 
				}
				timer.restart();
			}			
		};
		btnOpcion_1.addKeyListener(kl1);
		
		kl2 = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				timer.stop();
				if(vs2 == true){
					JOptionPane.showMessageDialog(null,btnOpcion_2.getText(), "Seleccion", 0, si);
				}
				timer.restart();
			}
		};
		btnOpcion_2.addKeyListener(kl2);
		
		kl3 = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				timer.stop();
				if(vs3 == true){
					JOptionPane.showMessageDialog(null,btnOpcion_3.getText(), "Seleccion", 0, si);
				}
				timer.restart();
			}
		};
		btnOpcion_3.addKeyListener(kl3);
		
		kl4 = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				timer.stop();
				if(vs4 == true){
					JOptionPane.showMessageDialog(null,btnOpcion_4.getText(), "Seleccion", 0, si);
				}
				timer.restart();
			}
		};
		btnOpcion_4.addKeyListener(kl4);
		katras = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				timer.stop();
				if(vsatras == true){
					if(btnAtras.isEnabled()){
						//c.onCambioOpcion(op);
						c.onCambioVentanaAtras();
						}
				}
				timer.restart();
			}
		};
		btnAtras.addKeyListener(katras);
	}
	
	private void listModMadre(){
		btnOpcion_1.removeKeyListener(kl1);
		btnOpcion_2.removeKeyListener(kl2);
		btnOpcion_3.removeKeyListener(kl3);
		btnOpcion_4.removeKeyListener(kl4);
		btnAtras.removeKeyListener(katras);
		panel.removeMouseListener(mgeneral);
		contenido.removeMouseListener(mgeneral);
		Sup.removeMouseListener(mgeneral);
		Med.removeMouseListener(mgeneral);
		Inf.removeMouseListener(mgeneral);
		pregunta.removeMouseListener(mgeneral);
		this.btnOpcion_1.removeMouseListener(mgeneral);
		this.btnOpcion_2.removeMouseListener(mgeneral);
		this.btnOpcion_3.removeMouseListener(mgeneral);
		this.btnOpcion_4.removeMouseListener(mgeneral);
		this.btnAtras.removeMouseListener(mgeneral);
		this.btnAdd.removeMouseListener(mgeneral);
		this.btnDel.removeMouseListener(mgeneral);
		this.btnEditarOpciones.removeMouseListener(mgeneral);
		
		ml1 = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al pulsar cualquier tecla
				timer.stop();
					JOptionPane.showMessageDialog(null,btnOpcion_1.getText(), "Seleccion", 0, si); 
			}			
		};
		btnOpcion_1.addMouseListener(ml1);
		
		ml2 = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al pulsar cualquier tecla
				timer.stop();
					JOptionPane.showMessageDialog(null,btnOpcion_2.getText(), "Seleccion", 0, si); 
			}			
		};
		btnOpcion_2.addMouseListener(ml2);
		
		ml3 = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al pulsar cualquier tecla
				timer.stop();
					JOptionPane.showMessageDialog(null,btnOpcion_3.getText(), "Seleccion", 0, si); 
			}			
		};
		btnOpcion_3.addMouseListener(ml3);
		
		ml4 = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al pulsar cualquier tecla
				timer.stop();
					JOptionPane.showMessageDialog(null,btnOpcion_4.getText(), "Seleccion", 0, si); 
			}			
		};
		btnOpcion_4.addMouseListener(ml4);
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
		if(c.getModo() == false){
			btnAtras.setEnabled(false);
			btnEditarOpciones.setEnabled(true);
			btnAdd.setEnabled(true);
			btnOpcion_1.setBackground(Color.GREEN);
			btnOpcion_2.setBackground(Color.GREEN);
			btnOpcion_3.setBackground(Color.GREEN);
			btnOpcion_4.setBackground(Color.GREEN);
			btnAtras.setBackground(Color.WHITE);
			listModMadre();
			t.enabledModo();
			timer.stop();
		} else{
			btnAtras.setVisible(true);
			btnAtras.setEnabled(true);
			btnEditarOpciones.setEnabled(false);
			btnAdd.setEnabled(false);
			btnOpcion_1.setBackground(Color.GREEN);
			btnOpcion_2.setBackground(Color.RED);
			btnOpcion_3.setBackground(Color.RED);
			btnOpcion_4.setBackground(Color.RED);
			btnAtras.setBackground(Color.RED);
			listModNiño();
			t.disabledModo();
			timer.start();
		}
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		/*c.setFrecuencia(f);
		temporizador();*/
	}

	@Override
	public void mouseNiño() {
		// TODO Auto-generated method stub
		timer.stop();
		if(vs1 == true){
			JOptionPane.showMessageDialog(null,btnOpcion_1.getText(), "Seleccion", 0, si);
		}
		else if(vs2 == true){
			JOptionPane.showMessageDialog(null,btnOpcion_2.getText(), "Seleccion", 0, si);
		}
		else if(vs3 == true){
			JOptionPane.showMessageDialog(null,btnOpcion_3.getText(), "Seleccion", 0, si);
		}
		else if(vs4 == true){
			JOptionPane.showMessageDialog(null,btnOpcion_4.getText(), "Seleccion", 0, si);
		}
		else if(vsatras == true){
			if(btnAtras.isEnabled()){
				//c.onCambioOpcion(op);
				c.onCambioVentanaAtras();
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
