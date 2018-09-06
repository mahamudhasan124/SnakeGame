
import javax.sound.sampled.*;
import java.io.*;

public class Sound {


	public static void eatSound(){
		try{


			File sound = new File("Sounds//Eat.wav");
			AudioInputStream aud=AudioSystem.getAudioInputStream(sound);
			Clip clip=AudioSystem.getClip();
			clip.open(aud);
			clip.start();


		}catch(Exception e){

		}
	}
	public static void gameOver(){
		try{


			File sound = new File("Sounds//Gameover.wav");
			AudioInputStream aud=AudioSystem.getAudioInputStream(sound);
			Clip clip=AudioSystem.getClip();
			clip.open(aud);
			clip.start();


		}catch(Exception e){

		}	
	}
}
