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

}