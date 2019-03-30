import Game.MonsterFactoryMethod.BossMonsterFactory;
import Game.MonsterFactoryMethod.LittleMonsterFactory;
import Game.MonsterFactoryMethod.MonsterFactory;
import Service.PlayerService;
import Service.impl.PlayerServiceImpl;
import bean.Bullet;
import bean.Constants;
import bean.Monster;
import bean.Player;
import exception.AttackException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int state =1;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;
    private static int flag = 0;

    private int score = 0; // 得分
    private Timer timer; // 定时器
    private int intervel = 1000 / 100; // 时间间隔(毫秒)

    private Player hero = Player.getInstance();
    private static Monster temmonster = littleFactory.createMonster();
    private static Monster[] monsters = {littleFactory.createMonster(),bossFactory.createMonster()};
    private Bullet[] bullets = {}; // 子弹数组


    @Override
    public void paint(Graphics g){
        g.drawImage(Constants.background, 0, 0, null); // 画背景图
        paintHero(g); // 画英雄机
        paintBullets(g); // 画子弹
        paintFlyingObjects(g); // 画飞行物
        paintScore(g); // 画分数
        paintState(g); // 画游戏状态
        //System.out.println("========");
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
        if (shootIndex % 200 == 0) { // 300毫秒发一颗
            Bullet[] bs = hero.shoot(0); // 英雄打出子弹
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
        //hero.setImage(Constants.hero1);
        g.drawImage(hero.getImage(), hero.getX(), hero.getY(), hero.getWidth(),hero.getHeight(),null);
    }

    /** 画飞行物 */
    public void paintFlyingObjects(Graphics g) {
        Monster monster = nextOne();
        g.drawImage(monster.getImage(), monster.getX(), monster.getY(), null);
        g.drawImage(temmonster.getImage(), temmonster.getX(), temmonster.getY(), null);

    }

    /** 画分数 */
    public void paintScore(Graphics g) {
        int x = 50; // x坐标
        int y = 25; // y坐标
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 22); // 字体
        g.setColor(new Color(0xFF0000));
        g.setFont(font); // 设置字体
        g.drawString("name: " + hero.getName(), x, y);
        y=y+20; // y坐标增20
        g.drawString("Level: " + hero.getLevel(), x, y); // 画命
        y=y+20;
        g.drawString("Experience: " + hero.getExperience(), x, y); // 画分数
        y=y+20;
        g.drawString("Cash: " + hero.getCash(), x, y);
        y=y+20;
        g.drawString("Blood: " + hero.getHealthPoint(), x, y);

        y=y+20;
        g.drawString("physicDamage: " + hero.getPhysicDamage(), x, y);
        y=y+20;
        g.drawString("magicDamage: " + hero.getMagicDamage(), x, y);
        y=y+20;
        g.drawString("physicArmor: " + hero.getPhysicArmor(),x, y);
        y=y+20;
        g.drawString("magicArmor: " + hero.getMagicArmor(), x, y);
    }

    /** 子弹与飞行物碰撞检测 */
    public void bangAction() {
        for (int i = 0; i < bullets.length; i++) { // 遍历所有子弹
            Bullet b = bullets[i];
            Monster monster = nextOne();
            if(monster.shootBy(b)){
                //monster.setBlood(monster.getBlood()-50);
                PlayerService service = new PlayerServiceImpl();
                try {
                    service.AttackMonsterWithWeapon(monster);
                } catch (AttackException e) {
                    e.printStackTrace();
                }
//                if(monster.getName().equals("百夫长")){
//                    hero.setExperience(hero.getExperience()+5);
//                }else {
//                    hero.setExperience(hero.getExperience()+10);
//                }
            }

            //if(monster.isMonsterAlive())
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




    public void action(){
        // 鼠标监听事件
        temmonster.setX(temmonster.getX());
        temmonster.setY(temmonster.getY()-170);

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

//                switch (state) {
//                    case START:
//                        System.out.println("666666666");
//                        state = RUNNING; // 启动状态下运行
//                        break;
//                    case GAME_OVER: // 游戏结束，清理现场
//                        //flyings = new FlyingObject[0]; // 清空飞行物
//                        //bullets = new Bullet[0]; // 清空子弹
//                        //hero = new Hero(); // 重新创建英雄机
//                        score = 0; // 清空成绩
//                        state = START; // 状态设置为启动
//                        break;
//                }
                if(e.getButton()== e.BUTTON1){
                    Bullet[] bs = hero.shoot(0); // 英雄打出子弹
                    bullets = Arrays.copyOf(bullets, bullets.length + bs.length); // 扩容
                    System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
                            bs.length); // 追加数组

                }else if(e.getButton()==e.BUTTON3){
                    Bullet[] bs = hero.shoot(1); // 英雄打出技能
                    bullets = Arrays.copyOf(bullets, bullets.length + bs.length); // 扩容
                    System.arraycopy(bs, 0, bullets, bullets.length - bs.length,
                            bs.length); // 追加数组
                    System.out.println("点击了右键！");
                }


            }
        };
        this.addMouseListener(l); // 处理鼠标点击操作
        this.addMouseMotionListener(l); // 处理鼠标滑动操作

        //System.out.println("888888888888888888888888888888888888888888888888888888");


        timer = new Timer(); // 主流程控制
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state == RUNNING) {// 运行状态
                    //enterAction(); // 飞行物入场
                    stepAction(); // 走一步
                    //shootAction(); // 英雄机射击
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

        if(monsters[0].isMonsterAlive())
        {
            return monsters[0];
        }
        else if(monsters[1].isMonsterAlive()){

            return monsters[1];
        }else {

            Monster monster = littleFactory.createMonster();
            Monster monster1 = bossFactory.createMonster();
            monsters[0] = monster;
            monsters[1] = monster1;
            return  monsters[0];
        }
    }
}