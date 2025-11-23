public class StandardTable extends Table {
    public StandardTable(String id, int seats) {
        super(id, seats);
    }
    @Override
    public double getSurcharge() { return 0.0; }
}