package bean;

public class Equipment {
    private String name;    //装备名称
    private int physicAdditon;  //物理攻击加成
    private int magicAddition;  //魔法攻击加成
    private int physicArmorAddition;    //物理防御加成
    private int magicArmorAddition;     //魔法抗性加成
    private int healthPointAddition;    //生命值加成
    private int costOfEquipment;        //金币

    public Equipment(){}


    public Equipment(String name, int physicAdditon, int magicAddition, int physicArmorAddition, int magicArmorAddition, int healthPointAddition) {
        this.name = name;
        this.physicAdditon = physicAdditon;
        this.magicAddition = magicAddition;
        this.physicArmorAddition = physicArmorAddition;
        this.magicArmorAddition = magicArmorAddition;
        this.healthPointAddition = healthPointAddition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysicAdditon() {
        return physicAdditon;
    }

    public void setPhysicAdditon(int physicAdditon) {
        this.physicAdditon = physicAdditon;
    }

    public int getMagicAddition() {
        return magicAddition;
    }

    public void setMagicAddition(int magicAddition) {
        this.magicAddition = magicAddition;
    }

    public int getPhysicArmorAddition() {
        return physicArmorAddition;
    }

    public void setPhysicArmorAddition(int physicArmorAddition) {
        this.physicArmorAddition = physicArmorAddition;
    }

    public int getMagicArmorAddition() {
        return magicArmorAddition;
    }

    public void setMagicArmorAddition(int magicArmorAddition) {
        this.magicArmorAddition = magicArmorAddition;
    }
    public int getHealthPointAddition() {
        return healthPointAddition;
    }

    public void setHealthPointAddition(int healthPointAddition) {
        this.healthPointAddition = healthPointAddition;
    }

    public int getCostOfEquipment() {
        return costOfEquipment;
    }

    public void setCostOfEquipment(int costOfEquipment) {
        this.costOfEquipment = costOfEquipment;
    }

    //test
    public void printall(){
        System.out.println("装备名称:"+getName()+'\t'+"物理加成："+getPhysicAdditon()+'\t'+"魔法加成："+getMagicAddition()+'\n'+
                "物抗加成："+getPhysicArmorAddition()+'\t'+"魔抗加成："+getMagicArmorAddition());
    }

}
