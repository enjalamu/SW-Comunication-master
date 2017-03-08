package swComunicacion.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import swComunicacion.Observer;

@SuppressWarnings("serial")
public class Pelicula extends JPanel implements Observer {

	private JLabel info;
	private JButton btn;
	private boolean activa = false;
	
	public Pelicula(String informacion, String imagen) {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		info = new JLabel(informacion);
		info.setFont(new Font("Roboto", Font.BOLD, 18));
		info.setSize(10, 10);
		ImageIcon icono = new ImageIcon("src/imagenes/" + imagen);
		Dimension size = new Dimension(icono.getIconWidth(),icono.getIconHeight());
		btn = new JButton();
		btn.setIcon(icono);
		btn.setSize(size);
		btn.setContentAreaFilled(false);
		Border thickBorder = new LineBorder(Color.RED, 8);
		btn.setBorder(thickBorder);
		add(info, BorderLayout.NORTH);
		add(btn, BorderLayout.CENTER);
	}
	@Override
	public void onCambioOpcion(int op) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		
	}
	public boolean isActiva() {
		// TODO Auto-generated method stub
		return this.activa;
	}
	public void cambiaBorde(Color c,int grosor) {
		// TODO Auto-generated method stub
		Border thickBorder = new LineBorder(c, grosor);
		btn.setBorder(thickBorder);
	}
	public void desactiva() {
		// TODO Auto-generated method stub
		this.activa=false;
		cambiaBorde(Color.RED,5);
	}
	public void activa() {
		// TODO Auto-generated method stub
		this.activa=true;
		cambiaBorde(Color.GREEN,20);
	}
	public String getInfo(){
		return this.info.getText();
	}
	public JButton getButon(){
		return this.btn;
	}
	public Component getJLabel() {
		// TODO Auto-generated method stub
		return this.info;
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
