public class VipTable extends Table {
    public VipTable(String id, int seats) {
        super(id, seats);
    }
    @Override
    public double getSurcharge() { return 0.10; } // Phí 10%
}