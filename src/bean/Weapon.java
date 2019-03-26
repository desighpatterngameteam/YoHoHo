package bean;

public class Weapon {

    public Weapon(){}

    public String weaponName;   //武器名称
    public int levelOfWeapon;   //武器等级 (设计的时候设计多了，后来觉得可以不要，毕竟只需要每次强化的时候增加武器的伤害)
    public int weaponDamage;    //武器伤害（游戏中规定所有武器只有物理伤害加成）

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getLevelOfWeapon() {
        return levelOfWeapon;
    }

    public void setLevelOfWeapon(int levelOfWeapon) {
        this.levelOfWeapon = levelOfWeapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public void print(){
        System.out.println("武器名称："+getWeaponName()+'\t'+"武器等级："+getLevelOfWeapon()+'\t'+"武器伤害："+getWeaponDamage());
    }
}
