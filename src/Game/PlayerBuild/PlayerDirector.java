package Game.PlayerBuild;

import bean.Player;

/**
 * 建造者模式的 Director
 */
public class PlayerDirector {
    private PlayerBuilder playerBuilder;

    public PlayerDirector(PlayerBuilder playerBuilder){
        this.playerBuilder = playerBuilder;
    }

    public void setPlayerBuilder(PlayerBuilder playerBuilder){
        this.playerBuilder = playerBuilder;
    }

    public Player construct(){
        playerBuilder.buildPlayerName();
        playerBuilder.buildPlayerDefaultAttribute();
        playerBuilder.buildPlayerSkills();
        playerBuilder.buildPlayerWeapon();

        return playerBuilder.getPlayer();
    }
}
