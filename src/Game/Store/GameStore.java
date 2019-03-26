package Game.Store;

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

        Equipment equipmentForW1 = new Equipment();
        equipmentForW1.setName("强化宝石");     //武器强化 ，只能强化物理普工
        equipmentForW1.setPhysicAdditon(100);
//        equipmentForW1.se
        Equipment equipmentForW2 = new Equipment();
        equipmentForW1.setName("进阶宝珠");     //武器强化 ，只能强化物理普工
        equipmentForW1.setPhysicAdditon(150);

        equipmentForWeaponStore.addEquipment(equipmentForW1);
        equipmentForWeaponStore.addEquipment(equipmentForW2);

        Equipment equipmentForS1 = new Equipment();
        equipmentForS1.setName("魔法诡书");
        equipmentForS1.setPhysicAdditon(50);
        equipmentForS1.setPhysicArmorAddition(0);
        equipmentForS1.setMagicAddition(200);
        equipmentForS1.setMagicArmorAddition(50);

        Equipment equipmentForS2 = new Equipment();
        equipmentForS2.setName("无尽之刃");
        equipmentForS2.setPhysicAdditon(200);
        equipmentForS2.setPhysicArmorAddition(50);
        equipmentForS2.setMagicAddition(0);
        equipmentForS2.setMagicArmorAddition(0);

        Equipment equipmentForS3 = new Equipment();
        equipmentForS3.setName("狂徒铠甲");
        equipmentForS3.setPhysicAdditon(50);
        equipmentForS3.setPhysicArmorAddition(100);
        equipmentForS3.setMagicAddition(0);
        equipmentForS3.setMagicArmorAddition(20);
        equipmentForS3.setHealthPointAddition(500);

        equipmentForSkillStore.addEquipment(equipmentForS1);
        equipmentForSkillStore.addEquipment(equipmentForS2);
        equipmentForSkillStore.addEquipment(equipmentForS3);

        gameStore.setEquipmentForWeaponStore(equipmentForWeaponStore);
        gameStore.setEquipmentForSkillStore(equipmentForSkillStore);
        return gameStore;
    }

}
