package swComunicacion;

public interface Observer {

	void onCambioOpcion(int op);

	void onCambioModo(boolean m);

	void onCambioFrecuencia(int f);
	
	void mouseNiño();
	
	void atras();
}
