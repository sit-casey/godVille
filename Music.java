package godVille;

import java.applet.*;
import java.net.URL;

public class Music {

	public AudioClip normie;
	public AudioClip war;
	public AudioClip sad;
	
	public Music(){
		normie = Applet.newAudioClip(getClass().getResource("bgm.wav"));
		war = Applet.newAudioClip(getClass().getResource("end.wav"));
	}
	
	public void bgm(){
		normie.loop();
	}
	
	public void bend(){
		normie.stop();
	}
	
	public void ward(){
		war.loop();
	}
	
	public void wend(){
		war.stop();
	}

}
