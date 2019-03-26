package exception;

/**
 * 使用Weapon攻击时，出现调用计算伤害函数computeDamage(),SkillNumber不为-1的错误情况
 */
public class AttackException extends Exception {
    public AttackException(String message){
        super(message);
    }
}
