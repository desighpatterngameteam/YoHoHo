package Service;

import bean.Monster;
import bean.Player;

public interface MonsterService {

    /**
     * 攻击 英雄
     * @param monster
     * @param player
     */
    public void AttackPlayer(Monster monster, Player player);

}
