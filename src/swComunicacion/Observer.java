package swComunicacion;

public interface Observer {

	void onCambioOpcion(int op);

	void onCambioModo(boolean m);

	void onCambioFrecuencia(int f);
	
	void mouseNi�o();
	
	void atras();
}
