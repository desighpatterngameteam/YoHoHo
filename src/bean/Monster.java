package bean;

public class Monster implements Cloneable{

    private String name;    //小怪名称
    private int level ;     //小怪等级
    private int physicDamage;   //物理伤害
    private int magicDamage;    //魔法伤害
    private int expAddition;    //等级加成（被玩家消灭后）
    private int blood;          //血条
    private int moneyAddition;  //金币加成（被玩家消灭后)

    public Monster(){}

    public Monster(String name, int level, int physicDamage, int magicDamage, int expAddition, int blood, int moneyAddition) {
        this.name = name;
        this.level = level;
        this.physicDamage = physicDamage;
        this.magicDamage = magicDamage;
        this.expAddition = expAddition;
        this.blood = blood;
        this.moneyAddition = moneyAddition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPhysicDamage() {
        return physicDamage;
    }

    public void setPhysicDamage(int physicDamage) {
        this.physicDamage = physicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getExpAddition() {
        return expAddition;
    }

    public void setExpAddition(int expAddition) {
        this.expAddition = expAddition;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getMoneyAddition() {
        return moneyAddition;
    }

    public void setMoneyAddition(int moneyAddition) {
        this.moneyAddition = moneyAddition;
    }

    public void attackPlayer(Player player){
        int temp_heath =  player.getHealthPoint() - (physicDamage+magicDamage);
        if( temp_heath<0 ){ //如果玩家血量不够，直接赋值为0
            player.setHealthPoint(0);
        }else {
            player.setHealthPoint(temp_heath);
        }
    }

    //判断怪兽是否还存活
    public boolean isMonsterAlive(){
        return blood>0 ? true : false ;
    }

    public Object clone(){
        Object object = null;
        try {
            object = super.clone();
        }catch (CloneNotSupportedException exception){
            System.err.println("Not support cloneable!");
        }
        return object;
    }

    //输出
    public void print(){
        System.out.println("怪兽名称："+getName()+'\t'+"等级："+getLevel()+'\t'+"物理伤害："+getPhysicDamage()+'\t'
        +"魔法伤害："+getMagicDamage()+'\t'+"等级加成："+getExpAddition()+'\t'+"血条："+getBlood()+'\t'+"金币加成："+
                getMoneyAddition());
    }

}