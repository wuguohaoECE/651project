public class AttackOrder extends Order {
    @Override
    public void execute() {
        int To_Unit = to.getUnits();
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
    }
}
