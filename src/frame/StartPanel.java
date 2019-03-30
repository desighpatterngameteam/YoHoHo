package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author fengxuegt
 * @date 19-3-29  下午6:43
 */
public class StartPanel extends JPanel {
    private BufferedImage image;
    public StartPanel(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
        //System.out.println("7777777777");
    }
}
