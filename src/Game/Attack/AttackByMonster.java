package Game.Attack;

import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;

public interface AttackByMonster {

    public int computeDamage(Monster monster,Player player) ;

    public void attackPlayer(Monster monster,Player player);

}
