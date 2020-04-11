import java.util.HashMap;
import java.util.HashSet;

public class testModel {
    public static void main(String[] args){
        /* 创建对象 */
        Player green = new Player( "green" );
        Player blue = new Player( "blue" );
        Player red = new Player( "red" );

        Territory Narnia = new Territory("Narnia", green, 8);
        Territory Midkemia = new Territory("Midkemia", green, 3);
        Territory Oz = new Territory("Oz", green, 12);
        Territory Scadrial = new Territory("Scadrial", green, 10);

        green.addTerritory(Narnia);
        green.addTerritory(Midkemia);
        green.addTerritory(Oz);
        green.addTerritory(Scadrial);


        Territory Elantris = new Territory("Elantris", blue, 7);
        Territory Roshar = new Territory("Roshar", blue, 4);

        blue.addTerritory(Elantris);
        blue.addTerritory(Roshar);

        Territory Gondor = new Territory("Gondor", red, 14);
        Territory Mordor = new Territory("Mordor", red, 9);
        Territory Hogwarts = new Territory("Hogwarts", red, 5);

        red.addTerritory(Gondor);
        red.addTerritory(Mordor);
        red.addTerritory(Hogwarts);

        HashMap<Territory, HashSet<Territory>> map1 = new HashMap<Territory, HashSet<Territory>>();
        map1.put(Narnia, new HashSet<Territory>() {{
            add(Elantris);
            add(Midkemia);
        }});
        map1.put(Elantris, new HashSet<Territory>() {{
            add(Narnia);
            add(Midkemia);
            add(Scadrial);
            add(Roshar);
        }});
        map1.put(Midkemia, new HashSet<Territory>() {{
            add(Narnia);
            add(Elantris);
            add(Scadrial);
            add(Oz);
        }});
        map1.put(Scadrial, new HashSet<Territory>() {{
            add(Midkemia);
            add(Elantris);
            add(Roshar);
            add(Hogwarts);
            add(Mordor);
            add(Oz);
        }});
        map1.put(Roshar, new HashSet<Territory>() {{
            add(Elantris);
            add(Scadrial);
            add(Hogwarts);
        }});
        map1.put(Oz, new HashSet<Territory>() {{
            add(Midkemia);
            add(Scadrial);
            add(Mordor);
            add(Gondor);
        }});
        map1.put(Gondor, new HashSet<Territory>() {{
            add(Oz);
            add(Mordor);
        }});
        map1.put(Mordor, new HashSet<Territory>() {{
            add(Gondor);
            add(Oz);
            add(Scadrial);
            add(Hogwarts);
        }});
        map1.put(Hogwarts, new HashSet<Territory>() {{
            add(Mordor);
            add(Roshar);
            add(Scadrial);
        }});
        TerritoryRelation map = new TerritoryRelation(map1);


        System.out.println("Narnia to Scadrial :  " + map.checkReachable(Narnia,Scadrial) );
        System.out.println("Narnia to Hogwarts :  " + map.checkReachable(Narnia,Hogwarts) );

        System.out.println("Narnia attack Midkemia :  " + map.checkAttackable(Narnia,Midkemia) );
        System.out.println("Narnia attack Elantris :  " + map.checkAttackable(Narnia,Elantris) );

        System.out.println("before move, Narnia: " + Narnia.getUnits() + " Oz :  " +  Oz.getUnits());
        MoveOrder order1  = new MoveOrder(green,Narnia,Oz,3);
        order1.execute();
        System.out.println("after move, Narnia: " + Narnia.getUnits() + " Oz :  " +  Oz.getUnits());

        System.out.println("before attack, Oz: " + Oz.getUnits() + " Mordor :  " +  Mordor.getUnits() + " onwed by " + Mordor.getOwner().getName());
        AttackOrder order2  = new AttackOrder(green,Oz,Mordor,10);
        order2.execute();
        System.out.println("after attack, Oz: " + Oz.getUnits() + " Mordor :  " +  Mordor.getUnits()+ " onwed by " + Mordor.getOwner().getName());


    }
}
