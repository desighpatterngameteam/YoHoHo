package Service.impl;

import Game.Attack.AttackBehavior;
import Game.Attack.AttackWithSkill;
import Game.Attack.AttackWithWeapon;
import Game.Store.EquipmentStore;
import Game.Store.GameStore;
import bean.*;
import exception.AttackException;
import exception.NotEnoughCashException;
import util.Level;

import java.util.List;

public class PlayerServiceImpl implements Service.PlayerService {

    private Player player = Player.getInstance();

    /**
     * 买装备  ，如果金币不足，输出金币不足异常
     * 调用说明：Swing中的 商品栏里有 两个部分：1是 强化武器的装备栏，2是 强化技能的装备栏
     *          玩家选择强化武器的装备栏 传入 equipmentForWeaponStore ， 并传入 玩家选的 equipmentIndex
     * @param equipmentStore
     * @param equipmentIndex
     * @throws NotEnoughCashException
     */
    @Override
    public void BuyEquipment(EquipmentStore equipmentStore, int equipmentIndex) throws NotEnoughCashException {

        List<Equipment> equipments1 = equipmentStore.getAllEquipments();
        Equipment equipment = equipments1.get(equipmentIndex);

        int currentCash = player.getCash();
        int cost = equipment.getCostOfEquipment();
        System.out.println("当前花费的 金币是："+cost);
        if(currentCash < cost){
            throw new NotEnoughCashException("金币不足");
        }else {
            player.setCash(currentCash-cost);
            System.out.println("当前金币是："+player.getCash());
            List<Equipment> equipments = player.getEquipments();
            equipments.add(equipment);

            if(equipment.getEquipmentType()== Constants.EQUIPMENT_FOR_WEAPON){  //如果是强化武器的装备
                Weapon currentWeapon = player.getCurrentWeapon();
                currentWeapon.setWeaponDamage(currentWeapon.getWeaponDamage() + equipment.getPhysicAdditon());
            }else {//否则是强化技能的装备
                List<Skill> skills = player.getSkills();
                Skill currentselectedSkill = skills.get(player.getCurrentSelectedSkillIndex());
                currentselectedSkill.setPhysicAdditionDamage(currentselectedSkill.getPhysicAdditionDamage()+equipment.getPhysicAdditon());
                currentselectedSkill.setMagicAdditionDamge(currentselectedSkill.getMagicAdditionDamge()+equipment.getMagicAddition());
                Skill skill = new Skill();
                Skill skill_updated = skill.updateSkillExp(currentselectedSkill , equipment);//更新该技能的经验值 和 等级
                System.out.println("---------------------------");
                skill_updated.print();
                System.out.println("---------------------------");
                skills.set(player.getCurrentSelectedSkillIndex() , skill_updated);
                player.setSkills(skills);
            }

            player.setPhysicArmor(player.getPhysicArmor() + equipment.getPhysicArmorAddition());
            player.setMagicArmor(player.getMagicArmor()+equipment.getMagicArmorAddition());
            player.setHealthPoint(player.getHealthPoint() + equipment.getHealthPointAddition());

            System.out.println("----------强化之后的角色属性---------------");
            player.print();
            System.out.println("---------------------------");
        }
    }

    /**
     * 使用武器攻击怪兽
     * @param monster
     * @throws AttackException
     */
    @Override
    public void AttackMonsterWithWeapon( Monster monster) throws AttackException {
        AttackBehavior attackWithWeapon = new AttackWithWeapon();
        player.setAttackBehavior(attackWithWeapon);
        attackWithWeapon.attackEnemy(player,null,monster);

    }

    /**
     * 使用技能攻击怪兽
     * @param monster
     * @param attackInfo    Swing传过来的攻击信息 ，可以是 "1 q" 或者"2 w" ."1 q"使用1技能，"2 w"使用2技能
     * @throws AttackException
     */
    @Override
    public void AttackMonsterWithSkill( Monster monster , String attackInfo) throws AttackException{
        Skill skill = player.findSkillByKeyInput(attackInfo);   //根据键盘的信息 得出发出的技能
        AttackBehavior attackBehavior = new AttackWithSkill();
        player.setAttackBehavior(attackBehavior);
        attackBehavior.attackEnemy(player,skill,monster);
        /*以下为调试信息输出
         */
        System.out.println("--------------------------------------");
        System.out.println("本次使用技能 "+skill.getSkillName()+" 攻击");
        player.print();
        monster.print();
        System.out.println("--------------------------------------");
    }

    /**Description:根据Swing 购买强化技能的装备界面，购买完后，选择需要强化的技能，在Swing界面记录玩家所选择的技能编号index
     * function: 设置 装备用来强化的技能的索引index号（每个英雄 有 2个技能 ， 0 对应第一个技能 ，1 对应第二个技能）
     * @param skillIndex
     */
    @Override
    public void SetCurrentSelectedSkill( int skillIndex){

        player.setCurrentSelectedSkillIndex(skillIndex);

    }

}
