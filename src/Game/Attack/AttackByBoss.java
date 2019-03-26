package Game.Attack;

import bean.Monster;
import bean.Player;

public class AttackByBoss implements AttackByMonster {

    @Override
    public int computeDamage(Player player, Monster monster) {
        int damage = 0;
        damage += (player.getPhysicArmor() >= monster.getPhysicDamage()? 0:(monster.getPhysicDamage()-player.getPhysicArmor()) );
        damage += (player.getMagicArmor() >= monster.getMagicDamage()?0:(monster.getMagicDamage()-player.getMagicArmor()));
        return damage;
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
