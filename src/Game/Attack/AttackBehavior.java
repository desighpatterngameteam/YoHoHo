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

    public int computeDamage(Player player, Skill skill) throws AttackException;

    public void attackEnemy(Player player, Skill skill , Monster monster) throws AttackException;
}
