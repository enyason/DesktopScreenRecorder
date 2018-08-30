/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopscreenrecorder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author enyason
 */
public class AudioRecorder extends Thread {

    private static TargetDataLine mic;

    public void AudioRecorder() {

//        initRecording();
    }

    private void initRecording() {

        System.out.println("begin sound test...");

        try {

            //define audio format
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

            mic = (TargetDataLine) AudioSystem.getLine(info);
            mic.open();

            System.out.println("recording initialized...");
          

        } catch (LineUnavailableException ex) {

            ex.printStackTrace();

        }

    }

    @Override
    public  void run() {
        
        initRecording();
        statRecording();

    }

    private void statRecording() {


        try {
              mic.start();

            AudioInputStream audioInputStream = new AudioInputStream(mic);

            File f = new File("audio_output.wav");

            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, f);
            System.out.println("done writing to file");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    
    
    
       public void stopRecording() {
        mic.stop();
        
        mic.close();
        System.out.println("Recording ended");

    }
    
}

 




