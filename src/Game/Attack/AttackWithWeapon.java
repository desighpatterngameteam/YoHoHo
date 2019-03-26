package Game.Attack;

import Game.Attack.AttackBehavior;
import Service.PlayerService;
import Service.impl.PlayerServiceImpl;
import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;
import util.Level;

public class AttackWithWeapon implements AttackBehavior {

    //这里为了使得使用武器和使用技能的接口一直，假设使用武器时的skill传入null
    PlayerService playerService;
    /***
     * 计算此次攻击的总伤害
     * @param player
     * @param skill
     * @return
     * @throws AttackException
     */
    @Override
    public int computeDamage(Player player , Skill skill ) throws AttackException {
        if(skill== null){
            return player.getPhysicDamage();    //使用武器进攻，其实就是平A
        }else {
            throw new AttackException("使用武器攻击时，调用计算伤害函数出错");
        }
    }

    /**
     * 攻击敌方，使敌方掉血
     * @param player
     * @param skill
     * @param monster
     * @throws AttackException
     */
    @Override
    public void attackEnemy(Player player , Skill skill ,Monster monster) throws AttackException {
        if (skill != null ){
            throw new AttackException("使用武器攻击时，调用计算伤害函数出错");
        }
        int damage = computeDamage(player,skill);
        int bloodOfMonster = monster.getBlood();
        if (bloodOfMonster - damage <= 0 ){
            monster.setBlood(0);
            player.updateExp(monster);

            System.out.println("用武器攻击小怪");
            System.out.println("--------------------------------------");
            player.print();
            monster.print();
            System.out.println("--------------------------------------");
        }else {
            monster.setBlood(bloodOfMonster-damage);

            System.out.println("用武器攻击小怪");
            System.out.println("--------------------------------------");
            player.print();
            monster.print();
            System.out.println("--------------------------------------");
        }
    }
}
