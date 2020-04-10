public class MoveOrder extends Order {
    @Override
    public void execute() {
        from.lossUnits(unit);
        to.addUnits(unit);
    }
}
