package Assets;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	public Clip clip;
	URL soundURL;
	FloatControl floatControl;
	
	public Sound(String path) {
		File file = new File(path);
		 try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(ais);
			floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public Sound(String path, float adjustedVolume) {
		this(path);
		adjustVolume(adjustedVolume);
	}
	
	public void play() {
		seek(0);
		clip.start();
	}
	
	
	public void loop() {
		clip.loop(0);
	}
	
	
	public void stop() {
		clip.stop();
	}
	
	public void seek(int frames) {
		clip.setFramePosition(frames);
	}
	
	public void adjustVolume(float value) {
       floatControl.setValue(value);
   }
	
}
