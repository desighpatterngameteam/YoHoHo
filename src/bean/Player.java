package bean;

import Game.Attack.AttackBehavior;
import exception.AttackException;
import util.Level;

import java.util.Iterator;
import java.util.List;

public class Player {
    private volatile static Player uniquePlayer;

    private String name ;       //姓名
    private int level;          //等级
    private int experience;     //经验值
    private int healthPoint;    //血条
    private int magicPoint;     //魔力值
    private int cash;           //玩家的金币
    private int physicDamage;   //物理伤害
    private int magicDamage;    //魔法伤害
    private int physicArmor;    //物理抗性(本游戏的小怪攻击都是物理伤害)
    private int magicArmor;     //魔法抗性(Boss的伤害，有魔法伤害）
//    private int weapons;        //武器

    private AttackBehavior attackBehavior;  //攻击行为

    private List<Skill> skills; //角色技能集合
    private List<Equipment> equipments; //角色装备栏
    private List<Weapon> weapons;   //武器集合

    private Player(){}

    public Player(String name, int level, int experience, int healthPoint, int magicPoint, int cash, int physicDamage, int magicDamage, int physicArmor, int magicArmor, AttackBehavior attackBehavior, List<Skill> skills, List<Equipment> equipments, List<Weapon> weapons) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.healthPoint = healthPoint;
        this.magicPoint = magicPoint;
        this.cash = cash;
        this.physicDamage = physicDamage;
        this.magicDamage = magicDamage;
        this.physicArmor = physicArmor;
        this.magicArmor = magicArmor;
        this.attackBehavior = attackBehavior;
        this.skills = skills;
        this.equipments = equipments;
        this.weapons = weapons;
    }

    public static Player getInstance(){
        if( uniquePlayer == null){
            synchronized (Player.class){
                if( uniquePlayer==null){
                    uniquePlayer = new Player();
                }
            }
        }
        return uniquePlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getPhysicDamage() {
        return physicDamage;
    }

    public void setPhysicDamage(int physicDamage) {
        this.physicDamage = physicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getPhysicArmor() {
        return physicArmor;
    }

    public void setPhysicArmor(int physicArmor) {
        this.physicArmor = physicArmor;
    }

    public int getMagicArmor() {
        return magicArmor;
    }

    public void setMagicArmor(int magicArmor) {
        this.magicArmor = magicArmor;
    }



    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public AttackBehavior getAttackBehavior() {
        return attackBehavior;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    //打印玩家状态信息
    public void print(){
        System.out.println("角色姓名:\t"+getName());
        System.out.println("等级:\t"+getLevel());
        System.out.println("经验值:\t"+getExperience());
        System.out.println("血条:\t"+getHealthPoint());
        System.out.println("魔力值:\t"+getMagicPoint());

        System.out.println("金币:\t"+getCash());
        System.out.println("物理伤害:\t"+getPhysicDamage());
        System.out.println("魔法伤害:\t"+getMagicDamage());
        System.out.println("物理抗性:\t"+getPhysicArmor());
        System.out.println("魔法抗性:\t"+getMagicArmor());

        if(weapons!=null){
            Iterator it = weapons.iterator();
            System.out.println("武器有");
            while (it.hasNext()){
                Weapon weapon=(Weapon) it.next();
                weapon.print();
            }
        }else {
            System.out.println("武器栏为空");
        }

        if(skills!=null){
            Iterator it = skills.iterator();
            System.out.println("技能有");
            while (it.hasNext()){
                Skill skill=(Skill) it.next();
                skill.print();
            }
        }else {
            System.out.println("技能为空");
        }

        if(equipments!=null){
            Iterator it = equipments.iterator();
            System.out.println("物品栏有");
            while (it.hasNext()){
                Equipment equipment =(Equipment) it.next();
                equipment.printall();
            }
        }else {
            System.out.println("物品栏为空");
        }


    }

    public boolean isPlayerAlive(){
        return healthPoint>0 ? true : false ;
    }

//    public void attack(Monster monster , String attackinfo) throws AttackException {
//        if( attackinfo == Constants.ATTACK_WITH_WEAPON){
//            attackBehavior.attackEnemy(uniquePlayer,null,monster);
//        }else {
//            //ToDO
////            attackinfo.split(" ");
////            attackBehavior.attackEnemy(uniquePlayer,);
//
//        }
//    }

    /**
     * 杀死怪兽，更新经验值
     * @param monster
     */
    public void updateExp(Monster monster){
        int currentExp = uniquePlayer.getExperience();
        int currentLevel = uniquePlayer.getLevel();
        int expectExp = Level.findPlayerExpByLevel(currentLevel);//若要角色升到下一级，必须要达到的总经验值是expectExp
        if( currentExp + monster.getExpAddition() >= expectExp){
            updateLevel();

            System.out.println("----------------------------------------------");
            System.out.println("游戏主角的等级变为："+uniquePlayer.getLevel());
            System.out.println("----------------------------------------------");
        }
        uniquePlayer.setExperience(currentExp + monster.getExpAddition());
        System.out.println("----------------------------------------------");
        System.out.println("游戏主角的经验值变为："+uniquePlayer.getExperience());
        System.out.println("----------------------------------------------");

    }

    /**
     * 角色升级
     */
    public void updateLevel(){
        int currentLevel = uniquePlayer.getLevel();
        uniquePlayer.setLevel(currentLevel+1);
    }

}
