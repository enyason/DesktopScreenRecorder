
package desktopscreenrecorder;

import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author enyason
 */
public class TimerCountTask extends TimerTask{
    
    
    JLabel label;
    int timeInSec = 0;

    public TimerCountTask(JLabel jLabel) {
        label = jLabel; // initialize the label
    }

    
    
    @Override
    public void run() {
        label.setText(""+timeInSec+"s"); // set the label text to current count value
      
        timeInSec++; //increment count by one
    }
    
}
