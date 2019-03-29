import Game.Attack.AttackBehavior;
import Game.Attack.AttackByMonster;
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
import Service.MonsterService;
import Service.PlayerService;
import Service.impl.MonsterServiceImpl;
import Service.impl.PlayerServiceImpl;
import bean.Equipment;
import bean.Monster;
import bean.Player;
import exception.AttackException;
import exception.NotEnoughCashException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class BackgroundPanel extends JPanel
{
    Image im;
    public BackgroundPanel(Image im)
    {
        this.im=im;
        this.setOpaque(true);
    }
    //Draw the back ground.
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }
}


public class Main extends JFrame {

    //创建一个容器
    Container ct ;
    //创建背景面板
    BackgroundPanel bgp;


    public Main(){
        super("YoHoHo战斗小游戏");
        this.setIconImage(( new ImageIcon("src/img/icon/icon.png")).getImage());
    }

    public void testSwing1(){
        ct  = this.getContentPane();
        this.setLayout(null);   //不采用任何布局
        //img\map\gameScene.jpg
        bgp = new BackgroundPanel(( new ImageIcon("src/img/others/gamestart.png")).getImage());
        
        bgp.setBounds(0 , 0,1067,600);
        ct.add(bgp);

        //创建按钮
//        JButton jb = new JButton("开始游戏");
//        jb.setBounds(500,300,200,50);
//        ct.add(jb);

        this.setSize(1067,600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        Main main = new Main();

        main.testSwing1();



    }





//    public void test1(){
//        MonsterFactory monsterFactory = new LittleMonsterFactory();
//        Monster ma = monsterFactory.createMonster();
//        System.out.println(ma.getBlood());
//
//        MonsterFactory monsterFactory1 = new BossMonsterFactory();
//        Monster mb = monsterFactory1.createMonster();
//        System.out.println(mb.getBlood());
//        System.out.println("Hello World!");
//
//        PlayerBuilder asheBuilder = new AsheBuilder();
//        PlayerDirector director = new PlayerDirector(asheBuilder);
//        Player player = director.construct();
////        Player player = Player.getInstance();
//        player.print();
//        AttackByMonster attackByMonster = ma.getAttackByMonster();
//        attackByMonster.attackPlayer(ma,player);
//        player.setAttackBehavior(new AttackWithWeapon());
//        AttackBehavior attackBehavior = player.getAttackBehavior();
//        try {
//            attackBehavior.attackEnemy(player , null,ma);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(ma.getBlood());
//        player.print();
//
//        ma.print();
//
//
//        Monster ma2 = (Monster) ma.clone();
//        ma2.print();
//
//    }
//
//    public void test2() throws AttackException {
//
//        MonsterFactory monsterFactory = new LittleMonsterFactory();
//        Monster mb1 = monsterFactory.createMonster();
//        Monster mb2 = monsterFactory.createMonster();
//        Monster mb3 = monsterFactory.createMonster();
//        Monster mb4 = monsterFactory.createMonster();
//
//        MonsterFactory monsterFactory1 = new BossMonsterFactory();
//        Monster mboss = monsterFactory1.createMonster();
//
//        PlayerBuilder asheBuilder = new AsheBuilder();
//        PlayerDirector director = new PlayerDirector(asheBuilder);
//        Player playerAshe = director.construct();
//        playerAshe.print();
//
//        MonsterService monsterService = new MonsterServiceImpl();
//        PlayerService playerService = new PlayerServiceImpl();
//        playerService.AttackMonsterWithWeapon(mb1);
//        playerService.AttackMonsterWithWeapon(mb1);
//
//        monsterService.AttackPlayer(mb1,playerAshe);
//
//        playerService.AttackMonsterWithWeapon(mb1);
//
//        playerService.AttackMonsterWithWeapon(mb2);
//        playerService.AttackMonsterWithWeapon(mb2);
//        playerService.AttackMonsterWithWeapon(mb2);
//
//        playerService.AttackMonsterWithWeapon(mb3);
//        playerService.AttackMonsterWithWeapon(mb3);
//        playerService.AttackMonsterWithWeapon(mb3);
//
//        monsterService.AttackPlayer(mb2,playerAshe);
//
//        playerService.AttackMonsterWithWeapon(mb4);
//        playerService.AttackMonsterWithWeapon(mb4);
//        playerService.AttackMonsterWithWeapon(mb4);
//
//        playerService.AttackMonsterWithWeapon(mboss);
//        playerService.AttackMonsterWithWeapon(mboss);
////        playerAshe = Player.getInstance();
//        playerAshe.print();
//
//        mb1.print();
//        System.out.println("mb1"+ mb1.getClass()+"是否存活："+mb1.isMonsterAlive());
//        mb2.print();
//        System.out.println("mb2"+mb2.getClass()+"是否存活："+mb2.isMonsterAlive());
//        mb3.print();
//        System.out.println("mb3"+mb3.getClass()+"是否存活："+mb3.isMonsterAlive());
//        mb4.print();
//        System.out.println("mb4"+mb4.getClass()+"是否存活："+mb4.isMonsterAlive());
//        mboss.print();
//        System.out.println("mboss"+mboss.getClass()+"是否存活："+mboss.isMonsterAlive());
//
//    }
//
//    public void test_BuyWeaponEquipment(){
//        PlayerBuilder asheplayer = new  AsheBuilder();
//        PlayerDirector director = new PlayerDirector(asheplayer);
//        Player ashePlayer = director.construct();
//        ashePlayer.print();
//
//        GameStore gameStore = new GameStore();
//        GameStore myGameStore = gameStore.initCreate();
//
//        PlayerService playerService = new PlayerServiceImpl();
//        EquipmentStore equipmentForWeaponStore = myGameStore.getEquipmentForWeaponStore();
//        List<Equipment> allEquipmentsForWeapon = equipmentForWeaponStore.getAllEquipments();//取出所有的装备
//
//        for(int i = 0 ; i < allEquipmentsForWeapon.size() ; i ++){
//            try {
//                playerService.BuyEquipment(equipmentForWeaponStore,i);
//                System.out.println("----------这个是在Main里面打印的-----------");
//                ashePlayer.print();
//                System.out.println("---------------------------");
//            } catch (NotEnoughCashException e) {
//                e.printStackTrace();
//                System.out.println("金币不足!");
//                break;
//            }
//        }
//
//
//
//    }
//
//    public void testSkillEquipment(){
//        PlayerBuilder garenplayer = new GarenBuilder();
//        PlayerDirector director = new PlayerDirector(garenplayer);
//        Player garenPlayer = director.construct();
//        garenPlayer.print();
//
//        GameStore gameStore = new GameStore();
//        GameStore myGameStore = gameStore.initCreate();
//
//        PlayerService playerService = new PlayerServiceImpl();
//        EquipmentStore equipmentForSkillStore = myGameStore.getEquipmentForSkillStore();
//        List<Equipment> allEquipmentsForSkill = equipmentForSkillStore.getAllEquipments();//取出所有的装备
//
//        for(int i = 0 ; i < allEquipmentsForSkill.size() ; i ++){
//            try {
//                playerService.BuyEquipment(equipmentForSkillStore , i);
//                System.out.println("----------这个是在Main里面打印的-----------");
//                System.out.print("买的是：");
//                allEquipmentsForSkill.get(i).printall();
//                garenPlayer.print();
//                playerService.SetCurrentSelectedSkill((garenPlayer.getCurrentSelectedSkillIndex()+1)%2);
//                System.out.println("---------------------------");
//            } catch (NotEnoughCashException e) {
//                e.printStackTrace();
//                System.out.println("金币不足!");
//                break;
//            }
//        }
//    }
//
//    public void testlist(){
//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(10);
//        list.add(200);
//
//        Iterator iterator1 = list.iterator();
//        while (iterator1.hasNext()){
//            int b = (int)iterator1.next();
//            System.out.print(b+" ");
//        }
//        System.out.println();
//        int a = list.get(1);
//        list.set(1,4);
//
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            int b = (int)iterator.next();
//            System.out.print(b+" ");
//        }
//        System.out.println();
//    }
//
//    public void testAttackWithKeyInfo(){
//        MonsterFactory monsterFactory = new LittleMonsterFactory();
//        Monster mb1 = monsterFactory.createMonster();
//        Monster mb2 = monsterFactory.createMonster();
//
//        MonsterFactory monsterFactory1 = new BossMonsterFactory();
//        Monster mboss = monsterFactory1.createMonster();
//
//        PlayerBuilder asheBuilder = new AsheBuilder();
//        PlayerDirector director = new PlayerDirector(asheBuilder);
//        Player playerAshe = director.construct();
//        playerAshe.print();
//
//        PlayerService playerService = new PlayerServiceImpl();
//        try {
//            playerService.AttackMonsterWithSkill(mb1,"1 q");
//            playerService.AttackMonsterWithSkill(mb1,"1 q");
//            playerService.AttackMonsterWithSkill(mb1,"2 w");
//            playerService.AttackMonsterWithSkill(mb1,"1 q");
//        } catch (AttackException e) {
//            e.printStackTrace();
//        }
//        playerAshe.print();
//    }
//        main.test1();
//        try {
//            main.test2();
//        } catch (AttackException e) {
//            e.printStackTrace();
//        }
//        main.test_BuyEquipment();
//        main.testSkillEquipment();
//        main.testSkillEquipment();
//        main.testAttackWithKeyInfo();
//        main.testlist();
//        String a = "1 2 3 w q";
//        String [] b = a.split(" ");
//        for(String i : b){
//            System.out.println(i);
//        }
}
