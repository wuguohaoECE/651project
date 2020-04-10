import java.util.HashSet;
import java.util.Set;

public class Player {
    private String playerName;
    private HashSet<Territory> territories;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName;
    }

    public void addTerritory(Territory a){
        territories.add(a);
    }

    public void lossTerritory(Territory a){
        territories.remove(a);
    }

    public Set<Territory> getTerritories(){
        return territories;
    }
}
