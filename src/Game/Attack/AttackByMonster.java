package Game.Attack;

import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;

public interface AttackByMonster {

    public int computeDamage(Player player, Monster monster) ;

    public void attackPlayer(Player player, Monster monster);

}
