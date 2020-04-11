import java.util.*;

public class TerritoryRelation {
    private HashMap<Territory, HashSet<Territory>> territoryGraph;

    public TerritoryRelation(HashMap<Territory, HashSet<Territory>> territoryGraph) {
        this.territoryGraph = territoryGraph;
    }

    public boolean checkReachable(Territory A, Territory B){
        Player OwnerA = A.getOwner();
        Player OwnerB = B.getOwner();

        if(OwnerA != OwnerB){
            return false;
        }
        HashSet<Territory> Used = new HashSet<>();
        Queue<Territory> queue = new LinkedList<Territory>();
        Used.add(A);
        queue.add(A);
        while(!queue.isEmpty()){
            Territory curr = queue.poll(); //当前可达的领地
            if(territoryGraph.get(curr).contains(B)){
                return true;
            }
            for (Territory temp : OwnerA.getTerritories()) {
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
