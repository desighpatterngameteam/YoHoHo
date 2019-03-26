package Game.MonsterFactoryMethod;

import Game.MonsterFactoryMethod.MonsterFactory;
import bean.Constants;
import bean.Monster;

/**
 * 提供具体实现的工厂方法模式的 Boss子类
 */
public class BossMonsterFactory extends MonsterFactory {

    @Override
    public Monster createMonster(){
        Monster monster = new Monster();
        monster.setName("哥斯拉");
        monster.setLevel(Constants.MONSTER_LEVEL_BOSS);
        monster.setPhysicDamage(Constants.MONSTER_PHYSIC_DAMAGE_BOSS);
        monster.setMagicDamage(Constants.MONSTER_MAGIC_DAMAGE_BOSS);
        monster.setExpAddition(Constants.MONSTER_EXPADDITION_BOSS);
        monster.setBlood(Constants.MONSTER_DEFAULT_BLOOD_BOSS);
        monster.setMoneyAddition(Constants.MONSTER_MONEYADDITION_BOSS);

        return monster;
    }
}
