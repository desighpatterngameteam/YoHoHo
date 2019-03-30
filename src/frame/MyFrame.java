package frame;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;

/**
 * @author fengxuegt
 * @date 19-3-29  下午7:26
 */
public class MyFrame extends JFrame {
    private JPanel current;


    public MyFrame(String string, JPanel jPanel){
        super(string);
        current = jPanel;
        this.add(current);
    }
    public JPanel getjPanel() {
        return current;
    }

    public void setjPanel(JPanel jPanel) {
        this.current = jPanel;
        this.add(jPanel);
    }

    public void nextPanel(JPanel jPanel){
        this.getContentPane().removeAll();
        current = jPanel;
        this.getContentPane().add(current);
        this.revalidate();
        //this.repaint();
        //System.out.println("66666");
    }
}
