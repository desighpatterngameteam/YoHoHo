package bean;

public class Weapon {

    public Weapon(){}

    public String weaponName;   //武器名称
    public int levelOfWeapon;   //武器等级
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
