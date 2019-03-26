package Service;

import bean.Equipment;
import bean.Monster;
import bean.Player;
import bean.Skill;
import exception.AttackException;
import exception.NotEnoughCashException;

public interface PlayerService {

    public void BuyEquipment(Equipment equipment) throws NotEnoughCashException;

    public void AttackMonsterWithWeapon( Monster monster) throws AttackException;

    public void AttackMonsterWithSkill( Monster monster , Skill skill) throws AttackException;


}
