/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopscreenrecorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enyason
 */
public class ExecFfmpeg {

    public static void executeFfMpeg(String exec) {

//     String exec = "ffmpeg -i video_ouput.mp4 -q:v 0 convertedJava.avi";
//        String exec = "ffmpeg -i convertedJava.avi -i audio.wav -c:v copy -c:a aac -strict experimental outputFromJava.mp4";
        Runtime runtime = Runtime.getRuntime();

        try {
            Process process = runtime.exec(exec);

            int exitVal = process.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (IOException ex) {

            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
