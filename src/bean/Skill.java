package bean;

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

    public void print(){
        System.out.print("技能名称："+getSkillName()+'\t'+"技能等级："+getLevel()+'\t'+"技能物理加成："+getPhysicAdditionDamage()+'\t'
        +"技能魔法加成："+getMagicAdditionDamge()+'\t'+"技能组合键有:");
        for(Integer key:trigerKey){
            System.out.print(key+" ");
        }
        System.out.println("\t"+"魔法损耗："+getMagicConsume());
    }

    public static void main(String []args){
        Skill s1 = new Skill();
        HashSet<Integer> triger = new HashSet<>();
        triger.add(1);
        triger.add(2);
        System.out.println(triger);
    }
}
