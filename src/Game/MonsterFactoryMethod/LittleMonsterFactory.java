package Game.MonsterFactoryMethod;

import Game.MonsterFactoryMethod.MonsterFactory;
import bean.Constants;
import bean.Monster;

/**
 * 具体的工程方法模式  中的小兵 子类
 */
public class LittleMonsterFactory extends MonsterFactory {

    @Override
    public Monster createMonster(){
        Monster monster = new Monster();
        monster.setName("百夫长");
        monster.setLevel(Constants.MONSTER_LEVEL_ARMY);
        monster.setPhysicDamage(Constants.MONSTER_PHYSIC_DAMAGE_ARMY);
        monster.setMagicDamage(Constants.MONSTER_MAGIC_DAMAGE_ARMY);
        monster.setExpAddition(Constants.MONSTER_EXPADDITION_ARMY);
        monster.setBlood(Constants.MONSTER_DEFAULT_BLOOD_ARMY);
        monster.setMoneyAddition(Constants.MONSTER_MONEYADDITION_ARMY);

        return monster;
    }
}
