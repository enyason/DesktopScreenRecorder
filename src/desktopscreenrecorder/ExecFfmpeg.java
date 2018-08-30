/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopscreenrecorder;

import java.io.IOException;

/**
 *
 * @author enyason
 */
public class ExecFfmpeg {
    
    
     public static void executeFfMpeg(String exec) {

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
