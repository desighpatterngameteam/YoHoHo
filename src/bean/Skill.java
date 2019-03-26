package bean;

import util.Level;

import java.util.HashSet;
import java.util.Set;

public class Skill {
    public Skill(){}

    public String skillName;//技能名称
    public int level;       //技能等级
    public int physicAdditionDamage;//技能造成物理伤害加成
    public int magicAdditionDamge;  //技能造成魔法伤害加成
    public HashSet<Integer> trigerKey ;//技能触发组合
    public int magicConsume;    //魔法损耗

    public int skillExp;    //技能经验

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPhysicAdditionDamage() {
        return physicAdditionDamage;
    }

    public void setPhysicAdditionDamage(int physicAdditionDamage) {
        this.physicAdditionDamage = physicAdditionDamage;
    }

    public int getMagicAdditionDamge() {
        return magicAdditionDamge;
    }

    public void setMagicAdditionDamge(int magicAdditionDamge) {
        this.magicAdditionDamge = magicAdditionDamge;
    }

    public HashSet<Integer> getTrigerKey() {
        return trigerKey;
    }

    public void setTrigerKey(HashSet<Integer> trigerKey) {
        this.trigerKey = trigerKey;
    }

    public int getMagicConsume() {
        return magicConsume;
    }

    public void setMagicConsume(int magicConsume) {
        this.magicConsume = magicConsume;
    }

    public int getSkillExp() {
        return skillExp;
    }

    public void setSkillExp(int skillExp) {
        this.skillExp = skillExp;
    }

    public void print(){
        System.out.print("技能名称："+getSkillName()+'\t'+"技能等级："+getLevel()+'\t'+"技能物理加成："+getPhysicAdditionDamage()+'\t'
        +"技能魔法加成："+getMagicAdditionDamge()+'\t'+"技能组合键有:");
        for(Integer key:trigerKey){
            System.out.print(key+" ");
        }
        System.out.println("\t"+"魔法损耗："+getMagicConsume()+"\t"+"技能经验："+getSkillExp());
    }

    public Skill updateSkillExp( Skill skill , Equipment equipment){
        int currentSkillExp = skill.getSkillExp();
        int currentSkillLevel = skill.getLevel();
        int expExp = Level.findSkillExpByLevel(currentSkillLevel);//若要升到下一级 需要达到的总经验数
        if( currentSkillExp + equipment.getSkillExpAddition() >= expExp){
            skill.setLevel( currentSkillLevel+1);
            System.out.println("----------------------------------------------");
            System.out.println("游戏主角的技能"+skill.getSkillName()+"等级变为："+skill.getLevel());
            System.out.println("----------------------------------------------");
        }
        System.out.println("currentSkillExp + equipment.getSkillExpAddition()= " + (currentSkillExp + equipment.getSkillExpAddition()) );
        skill.setSkillExp( currentSkillExp + equipment.getSkillExpAddition());
        System.out.println("----------------------------------------------");
        System.out.println("游戏主角的技能"+skill.getSkillName()+"的经验值变为："+skill.getSkillExp());
        System.out.println("----------------------------------------------");

        return skill;
    }


    public static void main(String []args){
        Skill s1 = new Skill();
        HashSet<Integer> triger = new HashSet<>();
        triger.add(1);
        triger.add(2);
        System.out.println(triger);
    }
}
