package frame;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * @author fengxuegt
 * @date 19-3-30  上午9:20
 */
public class EquipmentButton extends JButton {
    private BufferedImage image;
    private String name;
    public EquipmentButton(BufferedImage image,String name){
        this.image = image;
        this.name = name;
        this.setIcon(new ImageIcon(image));
    }
}
