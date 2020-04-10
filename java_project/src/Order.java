public abstract class Order {
    protected Player player;
    protected Territory from;
    protected Territory to;
    protected int unit;
    protected String type;

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

