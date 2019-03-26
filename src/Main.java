import Game.Attack.AttackBehavior;
import Game.Attack.AttackWithWeapon;
import Game.MonsterFactoryMethod.BossMonsterFactory;
import Game.MonsterFactoryMethod.LittleMonsterFactory;
import Game.MonsterFactoryMethod.MonsterFactory;
import Game.PlayerBuild.AsheBuilder;
import Game.PlayerBuild.GarenBuilder;
import Game.PlayerBuild.PlayerBuilder;
import Game.PlayerBuild.PlayerDirector;
import Game.Store.EquipmentForWeaponStore;
import Game.Store.EquipmentStore;
import Game.Store.GameStore;
import Service.PlayerService;
import Service.impl.PlayerServiceImpl;
import bean.Equipment;
import bean.Monster;
import bean.Player;
import exception.AttackException;
import exception.NotEnoughCashException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void test_BuyEquipment(){
        PlayerBuilder asheplayer = new  AsheBuilder();
        PlayerDirector director = new PlayerDirector(asheplayer);
        Player ashePlayer = director.construct();
        ashePlayer.print();

        GameStore gameStore = new GameStore();
        GameStore myGameStore = gameStore.initCreate();

        PlayerService playerService = new PlayerServiceImpl();
        EquipmentStore equipmentForWeaponStore = myGameStore.getEquipmentForWeaponStore();
        List<Equipment> allEquipmentsForWeapon = equipmentForWeaponStore.getAllEquipments();//取出所有的装备

        for(Equipment equipment : allEquipmentsForWeapon){
            try {
                playerService.BuyEquipment(equipment);
                System.out.println("----------这个是在Main里面打印的-----------");
                ashePlayer.print();
                System.out.println("---------------------------");
            } catch (NotEnoughCashException e) {
                e.printStackTrace();
                System.out.println("金币不足!");
                break;
            }
        }



    }

    public void testSkillEquipment(){
        PlayerBuilder garenplayer = new GarenBuilder();
        PlayerDirector director = new PlayerDirector(garenplayer);
        Player garenPlayer = director.construct();
        garenPlayer.print();

        GameStore gameStore = new GameStore();
        GameStore myGameStore = gameStore.initCreate();

        PlayerService playerService = new PlayerServiceImpl();
        EquipmentStore equipmentForSkillStore = myGameStore.getEquipmentForSkillStore();
        List<Equipment> allEquipmentsForSkill = equipmentForSkillStore.getAllEquipments();//取出所有的装备

        for(Equipment equipment : allEquipmentsForSkill){
            try {
                playerService.BuyEquipment(equipment);
                System.out.println("----------这个是在Main里面打印的-----------");
                System.out.print("买的是：");
                equipment.printall();
                garenPlayer.print();
                playerService.SetCurrentSelectedSkill((garenPlayer.getCurrentSelectedSkillIndex()+1)%2);
                System.out.println("---------------------------");
            } catch (NotEnoughCashException e) {
                e.printStackTrace();
                System.out.println("金币不足!");
                break;
            }
        }
    }

    public void testlist(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(200);

        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()){
            int b = (int)iterator1.next();
            System.out.print(b+" ");
        }
        System.out.println();
        int a = list.get(1);
        list.set(1,4);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            int b = (int)iterator.next();
            System.out.print(b+" ");
        }
        System.out.println();
    }

    public void testAttackWithKeyInfo(){
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
        try {
            playerService.AttackMonsterWithSkill(mb1,"1 q");
            playerService.AttackMonsterWithSkill(mb1,"1 q");
            playerService.AttackMonsterWithSkill(mb1,"2 w");
            playerService.AttackMonsterWithSkill(mb1,"1 q");
        } catch (AttackException e) {
            e.printStackTrace();
        }
        playerAshe.print();
    }

    public static void main(String[] args) {

        Main main = new Main();

//        main.test1();
//        try {
//            main.test2();
//        } catch (AttackException e) {
//            e.printStackTrace();
//        }
//        main.test_BuyEquipment();
//        main.testSkillEquipment();
        main.testAttackWithKeyInfo();
//        main.testlist();
//        String a = "1 2 3 w q";
//        String [] b = a.split(" ");
//        for(String i : b){
//            System.out.println(i);
//        }

    }
}
