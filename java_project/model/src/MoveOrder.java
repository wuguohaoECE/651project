public class MoveOrder extends Order {

    public MoveOrder(Player orderer, Territory from, Territory to, int unit){
        super(orderer,from,to,unit, "MoveOrder");
    }
    public void execute() {
        from.lossUnits(unit);
        to.addUnits(unit);
    }
}
