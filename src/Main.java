import Game.Attack.AttackBehavior;
import Game.Attack.AttackWithWeapon;
import Game.MonsterFactoryMethod.BossMonsterFactory;
import Game.MonsterFactoryMethod.LittleMonsterFactory;
import Game.MonsterFactoryMethod.MonsterFactory;
import Game.PlayerBuild.AsheBuilder;
import Game.PlayerBuild.PlayerBuilder;
import Game.PlayerBuild.PlayerDirector;
import Service.PlayerService;
import Service.impl.PlayerServiceImpl;
import bean.Monster;
import bean.Player;
import exception.AttackException;

public class Main {

    public void test1(){
        MonsterFactory monsterFactory = new LittleMonsterFactory();
        Monster ma = monsterFactory.createMonster();
        System.out.println(ma.getBlood());

        MonsterFactory monsterFactory1 = new BossMonsterFactory();
        Monster mb = monsterFactory1.createMonster();
        System.out.println(mb.getBlood());
        System.out.println("Hello World!");

        PlayerBuilder asheBuilder = new AsheBuilder();
        PlayerDirector director = new PlayerDirector(asheBuilder);
        Player player = director.construct();
//        Player player = Player.getInstance();
        player.print();
        ma.attackPlayer(player);
        player.setAttackBehavior(new AttackWithWeapon());
        AttackBehavior attackBehavior = player.getAttackBehavior();
        try {
            attackBehavior.attackEnemy(player , null,ma);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ma.getBlood());
        player.print();

        ma.print();


        Monster ma2 = (Monster) ma.clone();
        ma2.print();

    }

    public void test2() throws AttackException {

        MonsterFactory monsterFactory = new LittleMonsterFactory();
        Monster mb1 = monsterFactory.createMonster();
        Monster mb2 = monsterFactory.createMonster();

        MonsterFactory monsterFactory1 = new BossMonsterFactory();
        Monster mboss = monsterFactory1.createMonster();

        PlayerBuilder asheBuilder = new AsheBuilder();
        PlayerDirector director = new PlayerDirector(asheBuilder);
        Player playerAshe = director.construct();
        playerAshe.print();

        PlayerService playerService = new PlayerServiceImpl();
        playerService.AttackMonsterWithWeapon(mb1);
        playerService.AttackMonsterWithWeapon(mb1);
        playerService.AttackMonsterWithWeapon(mb1);
        playerService.AttackMonsterWithWeapon(mb1);
        playerService.AttackMonsterWithWeapon(mb1);

        playerService.AttackMonsterWithWeapon(mb2);
        playerService.AttackMonsterWithWeapon(mb2);
        playerService.AttackMonsterWithWeapon(mb2);
        playerService.AttackMonsterWithWeapon(mb2);
        playerService.AttackMonsterWithWeapon(mb2);

        playerService.AttackMonsterWithWeapon(mboss);
        playerService.AttackMonsterWithWeapon(mboss);
//        playerAshe = Player.getInstance();
        playerAshe.print();


    }
    public static void main(String[] args) {

        Main main = new Main();
//        main.test1();
        try {
            main.test2();
        } catch (AttackException e) {
            e.printStackTrace();
        }

//        String a = "1 2 3 w q";
//        String [] b = a.split(" ");
//        for(String i : b){
//            System.out.println(i);
//        }

    }
}
