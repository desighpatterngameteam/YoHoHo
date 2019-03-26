package Game.Store;

import bean.Constants;
import bean.Equipment;

public class GameStore {

    EquipmentStore equipmentForWeaponStore ;
    EquipmentStore equipmentForSkillStore ;

    public GameStore(){}

    public EquipmentStore getEquipmentForWeaponStore() {
        return equipmentForWeaponStore;
    }

    public void setEquipmentForWeaponStore(EquipmentStore equipmentForWeaponStore) {
        this.equipmentForWeaponStore = equipmentForWeaponStore;
    }

    public EquipmentStore getEquipmentForSkillStore() {
        return equipmentForSkillStore;
    }

    public void setEquipmentForSkillStore(EquipmentStore equipmentForSkillStore) {
        this.equipmentForSkillStore = equipmentForSkillStore;
    }

    public GameStore initCreate(){
        GameStore gameStore = new GameStore();

        equipmentForSkillStore = new EquipmentForSkillStore();
        equipmentForWeaponStore = new EquipmentForWeaponStore();

        Equipment equipmentForW1 = new Equipment();
        equipmentForW1.setName("强化宝石");     //武器强化 ，只能强化物理普攻
        equipmentForW1.setEquipmentType(Constants.EQUIPMENT_FOR_WEAPON);
        equipmentForW1.setPhysicAdditon(100);
        equipmentForW1.setCostOfEquipment(150);


//        equipmentForW1.se
        Equipment equipmentForW2 = new Equipment();
        equipmentForW2.setName("进阶宝珠");     //武器强化 ，只能强化物理普攻
        equipmentForW2.setEquipmentType(Constants.EQUIPMENT_FOR_WEAPON);
        equipmentForW2.setPhysicAdditon(150);
        equipmentForW2.setCostOfEquipment(200);

        equipmentForWeaponStore.addEquipment(equipmentForW1);
        equipmentForWeaponStore.addEquipment(equipmentForW2);

        Equipment equipmentForS1 = new Equipment(); //技能强化装备
        equipmentForS1.setName("魔法诡书");
        equipmentForS1.setEquipmentType(Constants.EQUIPMENT_FOR_SKILL);
        equipmentForS1.setPhysicAdditon(50);
        equipmentForS1.setPhysicArmorAddition(0);
        equipmentForS1.setMagicAddition(200);
        equipmentForS1.setMagicArmorAddition(50);
        equipmentForS1.setCostOfEquipment(150);
        equipmentForS1.setSkillExpAddition(200);

        Equipment equipmentForS2 = new Equipment(); //技能强化装备
        equipmentForS2.setName("无尽之刃");
        equipmentForS2.setEquipmentType(Constants.EQUIPMENT_FOR_SKILL);
        equipmentForS2.setPhysicAdditon(200);
        equipmentForS2.setPhysicArmorAddition(50);
        equipmentForS2.setMagicAddition(0);
        equipmentForS2.setMagicArmorAddition(0);
        equipmentForS2.setCostOfEquipment(200);
        equipmentForS2.setSkillExpAddition(200);

        Equipment equipmentForS3 = new Equipment(); //技能强化装备
        equipmentForS3.setEquipmentType(Constants.EQUIPMENT_FOR_SKILL);
        equipmentForS3.setName("狂徒铠甲");
        equipmentForS3.setPhysicAdditon(50);    //加在技能的属性上
        equipmentForS3.setPhysicArmorAddition(100); //加在角色的物抗属性
        equipmentForS3.setMagicAddition(0);         //加在技能的属性上
        equipmentForS3.setMagicArmorAddition(20);   //加在角色的魔法抗性上
        equipmentForS3.setHealthPointAddition(500); //加在角色的生命值上
        equipmentForS3.setCostOfEquipment(250);
        equipmentForS3.setSkillExpAddition(200);

        equipmentForSkillStore.addEquipment(equipmentForS1);
        equipmentForSkillStore.addEquipment(equipmentForS2);
        equipmentForSkillStore.addEquipment(equipmentForS3);

        gameStore.setEquipmentForWeaponStore(equipmentForWeaponStore);
        gameStore.setEquipmentForSkillStore(equipmentForSkillStore);
        return gameStore;
    }

}
