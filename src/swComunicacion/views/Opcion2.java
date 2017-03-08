package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import swComunicacion.Controller;
import swComunicacion.Observer;
import swComunicacion.Voz;
//import swComunicacion.VozEs;

public class Opcion2 extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private LinkedList<Boolean> bBotones;
	private LinkedList<JButton> botones;
	private JPanel contentPane;
	private Timer timer;
	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;
	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnEnie;
	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;
	private ToolbarSup t;
	private Controller c;
	private int it;
	private JButton button_2;
	private JButton button_3;
	private JButton button;
	private int act;
	private MouseListener mGeneral;
	private KeyAdapter ka;
	private JPanel Letras;
	private JPanel panel;
	
	public Opcion2(Controller controlador) {
		this.c = controlador;
		setTitle("Opcion 2");
		act = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		botones = new LinkedList<JButton>();
		bBotones = new LinkedList<Boolean>();
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		t = new ToolbarSup(c, 2,null);
		contentPane.add(t, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		
		bBotones.add(true);
		for(int i=1; i<33;i++){		
			bBotones.add(false);
		}
		panel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setRows(2);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 50));
		textArea.setEditable(true);
		textArea.setFocusable(false);
		panel.add(textArea, BorderLayout.NORTH);
		
		
		ka = new KeyAdapter() {
			public void keyPressed(KeyEvent e) { 
				timer.stop();
				if(bBotones.get(1)==true)
					escribe(0);
				if(bBotones.get(2)==true)
					escribe(1);
				if(bBotones.get(3)==true)
					escribe(2);
				if(bBotones.get(4)==true)
					escribe(3);
				if(bBotones.get(5)==true)
					escribe(4);
				if(bBotones.get(6)==true)
					escribe(5);
				if(bBotones.get(7)==true)
					escribe(6);
				if(bBotones.get(8)==true)
					escribe(7);
				if(bBotones.get(9)==true)
					escribe(8);
				if(bBotones.get(10)==true)
					escribe(9);
				if(bBotones.get(11)==true)
					escribe(10);
				if(bBotones.get(12)==true)
					escribe(11);
				if(bBotones.get(13)==true)
					escribe(12);
				if(bBotones.get(14)==true)
					escribe(13);
				if(bBotones.get(15)==true)
					escribe(14);
				if(bBotones.get(16)==true)
					escribe(15);
				if(bBotones.get(17)==true)
					escribe(16);
				if(bBotones.get(18)==true)
					escribe(17);
				if(bBotones.get(19)==true)
					escribe(18);
				if(bBotones.get(20)==true)
					escribe(19);
				if(bBotones.get(21)==true)
					escribe(20);
				if(bBotones.get(22)==true)
					escribe(21);
				if(bBotones.get(23)==true)
					escribe(22);
				if(bBotones.get(24)==true)
					escribe(23);
				if(bBotones.get(25)==true)
					escribe(24);
				if(bBotones.get(26)==true)
					escribe(25);
				if(bBotones.get(27)==true)
					escribe(26);
				if(bBotones.get(28)==true)
					escribe(27);
				if(bBotones.get(29)==true)
					escribe(28);
				if(bBotones.get(30)==true)
					escribe(29);
				if(bBotones.get(31)==true)
					escribe(30);
				if(bBotones.get(32)==true)
					escribe(31);
//					textArea.setText(textArea.getText().substring(0, (textArea.getText().length()-1)));
//				if(bBotones.get(0)==true)
//					textArea.append(botones.get(32).getText());
//					
				timer.restart();
			}			
		};
		
		Letras = new JPanel();
		Letras.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(Letras, BorderLayout.CENTER);
		Letras.setLayout(new GridLayout(3, 10, 30, 100));
		
		qwertyLetters(ka, Letras);
		
//		button_1 = new JButton("<- inicio");
//		button_1.addKeyListener(ka);
//		button_1.addMouseListener(mGeneral);
//		Letras.add(button_1);
//		button_1.setFont(new Font("arial",Font.PLAIN,20)); 
//		botones.add(button_1);
		
