package bean;

import Game.MonsterFactoryMethod.BossMonsterFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.HashMap;

public class Constants {

    //面板高和宽
    public static final int WIDTH = 1067;   //宽
    public static final int HEIGHT = 600; // 面板高
    //游戏状态
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;

    //怪兽等级
    public final static int MONSTER_LEVEL_BOSS = 2;//BOSS等级
    public final static int MONSTER_LEVEL_ARMY = 1;//小兵等级

    //怪兽物理和魔法伤害
    public final static int MONSTER_PHYSIC_DAMAGE_BOSS = 200;//BOSS物理伤害
    public final static int MONSTER_MAGIC_DAMAGE_BOSS = 100; //BOSS魔法伤害
    public final static int MONSTER_PHYSIC_DAMAGE_ARMY = 100;//小兵物理伤害
    public final static int MONSTER_MAGIC_DAMAGE_ARMY = 0;  //小兵魔法伤害

    //怪兽等级加成
    public final static int MONSTER_EXPADDITION_BOSS = 1000 ;   //Boss经验值加成
    public final static int MONSTER_EXPADDITION_ARMY = 500;     //小兵经验值加成

    //怪兽默认血条
    public final static int MONSTER_DEFAULT_BLOOD_BOSS = 3000;  //Boss默认血条
    public final static int MONSTER_DEFAULT_BLOOD_ARMY = 500;   //小兵默认血条

    //怪兽金币加成
    public final static int MONSTER_MONEYADDITION_BOSS = 1000 ; //Boss金币加成
    public final static int MONSTER_MONEYADDITION_ARMY = 200  ; //小兵金币加成

    //玩家初始金币
    public final static int PLAYER_INIT_MONEY = 1000;   //玩家初始金币设置为1000
    //玩家初始等级和经验值
    public final static int PLAYER_INIT_LEVEL = 1;
    public final static int PLAYER_INIT_EXPERIENCE = 0;

    //玩家初始生命值和魔法值
    public final static int PLAYER_INIT_HEALTHPOINT = 1000;
    public final static int PLAYER_INIT_MAGICPOINT = 1000;
    //玩家初始物理伤害和魔法伤害
    public final static int PLAYER_INIT_PHYSIC_DAMAGE = 200;
    public final static int PLAYER_INIT_MAGIC_DAMAGE = 0;

    //玩家初始化物理抗性和魔法抗性
    public final static int PLAYER_INIT_PHYSIC_ARMOR = 100;
    public final static int PLAYER_INIT_MAGIC_ARMOR = 0;


    //冰霜之箭


    //使用物理攻击 信号
    public final static String ATTACK_WITH_WEAPON = "0";

    //装备的 类型有两种，一种是给强化武器的，一种是强化技能的
    public final static int EQUIPMENT_FOR_WEAPON = 1;
    public final static int EQUIPMENT_FOR_SKILL= 2;

    //图片
    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage hero0;
    public static BufferedImage hero1;
    public static BufferedImage pause;
    public static BufferedImage gameover;
    public static BufferedImage Boss;
    public static BufferedImage LittleMonster;
    public static BufferedImage bullet;
    public static BufferedImage choosePlayer;
    public static BufferedImage buyObjects;
    public static BufferedImage ep1;
    public static BufferedImage ep2;
    public static BufferedImage ep3;
    public static BufferedImage ep4;
    public static BufferedImage ep5;
    public static BufferedImage asheskill;
    public static BufferedImage garenskill;





    static { // 静态代码块，初始化图片资源
        try {
            background = ImageIO.read(new FileInputStream("src/img/map/gameScene.jpg"));

            start = ImageIO.read(new FileInputStream("src/img/others/gamestart.png"));


            bullet = ImageIO.read(new FileInputStream("src/img/weapon/bullet.jpg"));
            hero0 = ImageIO.read(new FileInputStream("src/img/player/ashe.png"));
            hero1 = ImageIO.read(new FileInputStream("src/img/player/garen.png"));
            //pause = ImageIO.read(new FileInputStream("src/img/pause.png"));
            gameover = ImageIO
                    .read(new FileInputStream("src/img/others/gameover.png"));
            Boss = ImageIO.read(new FileInputStream("src/img/monster/Boss.gif"));
            LittleMonster = ImageIO.read(new FileInputStream("src/img/monster/LittleMonster.gif"));
            choosePlayer = ImageIO
                    .read(new FileInputStream("src/img/others/choosePlayer.jpeg"));
            buyObjects = ImageIO
                    .read(new FileInputStream("src/img/others/buyObjects.jpg"));
            ep1 = ImageIO.read(new FileInputStream("src/img/equipment/jjbz_weapon.png"));
            ep2 = ImageIO.read(new FileInputStream("src/img/equipment/qhbs_weapon.png"));
            ep3 = ImageIO.read(new FileInputStream("src/img/equipment/ktkj_skill.png"));
            ep4 = ImageIO.read(new FileInputStream("src/img/equipment/mfgs_skill.png"));
            ep5 = ImageIO.read(new FileInputStream("src/img/equipment/wjzr_skill.png"));

            asheskill = ImageIO.read(new FileInputStream("src/img/weapon/asheskill.jpg"));
            garenskill = ImageIO.read(new FileInputStream("src/img/weapon/garenskill.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
