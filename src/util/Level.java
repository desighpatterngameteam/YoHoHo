package util;

public class Level {

    public Level(){

    }

    /**
     * 查找玩家角色 升级到下一级需要的经验
     * @param level
     * @return
     */
    public static int findPlayerExpByLevel(int level){
        int res = 0;
        switch (level){
            case 1: res = 1000;    break;
            case 2: res = 3000;    break;
            case 3: res = 6000;    break;
            case 4: res = 10000;   break;
            case 5: res = 15000;   break;
            default:break;
        }
        return res;
    }

    /**
     * 查找技能升级 要升到当前级数下一级需要的经验值
     * @param level 级数
     * @return
     */
    public static int findSkillExpByLevel(int level){
        int exp = 0;
        switch (level){
            case 1: exp = 1000; break;
            case 2: exp = 2000; break;
            case 3: exp = 3000; break;
            default:break;
        }
        return exp;
    }


}
