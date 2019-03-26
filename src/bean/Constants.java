package bean;

import java.util.HashMap;

public class Constants {

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

}