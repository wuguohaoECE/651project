public abstract class Order {
    protected Player player;
    protected Territory from;
    protected Territory to;
    protected int unit;
    protected String type;

    public Order(Player orderer, Territory from, Territory to, int unit, String type){
        this.player = orderer;
        this.from = from;
        this.to = to;
        this.unit = unit;
        this.type = type;
    }
    public Player getPlayer(){
        return player;
    }
    public Territory getFrom(){
        return from;
    }
    public Territory getTo(){
        return to;
    }
    public String getType(){
        return type;
    }
    //注意execute前需要先check是否可行
    public abstract void execute();
}

