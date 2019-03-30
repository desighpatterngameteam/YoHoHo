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
 * 建造者 模式创建角色 艾希
 */

public class AsheBuilder extends PlayerBuilder {

    @Override
    public void buildPlayerName(){
        player.setName("艾希");
    }

    @Override
    public void buildPlayerDefaultAttribute(){
        player.setCash(Constants.PLAYER_INIT_MONEY);//设置初始金币
        player.setLevel(Constants.PLAYER_INIT_LEVEL);   //初始等级设置为0
        player.setExperience(Constants.PLAYER_INIT_EXPERIENCE);  //初始经验值为0
        player.setHealthPoint(Constants.PLAYER_INIT_HEALTHPOINT);//初始生命值1000
        player.setMagicPoint(Constants.PLAYER_INIT_MAGICPOINT);//初始魔法值1000
        player.setPhysicDamage(Constants.PLAYER_INIT_PHYSIC_DAMAGE);//玩家初始物理伤害为200
        player.setMagicDamage(Constants.PLAYER_INIT_MAGIC_DAMAGE);//玩家初始魔法伤害为0
        player.setPhysicDamage(Constants.PLAYER_INIT_PHYSIC_ARMOR);//初始物理抗性100
        player.setMagicArmor(Constants.PLAYER_INIT_MAGIC_ARMOR);//初始魔法抗性为0
        player.setImage(Constants.hero0);//添加图片
        //初始装备栏为 空的集合
        List<Equipment> equipments = new ArrayList<>();
        player.setEquipments(equipments);
    }

    @Override
    public void buildPlayerSkills(){
        List<Skill> skills = new ArrayList<>();
        Skill skill1 = new Skill();
        skill1.setSkillName("冰霜射击");
        skill1.setLevel(1);
        skill1.setPhysicAdditionDamage(100);
        skill1.setMagicAdditionDamge(50);
        skill1.setMagicConsume(200);
        HashSet<Integer> trigerKey = new HashSet<>();
        skill1.setTrigerKey(trigerKey);
        skill1.setSkillExp(0);

        Skill skill2 = new Skill();
        skill2.setSkillName("万箭齐发");
        skill2.setLevel(1);
        skill2.setPhysicAdditionDamage(200);
        skill2.setMagicAdditionDamge(50);
        skill2.setMagicConsume(200);
        HashSet<Integer> trigerKey1 = new HashSet<>();
        skill2.setTrigerKey(trigerKey1);
        skill2.setSkillExp(0);

        skills.add(skill1);
        skills.add(skill2);

        player.setSkills(skills);
        player.setCurrentSelectedSkillIndex(0);

    }

    @Override
    public void buildPlayerWeapon(){
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon1 = new Weapon();
        weapon1.setWeaponName("冰霜之箭");
        weapon1.setLevelOfWeapon(1);
        weapon1.setWeaponDamage(100);   //初始的伤害为100
        weapons.add(weapon1);
        player.setWeapons(weapons);
        player.setCurrentWeapon(weapon1);

    }
}
