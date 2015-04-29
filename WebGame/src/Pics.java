import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;


public class Pics {

	static Image platform, ball; // static variables can be passed to other classes
	URL url;
	static StartingPoint sp;
	static AudioClip music, wind, bounce;
	static int level = 1;
	
	public Pics(StartingPoint sp){
		
		try{
			url = sp.getDocumentBase();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		music = sp.getAudioClip(url, "music/die.au");
		bounce = sp.getAudioClip(url, "music/dog.au");
		wind = sp.getAudioClip(url, "music/yes.au");
		
		platform = sp.getImage(url, "images/tiles.png");
		this.sp = sp;
	}
}
