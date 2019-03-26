package Game.PlayerBuild;

import Game.PlayerBuild.PlayerBuilder;
import bean.Constants;
import bean.Equipment;
import bean.Skill;
import bean.Weapon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 建造者模式 创造角色 盖伦
 */
public class GarenBuilder extends PlayerBuilder {

    @Override
    public void buildPlayerName(){
        player.setName("盖伦");
    }

    @Override
    public void buildPlayerDefaultAttribute(){
        player.setCash(Constants.PLAYER_INIT_MONEY);//设置初始金币
        player.setLevel(Constants.PLAYER_INIT_LEVEL);   //初始等级设置为0
        player.setExperience(Constants.PLAYER_INIT_EXPERIENCE);  //初始经验值为0
        player.setHealthPoint(1200);//初始生命值1200
        player.setMagicPoint(1400);//初始魔法值1000
        player.setPhysicDamage(Constants.PLAYER_INIT_PHYSIC_DAMAGE);//玩家初始物理伤害为200
        player.setMagicDamage(Constants.PLAYER_INIT_MAGIC_DAMAGE);//玩家初始魔法伤害为0
        player.setPhysicDamage(Constants.PLAYER_INIT_PHYSIC_ARMOR);//初始物理抗性100
        player.setMagicArmor(Constants.PLAYER_INIT_MAGIC_ARMOR);//初始魔法抗性为0

        //初始装备栏为 空的集合
        List<Equipment> equipments = new ArrayList<>();
        player.setEquipments(equipments);
    }

    @Override
    public void buildPlayerSkills(){
        List<Skill> skills = new ArrayList<>();
        Skill skill1 = new Skill();
        skill1.setSkillName("致命打击");
        skill1.setLevel(1);
        skill1.setPhysicAdditionDamage(80);
        skill1.setMagicAdditionDamge(40);
        skill1.setMagicConsume(100);
        HashSet<Integer> trigerKey = new HashSet<>();
        skill1.setTrigerKey(trigerKey);
        skill1.setSkillExp(0);

        Skill skill2 = new Skill();
        skill2.setSkillName("勇气之光");
        skill2.setLevel(1);
        skill2.setPhysicAdditionDamage(120);
        skill2.setMagicAdditionDamge(40);
        skill2.setMagicConsume(150);
        HashSet<Integer> trigerKey2 = new HashSet<>();
        skill2.setTrigerKey(trigerKey2);
        skill2.setSkillExp(0);

        skills.add(skill1);
        skills.add(skill2);

        player.setSkills(skills);
        player.setCurrentSelectedSkillIndex(0); //设置一号技能为默认选择的技能
    }

    @Override
    public void buildPlayerWeapon(){
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon1 = new Weapon();
        weapon1.setWeaponName("大宝剑");
        weapon1.setLevelOfWeapon(1);
        weapon1.setWeaponDamage(120);   //初始的伤害为100
        weapons.add(weapon1);
        player.setWeapons(weapons);
        player.setCurrentWeapon(weapon1);
    }
}
