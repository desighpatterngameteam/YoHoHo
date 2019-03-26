package util;

public class Level {

    public Level(){

    }

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


}
