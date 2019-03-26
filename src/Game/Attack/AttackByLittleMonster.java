package Game.Attack;

import bean.Monster;
import bean.Player;

public class AttackByLittleMonster implements AttackByMonster {

    @Override
    public int computeDamage(Player player, Monster monster){
        int armorSum = player.getPhysicArmor();
        int monsterPhysicDamage = monster.getPhysicDamage();
        return monsterPhysicDamage - armorSum;
    }

    @Override
    public void attackPlayer(Player player, Monster monster){
        int damage = computeDamage(player,monster);
        int currentHealthPoint = player.getHealthPoint();
        if( currentHealthPoint < damage){
            player.setHealthPoint(0);

        }else {
            player.setHealthPoint(currentHealthPoint-damage);
        }
    }
}
