package Game.PlayerBuild;

import bean.Player;

/**
 * 建造者模式里的 Builder抽象类
 */
public abstract class PlayerBuilder {

    protected Player player = Player.getInstance();

    public abstract void buildPlayerName();
    public abstract void buildPlayerDefaultAttribute();
    public abstract void buildPlayerSkills();
    public abstract void buildPlayerWeapon();

    public Player getPlayer(){
        return player;
    }

}
