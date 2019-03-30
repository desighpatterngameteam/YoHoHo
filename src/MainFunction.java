import Game.PlayerBuild.AsheBuilder;
import Game.PlayerBuild.GarenBuilder;
import Game.PlayerBuild.PlayerBuilder;
import Game.PlayerBuild.PlayerDirector;
import bean.Constants;
import bean.Player;
import frame.EquipmentButton;
import frame.MyFrame;
import frame.StartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author fengxuegt
 * @date 19-3-29  下午6:41
 */
public class MainFunction {
    public static void main(String[] args) {

        JButton startButton = new JButton();
        startButton.setIcon(new ImageIcon(( new ImageIcon("src/img/icon/start.png")).getImage()));
        startButton.setBounds(418,400,231,61);

        JPanel start = new StartPanel(Constants.start);
        start.setLayout(null);
        start.add(startButton);

        JPanel gameover = new StartPanel(Constants.gameover);

        JFrame frame = new MyFrame("YoHoHo战斗小游戏",start);
        frame.setIconImage(( new ImageIcon("src/img/icon/icon.png")).getImage());
        JPanel choose = new StartPanel(Constants.choosePlayer);

        choose.setLayout(null);
        JLabel ashe = new JLabel();
        ashe.setIcon(new ImageIcon(Constants.hero0));
        ashe.setBounds(300,200,146,170);

        JLabel garen = new JLabel();
        garen.setIcon(new ImageIcon(Constants.hero1));
        garen.setBounds(600,200,146,170);
        JButton asheButton = new JButton();
        asheButton.setText("艾 希");
        asheButton.setBounds(300,375,146,30);

        JButton garenButton = new JButton();
        garenButton.setText("盖 伦");
        garenButton.setBounds(600,375,146,30);
        choose.add(ashe);
        choose.add(garen);
        choose.add(asheButton);
        choose.add(garenButton);


        //新建购买物品panel
        StartPanel buyPanel = new StartPanel(Constants.buyObjects);
        buyPanel.setLayout(null);
        JButton ep1 = new EquipmentButton(Constants.ep1,"weapon1");
        ep1.setBounds(195,280,120,120);
        //ep1.setBorderPainted(false);
        JButton ep2 = new EquipmentButton(Constants.ep2,"weapon2");
        ep2.setBounds(315,280,120,120);
        //ep2.setBorderPainted(false);zi
        buyPanel.add(ep1);
        buyPanel.add(ep2);


        JButton ep3 = new EquipmentButton(Constants.ep3,"skill1");
        ep3.setBounds(600,280,120,120);
        //ep3.setBorderPainted(false);

        JButton ep4 = new EquipmentButton(Constants.ep4,"skill2");
        ep4.setBounds(720,280,120,120);
        //ep4.setBorderPainted(false);

        JButton ep5 = new EquipmentButton(Constants.ep5,"skill3");
        ep5.setBounds(840,280,120,120);
        //ep5.setBorderPainted(false);

        buyPanel.add(ep3);
        buyPanel.add(ep4);
        buyPanel.add(ep5);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ((MyFrame) frame).nextPanel(choose);

            }
        });



        garenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LwFrame lwFrame = new LwFrame();
                PlayerBuilder heroBuilder = new GarenBuilder();
                PlayerDirector heroDirector = new PlayerDirector(heroBuilder);
                heroDirector.construct();
                Player hero = Player.getInstance();
                JButton button = new JButton();
                button.setIcon(new ImageIcon(hero.getImage()));
                button.setBounds(hero.getX(),hero.getY(),hero.getWidth(),hero.getHeight());
                lwFrame.setLayout(null);
                lwFrame.add(button);
                ((MyFrame) frame).nextPanel(lwFrame);

                lwFrame.action();

            }
        });

        asheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LwFrame lwFrame = new LwFrame();
                PlayerBuilder heroBuilder = new AsheBuilder();
                PlayerDirector heroDirector = new PlayerDirector(heroBuilder);
                heroDirector.construct();
                ((MyFrame) frame).nextPanel(lwFrame);

                lwFrame.action();

            }
        });





        frame.setSize(Constants.WIDTH,Constants.HEIGHT);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setIconImage(new ImageIcon("src"));
        frame.setLocation(10,10);
        frame.setVisible(true);
        //lwFrame.action();

    }

}
