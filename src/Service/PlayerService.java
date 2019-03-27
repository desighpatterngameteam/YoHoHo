package Service;

import Game.Store.EquipmentStore;
import bean.Equipment;
import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;
import exception.NotEnoughCashException;

public interface PlayerService {

    public void BuyEquipment(EquipmentStore equipmentStore, int equipmentIndex) throws NotEnoughCashException;

    public void AttackMonsterWithWeapon( Monster monster) throws AttackException;

    public void AttackMonsterWithSkill( Monster monster , String attackInfo) throws AttackException;

    /**根据Swing 购买强化技能的装备界面，购买完后，选择需要强化的技能
     * function:设置 装备用来强化的技能的索引index号（每个英雄 有 2个技能 ， 0 对应第一个技能 ，1 对应第二个技能）
     * @param skillIndex
     */
    public void SetCurrentSelectedSkill( int skillIndex);

}
