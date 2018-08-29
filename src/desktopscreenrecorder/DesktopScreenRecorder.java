/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopscreenrecorder;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import org.jcodec.api.SequenceEncoder;
import org.jcodec.api.awt.AWTSequenceEncoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Rational;

/**
 *
 * @author enyason
 */
public class DesktopScreenRecorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, IOException {
        // TODO code application logic here

        List<BufferedImage> imageList = new ArrayList<>();

        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        Robot robot = new Robot();

        File file = new File("outputVideo.mp4");

        System.out.println("getting screen images...");

        int count = 0;
        while (count < 100) {

            BufferedImage image = robot.createScreenCapture(screenRect);

            imageList.add(image);

            count++;

        }
        
        makeVideoFromImages(imageList,file);

    }

    public static void makeVideoFromImages(List<BufferedImage> imageList, File file) throws IOException {

        AWTSequenceEncoder sequenceEncoder = AWTSequenceEncoder.createSequenceEncoder(file, 25);

        for (int i = 0; i < imageList.size(); i++) {

            System.out.println("list encode " + i);
            sequenceEncoder.encodeImage(imageList.get(i));

        }
        
        sequenceEncoder.finish();

    }

 

}
