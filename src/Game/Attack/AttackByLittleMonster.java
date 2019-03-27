package Game.Attack;

import bean.Monster;
import bean.Player;

public class AttackByLittleMonster implements AttackByMonster {

    @Override
    public int computeDamage( Monster monster,Player player){
        int armorSum = player.getPhysicArmor();
        int monsterPhysicDamage = monster.getPhysicDamage();
        return monsterPhysicDamage - armorSum;
    }

    @Override
    public void attackPlayer( Monster monster,Player player){
        int damage = computeDamage(monster,player);
        int currentHealthPoint = player.getHealthPoint();
        if( currentHealthPoint < damage){
            player.setHealthPoint(0);

        }else {
            player.setHealthPoint(currentHealthPoint-damage);
        }
    }
}
