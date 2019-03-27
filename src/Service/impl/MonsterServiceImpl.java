package Service.impl;

import Game.Attack.AttackByMonster;
import Service.MonsterService;
import bean.Monster;
import bean.Player;

public class MonsterServiceImpl implements MonsterService {

    /**
     * 攻击 英雄
     * @param monster
     * @param player
     */
    @Override
    public void AttackPlayer(Monster monster, Player player){
        AttackByMonster attackByMonster = monster.getAttackByMonster();
        attackByMonster.attackPlayer(monster,player);
    }
}