//		button_3 = new JButton("ESPACIO");
//		button_3.addKeyListener(ka);
//		button_3.addMouseListener(mGeneral);
//		Letras.add(button_3);
//		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
//		botones.add(button_3);
//		
//		button = new JButton("BORRAR");
//		Letras.add(button);
//		button.setFont(new Font("arial",Font.PLAIN,20)); 
//		button.addKeyListener(ka);
//		button.addMouseListener(mGeneral);
//		botones.add(button);
		
		temporizador();
		
		if(c.getModo() == true) {
			timer.start();
			btnE.requestFocus();
		}
		else {
			textArea.setFocusable(true);
			textArea.requestFocus();
		}
		
		mGeneral = new MouseAdapter(){
			public void mouseClicked (MouseEvent e){
					mouseNiño();
			}
		};
		contentPane.addMouseListener(mGeneral);
		textArea.addMouseListener(mGeneral);
		this.c.addObserver(this);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);	
	}

	private void mostUsedLetters(KeyAdapter ka, JPanel Letras) {
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,100)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,100)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,100)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,100)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,100)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,100)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,100)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,100)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,100)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
		
	
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,100)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
			
		button_2 = new JButton("<- inicio");
		button_2.addKeyListener(ka);
		button_2.addMouseListener(mGeneral);
		Letras.add(button_2);
		button_2.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_2);
		
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,100)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,100)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,100)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,100)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,100)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,100)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,100)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,100)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
			
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
		
			
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,100)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);
	
		button_2 = new JButton("<- inicio");
		button_2.addKeyListener(ka);
		button_2.addMouseListener(mGeneral);
		Letras.add(button_2);
		button_2.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_2);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,100)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,100)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,100)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,100)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,100)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		this.setVisible(true);
		
		button_3 = new JButton("ESPACIO");
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
		Letras.add(button_3);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
		
	}

	private void qwertyLetters(KeyAdapter ka, JPanel Letras) {
		
		btnQ = new JButton("Q");
		Letras.add(btnQ);
		btnQ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnQ.addKeyListener(ka);
		btnQ.addMouseListener(mGeneral);
		botones.add(btnQ);
		
		btnW = new JButton("W");
		Letras.add(btnW);
		btnW.setFont(new Font("arial",Font.PLAIN,100)); 
		btnW.addKeyListener(ka);
		btnW.addMouseListener(mGeneral);
		botones.add(btnW);
		
		btnE = new JButton("E");
		Letras.add(btnE);
		btnE.setFont(new Font("arial",Font.PLAIN,100)); 
		btnE.addKeyListener(ka);
		btnE.addMouseListener(mGeneral);
		botones.add(btnE);
		
		btnR = new JButton("R");
		Letras.add(btnR);
		btnR.setFont(new Font("arial",Font.PLAIN,100)); 
		btnR.addKeyListener(ka);
		btnR.addMouseListener(mGeneral);
		botones.add(btnR);
				
		btnT = new JButton("T");
		Letras.add(btnT);
		btnT.setFont(new Font("arial",Font.PLAIN,100)); 
		btnT.addKeyListener(ka);
		btnT.addMouseListener(mGeneral);
		botones.add(btnT);
		
		btnY = new JButton("Y");
		Letras.add(btnY);
		btnY.setFont(new Font("arial",Font.PLAIN,100)); 
		btnY.addKeyListener(ka);
		btnY.addMouseListener(mGeneral);
		botones.add(btnY);
		
		btnU = new JButton("U");
		Letras.add(btnU);
		btnU.setFont(new Font("arial",Font.PLAIN,100)); 
		btnU.addKeyListener(ka);
		btnU.addMouseListener(mGeneral);
		botones.add(btnU);
		
		btnI = new JButton("I");
		Letras.add(btnI);
		btnI.setFont(new Font("arial",Font.PLAIN,100)); 
		btnI.addKeyListener(ka);
		btnI.addMouseListener(mGeneral);
		botones.add(btnI);
	
		btnO = new JButton("O");
		Letras.add(btnO);
		btnO.setFont(new Font("arial",Font.PLAIN,100)); 
		btnO.addKeyListener(ka);
		btnO.addMouseListener(mGeneral);
		botones.add(btnO);
		
		btnP = new JButton("P");
		Letras.add(btnP);
		btnP.setFont(new Font("arial",Font.PLAIN,100)); 
		btnP.addKeyListener(ka);
		btnP.addMouseListener(mGeneral);
		botones.add(btnP);
		
		btnA = new JButton("A");
		Letras.add(btnA);
		btnA.setFont(new Font("arial",Font.PLAIN,100)); 
		btnA.addKeyListener(ka);
		btnA.addMouseListener(mGeneral);
		botones.add(btnA);
		
		btnS = new JButton("S");
		Letras.add(btnS);
		btnS.setFont(new Font("arial",Font.PLAIN,100)); 
		btnS.addKeyListener(ka);
		btnS.addMouseListener(mGeneral);
		botones.add(btnS);
		
		btnD = new JButton("D");
		Letras.add(btnD);
		btnD.setFont(new Font("arial",Font.PLAIN,100)); 
		btnD.addKeyListener(ka);
		btnD.addMouseListener(mGeneral);
		botones.add(btnD);
		
		btnF = new JButton("F");
		Letras.add(btnF);
		btnF.setFont(new Font("arial",Font.PLAIN,100)); 
		btnF.addKeyListener(ka);
		btnF.addMouseListener(mGeneral);
		botones.add(btnF);
		
		btnG = new JButton("G");
		Letras.add(btnG);
		btnG.setFont(new Font("arial",Font.PLAIN,100)); 
		btnG.addKeyListener(ka);
		btnG.addMouseListener(mGeneral);
		botones.add(btnG);
		
		btnH = new JButton("H");
		Letras.add(btnH);
		btnH.setFont(new Font("arial",Font.PLAIN,100)); 
		btnH.addKeyListener(ka);
		btnH.addMouseListener(mGeneral);
		botones.add(btnH);
		
		btnJ = new JButton("J");
		Letras.add(btnJ);
		btnJ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnJ.addKeyListener(ka);
		btnJ.addMouseListener(mGeneral);
		botones.add(btnJ);
		
		btnK = new JButton("K");
		Letras.add(btnK);
		btnK.setFont(new Font("arial",Font.PLAIN,100)); 
		btnK.addKeyListener(ka);
		btnK.addMouseListener(mGeneral);
		botones.add(btnK);
		
		btnL = new JButton("L");
		Letras.add(btnL);
		btnL.setFont(new Font("arial",Font.PLAIN,100)); 
		btnL.addKeyListener(ka);
		btnL.addMouseListener(mGeneral);
		botones.add(btnL);
		
		btnEnie = new JButton("\u00D1");
		Letras.add(btnEnie);
		btnEnie.setFont(new Font("arial",Font.PLAIN,100)); 
		btnEnie.addKeyListener(ka);
		btnEnie.addMouseListener(mGeneral);
		botones.add(btnEnie);
		
		btnZ = new JButton("Z");
		Letras.add(btnZ);
		btnZ.setFont(new Font("arial",Font.PLAIN,100)); 
		btnZ.addKeyListener(ka);
		btnZ.addMouseListener(mGeneral);
		botones.add(btnZ);
		
		btnX = new JButton("X");
		Letras.add(btnX);
		btnX.setFont(new Font("arial",Font.PLAIN,100)); 
		btnX.addKeyListener(ka);
		btnX.addMouseListener(mGeneral);
		botones.add(btnX);
		
		btnC = new JButton("C");
		Letras.add(btnC);
		btnC.setFont(new Font("arial",Font.PLAIN,100)); 
		btnC.addKeyListener(ka);
		btnC.addMouseListener(mGeneral);
		botones.add(btnC);
		
		btnV = new JButton("V");
		Letras.add(btnV);
		btnV.setFont(new Font("arial",Font.PLAIN,100)); 
		btnV.addKeyListener(ka);
		btnV.addMouseListener(mGeneral);
		botones.add(btnV);
		
		btnB = new JButton("B");
		Letras.add(btnB);
		btnB.setFont(new Font("arial",Font.PLAIN,100)); 
		btnB.addKeyListener(ka);
		btnB.addMouseListener(mGeneral);
		botones.add(btnB);
		
		btnN = new JButton("N");
		Letras.add(btnN);
		btnN.setFont(new Font("arial",Font.PLAIN,100)); 
		btnN.addKeyListener(ka);
		btnN.addMouseListener(mGeneral);
		botones.add(btnN);
		
		btnM = new JButton("M");
		Letras.add(btnM);
		btnM.setFont(new Font("arial",Font.PLAIN,100)); 
		btnM.addKeyListener(ka);
		btnM.addMouseListener(mGeneral);
		botones.add(btnM);
		
		button_3 = new JButton("ESPACIO");
		button_3.addKeyListener(ka);
		button_3.addMouseListener(mGeneral);
		
		
		button = new JButton("BORRAR");
		Letras.add(button);
		button.setFont(new Font("arial",Font.PLAIN,20)); 
		button.addKeyListener(ka);
		button.addMouseListener(mGeneral);
		botones.add(button);
		Letras.add(button_3);
		button_3.setFont(new Font("arial",Font.PLAIN,20)); 
		botones.add(button_3);
			
		
		this.setVisible(true);
	}

	private void temporizador(){
		timer = new Timer (c.getFrecuencia(), new ActionListener () 
		{ 
			private Voz voz;
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	
		    	for(int i=0; i<botones.size();i++){		    		
		    		if(bBotones.get(i) == true){
		    			botones.get(i).setBackground(Color.GREEN);
		    			
		    			try {		    				
		    				voz = new Voz(botones.get(i).getText());
							voz.Reproducir();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    			
		    			act=i;
		    			it = act;
		    		}
		    		else if(bBotones.get(i) == false){
		    			botones.get(i).setBackground(null);	    			
		    		}
		    		
		    	}
		    	bBotones.set(act, false);		    	
		    	if (act==32)act=-1;		    	
		    	bBotones.set((act+1), true);

		    } 
		}); 
	}
	
	public void onCambioModo(boolean mod) {
		// TODO Auto-generated method stub
		c.setModo(mod);
		if(mod == false){
			timer.stop();
			botones.get(it).setBackground(null);	 
			textArea.setFocusable(true);
			textArea.requestFocus();
			t.enabledModo();
			
			Letras.removeAll();
			Letras = new JPanel();
			Letras.setBorder(new EmptyBorder(10, 10, 10, 10));
			panel.add(Letras, BorderLayout.CENTER);
			Letras.setLayout(new GridLayout(3, 10, 30, 100));
			botones.removeAll(botones);
			
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Desea cambiar tipo de teclado?",
		            "QWERTY -> LETRAS COMUNES",
		            JOptionPane.YES_NO_OPTION);

		        if(n == 0){	
		        	mostUsedLetters(ka, Letras);
		        	
		        }
		        else {	        	
		        	qwertyLetters(ka, Letras);
		        }

		} else{
			timer.start();
			botones.get(it).requestFocus();
			textArea.setFocusable(false);
			t.disabledModo();
		}
		//DESHABILITAR TECLADO Y QUE ESCRIBA LA PALABRA EN EL JTEXTAREA
	}

	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		if(op ==2){
			this.c.removeObserver(this);
			this.setVisible(false);
			new PrincipalView(c);
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
		if(bBotones.get(1)==true)
			textArea.append("e");
		if(bBotones.get(2)==true)
			textArea.append("a");
		if(bBotones.get(3)==true)
			textArea.append("o");
		if(bBotones.get(4)==true)
			textArea.append("s");
		if(bBotones.get(5)==true)
			textArea.append("r");
		if(bBotones.get(6)==true)
			textArea.append("n");
		if(bBotones.get(7)==true)
			textArea.append("i");
		if(bBotones.get(8)==true)
			textArea.append("d");
		if(bBotones.get(9)==true)
			textArea.append("l");
		if(bBotones.get(10)==true){
			bBotones.set(10, false);
			bBotones.set(0, true);
		}
		if(bBotones.get(11)==true)
			textArea.append("\u0020");
		if(bBotones.get(12)==true)
			textArea.append("c");
		if(bBotones.get(13)==true)
			textArea.append("t");
		if(bBotones.get(14)==true)
			textArea.append("u");
		if(bBotones.get(15)==true)
			textArea.append("m");
		if(bBotones.get(16)==true)
			textArea.append("p");
		if(bBotones.get(17)==true)
			textArea.append("b");
		if(bBotones.get(18)==true)
			textArea.append("g");
		if(bBotones.get(19)==true)
			textArea.append("v");
		if(bBotones.get(20)==true)
			textArea.append("y");
		if(bBotones.get(21)==true){
			bBotones.set(21, false);
			bBotones.set(11, true);
		}
		if(bBotones.get(22)==true)
			textArea.append("\u0020");
		if(bBotones.get(23)==true)
			textArea.append("q");
		if(bBotones.get(24)==true)
			textArea.append("h");
		if(bBotones.get(25)==true)
			textArea.append("f");
		if(bBotones.get(26)==true)
			textArea.append("z");
		if(bBotones.get(27)==true)
			textArea.append("j");
		if(bBotones.get(28)==true)
			textArea.append("\u00D1");
		if(bBotones.get(29)==true)
			textArea.append("k");
		if(bBotones.get(30)==true)
			textArea.append("w");
		if(bBotones.get(31)==true)
			textArea.append("x");
		if(bBotones.get(32)==true)
			textArea.setText(textArea.getText().substring(0, (textArea.getText().length()-1)));
		if(bBotones.get(0)==true)
			textArea.append("\u0020");
			
		timer.restart();
	}
	
	private void escribe(int i){
		
		if(botones.get(i).getText().equalsIgnoreCase("A"))
			textArea.append("A");
		if(botones.get(i).getText().equalsIgnoreCase("B"))
			textArea.append("B");
		if(botones.get(i).getText().equalsIgnoreCase("C"))
			textArea.append("C");
		if(botones.get(i).getText().equalsIgnoreCase("D"))
			textArea.append("D");
		if(botones.get(i).getText().equalsIgnoreCase("E"))
			textArea.append("E");
		if(botones.get(i).getText().equalsIgnoreCase("F"))
			textArea.append("F");
		if(botones.get(i).getText().equalsIgnoreCase("G"))
			textArea.append("G");
		if(botones.get(i).getText().equalsIgnoreCase("H"))
			textArea.append("H");
		if(botones.get(i).getText().equalsIgnoreCase("I"))
			textArea.append("I");
		if(botones.get(i).getText().equalsIgnoreCase("J"))
			textArea.append("J");
		if(botones.get(i).getText().equalsIgnoreCase("K"))
			textArea.append("K");
		if(botones.get(i).getText().equalsIgnoreCase("L"))
			textArea.append("L");
		if(botones.get(i).getText().equalsIgnoreCase("M"))
			textArea.append("M");
		if(botones.get(i).getText().equalsIgnoreCase("N"))
			textArea.append("N");
		if(botones.get(i).getText().equalsIgnoreCase("Ñ"))
			textArea.append("Ñ");
		if(botones.get(i).getText().equalsIgnoreCase("O"))
			textArea.append("O");
		if(botones.get(i).getText().equalsIgnoreCase("P"))
			textArea.append("P");
		if(botones.get(i).getText().equalsIgnoreCase("Q"))
			textArea.append("Q");
		if(botones.get(i).getText().equalsIgnoreCase("R"))
			textArea.append("R");
		if(botones.get(i).getText().equalsIgnoreCase("S"))
			textArea.append("S");
		if(botones.get(i).getText().equalsIgnoreCase("T"))
			textArea.append("T");
		if(botones.get(i).getText().equalsIgnoreCase("U"))
			textArea.append("U");
		if(botones.get(i).getText().equalsIgnoreCase("V"))
			textArea.append("V");
		if(botones.get(i).getText().equalsIgnoreCase("W"))
			textArea.append("W");
		if(botones.get(i).getText().equalsIgnoreCase("X"))
			textArea.append("X");
		if(botones.get(i).getText().equalsIgnoreCase("Y"))
			textArea.append("Y");
		if(botones.get(i).getText().equalsIgnoreCase("Z"))
			textArea.append("Z");
		//if(botones.get(i).getText().equalsIgnoreCase("<- inicio"))
			//textArea.append("Q");
		if(botones.get(i).getText().equalsIgnoreCase("borrar"))
			textArea.setText(textArea.getText().substring(0, (textArea.getText().length()-1)));

		if(botones.get(i).getText().equalsIgnoreCase("espacio"))
			textArea.append(" ");

	}
	
	@Override
	public void atras() {
		// TODO Auto-generated method stub
		this.c.removeObserver(this);
		this.setVisible(false);
	}			
}