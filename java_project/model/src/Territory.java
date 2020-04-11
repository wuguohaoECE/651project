public class Territory {
    private String territoryName;
    private Player territoryOwner;
    private int territoryUnits;

    public Territory(String name, Player owner, int unit) {
        this.territoryName = name;
        this.territoryOwner = owner;
        this.territoryUnits = unit;
    }
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
