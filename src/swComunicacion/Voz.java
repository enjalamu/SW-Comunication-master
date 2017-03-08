package swComunicacion;

import java.io.IOException;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voz {
	private String text;
	private Voice voice;
	private String path = null;
	private VoiceManager voiceManager;
	public Voz(String text){
		this.text = text;
		try {
			path = new java.io.File(".").getCanonicalPath();
			path = path+"\\src";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  path = path+"\\mbrola";
		   System.setProperty("mbrola.base", path);
		  voiceManager = VoiceManager.getInstance();
		  voice = voiceManager.getVoice("mbrola_us1");
		  voice.allocate();
	}
	
	public void Reproducir(){
		/*
		 voice.speak("merry christmas and happy new year");
		 */
		voice.speak(text);
	}
	
	//Método para mostrar las voces disponibles para usar
	public static void listAllVoices() {
	    System.out.println("All voices available:");        
	    VoiceManager voiceManager = VoiceManager.getInstance();
	    Voice[] voices = voiceManager.getVoices();
	    for (int i = 0; i < voices.length; i++) {
	        System.out.println("    " + voices[i].getName()
	                           + " (" + voices[i].getDomain() + " domain)");
	    }

	}
	
}
