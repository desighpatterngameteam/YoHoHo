import Game.MonsterFactoryMethod.BossMonsterFactory;
import Game.MonsterFactoryMethod.LittleMonsterFactory;
import Game.MonsterFactoryMethod.MonsterFactory;
import bean.Bullet;
import bean.Constants;
import bean.Monster;
import bean.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fengxuegt
 * @date 19-3-27  上午9:06
 */
public class LwFrame extends JPanel {
    public static MonsterFactory bossFactory = new BossMonsterFactory();   //BossFactory
    public static MonsterFactory littleFactory = new LittleMonsterFactory();
    /** 游戏的当前状态: START RUNNING PAUSE GAME_OVER */
    private int state;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;

    private int score = 0; // 得分
    private Timer timer; // 定时器
    private int intervel = 1000 / 100; // 时间间隔(毫秒)

    private Player hero = Player.getInstance();
    private static Monster[] monsters = {littleFactory.createMonster(),bossFactory.createMonster()};
    private Bullet[] bullets = {}; // 子弹数组

    @Override
    public void paint(Graphics g){
        g.drawImage(Constants.background, 0, 0, null); // 画背景图
        paintHero(g); // 画英雄机
        paintBullets(g); // 画子弹
        paintFlyingObjects(g); // 画飞行物
        //paintScore(g); // 画分数
        paintState(g); // 画游戏状态
    }

    /** 走一步 */
    public void stepAction() {

        for (int i = 0; i < bullets.length; i++) { // 子弹走一步
            Bullet b = bullets[i];
            b.step();
        }
    }
    int shootIndex = 0;

    /** 射击 */
    public void shootAction() {
        shootIndex++;
        if (shootIndex % 50 == 0) { // 300毫秒发一颗
            Bullet[] bs = hero.shoot(); // 英雄打出子弹
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length); // 扩容
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
                    bs.length); // 追加数组
        }

        for(Bullet bullet:bullets){
            System.out.print(bullet.getX()+ "   ");
        }
        System.out.println();
    }


    /** 画子弹 */
    public void paintBullets(Graphics g) {
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(),
                    null);
        }
    }
    private void paintState(Graphics g) {
        switch (state) {
            case START: // 启动状态
                g.drawImage(Constants.start, 0, 0, null);
                break;
            case PAUSE: // 暂停状态
                g.drawImage(Constants.background, 0, 0, null);
                break;
            case GAME_OVER: // 游戏终止状态
                g.drawImage(Constants.gameover, 0, 0, null);
                break;
        }

    }
    //画英雄
    private void paintHero(Graphics g) {
        hero.setImage(Constants.hero1);
        g.drawImage(hero.getImage(), hero.getX(), hero.getY(), hero.getWidth(),hero.getHeight(),null);
    }

    /** 画飞行物 */
    public void paintFlyingObjects(Graphics g) {
        Monster monster = nextOne();
        g.drawImage(monster.getImage(), monster.getX(), monster.getY(), null);

    }



    /** 子弹与飞行物碰撞检测 */
    public void bangAction() {
        for (int i = 0; i < bullets.length; i++) { // 遍历所有子弹
            Bullet b = bullets[i];
            Monster monster = nextOne();
            if(monster.shootBy(b)){
                monster.setBlood(monster.getBlood()-50);
            }
            System.out.println(monster.getBlood()+"==============");
        }
    }

    /** 删除越界飞行物及子弹 */
    public void outOfBoundsAction() {
        Monster monster = nextOne();
        int index = 0; // 索引重置为0
        Bullet[] bulletLives = new Bullet[bullets.length];
        for (int i = 0; i < bullets.length; i++) {
            Bullet b = bullets[i];
            if (!b.ShootMonster(monster)) {
                bulletLives[index++] = b;
            }
        }
        bullets = Arrays.copyOf(bulletLives, index); // 将不越界的子弹留着
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("YoHoHo战斗小游戏");
        frame.setIconImage(( new ImageIcon("src/img/icon/icon.png")).getImage());
        LwFrame lwFrame = new LwFrame();
        frame.add(lwFrame);
        frame.setSize(Constants.WIDTH,Constants.HEIGHT);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setIconImage(new ImageIcon("src"));
        frame.setLocation(10,10);
        frame.setVisible(true);
        lwFrame.action();

    }

    public void action(){
        // 鼠标监听事件
        MouseAdapter l = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) { // 鼠标进入
                if (state == PAUSE) { // 暂停状态下运行
                    state = RUNNING;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) { // 鼠标退出
                if (state == RUNNING) { // 游戏未结束，则设置其为暂停
                    //state = PAUSE;
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) { // 鼠标点击

                switch (state) {
                    case START:
                        state = RUNNING; // 启动状态下运行
                        break;
                    case GAME_OVER: // 游戏结束，清理现场
                        //flyings = new FlyingObject[0]; // 清空飞行物
                        //bullets = new Bullet[0]; // 清空子弹
                        //hero = new Hero(); // 重新创建英雄机
                        score = 0; // 清空成绩
                        state = START; // 状态设置为启动
                        break;
                }
            }
        };
        this.addMouseListener(l); // 处理鼠标点击操作
        this.addMouseMotionListener(l); // 处理鼠标滑动操作


        timer = new Timer(); // 主流程控制
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == RUNNING) {// 运行状态
                    //enterAction(); // 飞行物入场
                    stepAction(); // 走一步
                    shootAction(); // 英雄机射击
                    bangAction(); // 子弹打飞行物
                    outOfBoundsAction(); // 删除越界飞行物及子弹
//                    checkGameOverAction(); // 检查游戏结束
                }
                repaint(); // 重绘，调用paint()方法
            }

        }, intervel, intervel);

    }

    /**
     * 随机生成
     *
     * @return 飞行物对象
     */
    public static Monster nextOne() {

//        Random random = new Random();
//        int type = random.nextInt(20); // [0,20)
//        if (type < 4) {
//            BossMonsterFactory factory = new BossMonsterFactory();
//            return factory.createMonster();
//        } else {
//            LittleMonsterFactory littleMonsterFactory = new LittleMonsterFactory();
//            return littleMonsterFactory.createMonster();
//        }
        if(monsters[0].isMonsterAlive())
        {
            return monsters[0];
        }
        else {
            return monsters[1];
        }
    }
}