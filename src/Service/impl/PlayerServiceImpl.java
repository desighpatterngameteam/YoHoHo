package Service.impl;

import Game.Attack.AttackBehavior;
import Game.Attack.AttackWithSkill;
import Game.Attack.AttackWithWeapon;
import bean.Equipment;
import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;
import exception.NotEnoughCashException;
import util.Level;

import java.util.List;

public class PlayerServiceImpl implements Service.PlayerService {

    private Player player = Player.getInstance();

    /**
     * 买装备  ，如果金币不足，输出金币不足异常
     * @param equipment
     * @throws NotEnoughCashException
     */
    @Override
    public void BuyEquipment(Equipment equipment) throws NotEnoughCashException {
        int currentCash = player.getCash();
        int cost = equipment.getCostOfEquipment();
        if(currentCash < cost){
            throw new NotEnoughCashException("金币不足");
        }else {
            player.setCash(currentCash-cost);
            List<Equipment> equipments = player.getEquipments();
            equipments.add(equipment);
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
     * @param skill
     * @throws AttackException
     */
    @Override
    public void AttackMonsterWithSkill( Monster monster , Skill skill) throws AttackException{
        AttackBehavior attackBehavior = new AttackWithSkill();
        player.setAttackBehavior(attackBehavior);
        attackBehavior.attackEnemy(player,skill,monster);

        /*以下为调试信息输出
         */
        System.out.println("--------------------------------------");
        player.print();
        monster.print();
        System.out.println("--------------------------------------");
    }



}
