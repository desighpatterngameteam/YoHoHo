package Game.Attack;

import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;

/**
 * 使用策略模式 实现攻击行为
 * 攻击行为可以分为 （武器进攻 和 技能进攻）,使用两种策略实现，
 * 具体可以在用户选择进攻形式时，使用setAttackBehavior方法去实现
 */
public interface AttackBehavior {

    /**
     * 注意计算伤害的时候
     * 使用武器攻击时：伤害 = 角色物理伤害 + 武器的 WeaponDamage
     * 使用技能攻击时：伤害 = 角色物理伤害+角色魔法伤害 + 技能的物理伤害+技能的魔法伤害
     * @param player
     * @param skill
     * @return
     * @throws AttackException
     */
    public int computeDamage(Player player, Skill skill) throws AttackException;

    public void attackEnemy(Player player, Skill skill , Monster monster) throws AttackException;
}
