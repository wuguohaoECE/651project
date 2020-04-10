public class Territory {
    private String territoryName;
    private Player territoryOwner;
    private int territoryUnits;

    public String getName() {
        return territoryName;
    }

    public Player getOwner() {
        return territoryOwner;
    }

    public int getUnits(){
        return territoryUnits;
    }

    public void setUnits(int num){
        territoryUnits = num;
    }

    public void setOwner(Player player){
        territoryOwner = player;
    }

    public void addUnits(int num){
        territoryUnits += num;
    }

    public void lossUnits(int num){
        territoryUnits -= num;
    }
}
