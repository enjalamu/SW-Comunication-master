package swComunicacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

public class Controller {

	private Data d;
	private TratarXML xml;
	private int velocidad = 1;
	public Controller(Data d2) {
		// TODO Auto-generated constructor stub
		d = d2;
	}
	
	public boolean addObserver(Observer po) {
		return d.addObserver(po);
	}
	
	public boolean removeObserver(Observer po){
		return d.removeObserver(po);
	}
	

	public void onCambioOpcion(int op){
		d.notifyCambioOpcion(op);
	}

	public void onCambioModo(boolean m) {
		// TODO Auto-generated method stub
		d.notifyCambioModo(m);
	}

	public void onCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		d.notifyCambioFrecuencia(f);
	}

	public void onCambioVentanaAtras() {
		// TODO Auto-generated method stub
		d.notifyCambioVentanaAtras();
	}
	public void aumentarFrecuencia() {
		// TODO Auto-generated method stub
		int f = d.getFrecuencia();
		f = f + 300;
		d.setFrecuencia(f);
	}

	public void disminuirFrecuencia() {
		// TODO Auto-generated method stub
		int f = d.getFrecuencia();
		f = f - 300;
		d.setFrecuencia(f);
	}

	public boolean getModo() {
		// TODO Auto-generated method stub
		return this.d.getModo();
	}

	public void setModo(boolean b) {
		// TODO Auto-generated method stub
		d.setModo(b);
	}

	public int getFrecuencia() {
		// TODO Auto-generated method stub
		return d.getFrecuencia();
	}

	public void setFrecuencia(int f) {
		// TODO Auto-generated method stub
		d.setFrecuencia(f);
	}

	public void setVelocidad(int i) {
		// TODO Auto-generated method stub
		this.velocidad = velocidad + i;
	}

	public boolean velocidadOk() {
		// TODO Auto-generated method stub
		boolean ok = false;
		if(velocidad < 4 && velocidad > 0)
			ok = true;
		return ok;
	}

	public int getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}

	@SuppressWarnings("static-access")
	public HashMap<Integer, ArrayList<String>> cargarDatos() {
		// TODO Auto-generated method stub
		return xml.cargarXml();
	}

	public void mvImagen(File logo) throws IOException {
		// TODO Auto-generated method stub
		File dest = new File("src/imagenes/" + logo.getName());
        copyFileUsingFileStreams(logo, dest);
	}

	private void copyFileUsingFileStreams(File source, File dest)
	        throws IOException {
	
	    InputStream input = null;
	    OutputStream output = null;
	    try {
	        input = new FileInputStream(source);
	        output = new FileOutputStream(dest);
	        byte[] buf = new byte[1024];
	        int bytesRead;
	
	        while ((bytesRead = input.read(buf)) > 0) 
	        	output.write(buf, 0, bytesRead);
	        
	    } finally {
	        input.close();
	        output.close();
	    }
	}

	@SuppressWarnings("static-access")
	public boolean escribirDatos(String[] args) {
		// TODO Auto-generated method stub
		return this.xml.escribirXML(args);
	}

	/*public void addPadre(JFrame e) {
		// TODO Auto-generated method stub
		d.addPadre(e);
	}

	public JFrame getPadre() {
		// TODO Auto-generated method stub
		return d.getPadre();
	}*/

}
