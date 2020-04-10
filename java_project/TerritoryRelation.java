import java.util.*;


public class Territory{
    private String territoryName;
    private Player territoryOwner;
    private int territoryUnits;

    public String getName() {
        return territoryName;
    }

    public Player getOwner() {
        return territoryOwner;
    }

    public int getUnits{
        return territoryUnits;
    }

    public void setUnits(int num){
        territoryUnits = num;
    }

    public void setOwner(Player player){
        territoryOwner = player;
    }

}

public class Player{
    private String playerName;
    private  Set<Territory> territories;

    public String getName() {
        return playerName;
    }

    public void addTerritory(Territory){
        territories.add(Territory);
    }

    public void lossTerritory(Territory){
        territories.remove(Territory);
    }

    public void getTerritories(){
        return territories;
    }

}

public class TerritoryRelation{
    private Map<Territory, Set<Territory>> territoryGraph;

    public boolean checkReachable(Territory A, Territory B){
        Player OwnerA = A.getOwner();
        Player OwnerB = B.getOwner();

        if(OwnerA != OwnerB){
            return false;
        }
        Set<Territory> Used;
        Queue<Territory> queue;
        Used.add(A);
        queue.add(A);
        while(!queue.isEmpty()){
            Territory curr = queue.poll(); //当前可达的领地
            if(territoryGraph.get(curr).contains(B)){
                return true;
            }
            for (Territory temp : OwnerA.getTerritories();) {
                //判断哪些属于该这玩家的领地是和当前领地相连,并加入queue
                if(territoryGraph.get(curr).contains(temp) && !Used.contains(temp)) {
                    queue.add(temp);
                    Used.add(temp);
                }
            }
        }
        return false;
    }

    public boolean checkAttackable(Territory A, Territory B){
        Player OwnerA = A.getOwner();
        Player OwnerB = B.getOwner();
        if(OwnerA == OwnerB){
            return false;
        }
        return territoryGraph.get(A).contains(B);
    }
}