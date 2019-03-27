package Game.Attack;

import Game.Attack.AttackBehavior;
import bean.Constants;
import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;

public class AttackWithSkill implements AttackBehavior {

    /**
     * 计算此次攻击的总伤害
     * @param player
     * @param skill
     * @return
     * @throws AttackException
     */
    @Override
    public int computeDamage(Player player , Skill skill) throws AttackException {
        if (skill == null){
            throw new AttackException("使用技能攻击，出现技能为空异常");
        }
        else {
            int sumOfDamage = 0;
            sumOfDamage += skill.getPhysicAdditionDamage() + player.getPhysicDamage();
            sumOfDamage += skill.getMagicAdditionDamge() + player.getMagicDamage();
            return sumOfDamage;
        }
    }

    /**
     * 攻击敌方
     * @param player
     * @param skill
     * @param monster
     * @throws AttackException
     */
    @Override
    public void attackEnemy(Player player , Skill skill , Monster monster)throws AttackException {

        if (skill == null){
            throw new AttackException("使用技能攻击，出现技能为空异常");
        }else {
            int damage = computeDamage(player , skill);
            int bloodOfMonster = monster.getBlood();
            if (bloodOfMonster - damage < 0 ){
                System.out.println("--------------------------------------");
                monster.setBlood(0);

//                player
                player.updateExp(monster);
                player.updateCash(monster);
                System.out.println("--------------------------------------");
            }else {
                monster.setBlood(bloodOfMonster-damage);
                System.out.println("--------------------------------------");
                monster.print();
                System.out.println("--------------------------------------");
            }
        }
    }
}
