public class AttackOrder extends Order {
    public AttackOrder(Player orderer, Territory from, Territory to, int unit){
        super(orderer,from,to,unit, "AttackOrder");
    }
    public void execute() {
        int To_Unit = unit;
        int From_Unit = from.getUnits();
        while(To_Unit != 0 && From_Unit != 0){
            if(Math.random() < 0.5){
                To_Unit--;
            }
            else{
                From_Unit--;
            }
        }
        if(From_Unit != 0){
            //attacker win
            to.setOwner(from.getOwner());
            to.setUnits(From_Unit);
        }
        else{
            //defender win
            to.setUnits(To_Unit);
        }
        from.lossUnits(unit);
    }
}
