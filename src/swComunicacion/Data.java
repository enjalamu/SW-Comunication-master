package swComunicacion;

import java.util.Vector;

import javax.swing.JFrame;

import swComunicacion.Observer;

public class Data {

	private Vector<Observer> observadores;
	private boolean modo; //true-->niño false-->madre
	private int frecuencia;
	//private JFrame padre = null;
	public Data(){
		this.observadores = new Vector<Observer>();
	}
	public Data(boolean m, int f){
		this.observadores = new Vector<Observer>();
		modo = m;
		frecuencia = f;
	}
	public boolean addObserver(Observer po) {
		/*for (Observer o : observadores){
			System.out.println(o + "\n");
		}
		*/
		if (!this.observadores.contains(po)){
			this.observadores.add(po);
			return true;
		}
		return false;
	}

	public boolean removeObserver(Observer o){
		if(this.observadores.contains(o)){
			this.observadores.remove(o);
			return true;
		}
		return false;
	}

	public void notifyCambioOpcion(int op) {
		// TODO Auto-generated method stub
		for (Observer o : observadores){
			o.onCambioOpcion(op);
		}
	}
	public void notifyCambioModo(boolean m) {
		// TODO Auto-generated method stub
		for (Observer o : observadores){
			o.onCambioModo(m);
		}
	}
	public void notifyCambioFrecuencia(int f) {
		// TODO Auto-generated method stub
		for (Observer o : observadores){
			o.onCambioFrecuencia(f);
		}
	}
	public boolean getModo() {
		// TODO Auto-generated method stub
		return this.modo;
	}
	public void setModo(boolean b) {
		// TODO Auto-generated method stub
		this.modo=b;
	}
	public int getFrecuencia(){
		return this.frecuencia;
	}
	public void setFrecuencia(int f) {
		// TODO Auto-generated method stub
		this.frecuencia = f;
	}
	/*public void addPadre(JFrame e) {
		// TODO Auto-generated method stub
		this.padre = e;
	}
	public JFrame getPadre() {
		// TODO Auto-generated method stub
		return this.padre;
	}*/
	public void notifyCambioVentanaAtras() {
		// TODO Auto-generated method stub
		for (Observer o : observadores){
			o.atras();
		}
	}
}
