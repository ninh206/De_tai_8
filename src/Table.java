import java.io.Serializable;

public abstract class Table implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected int seats;
    protected TableStatus status;

    public Table(String id, int seats) {
        this.id = id;
        this.seats = seats;
        this.status = TableStatus.AVAILABLE;
    }

    public abstract double getSurcharge();

    public String getId() { return id; }
    public int getSeats() { return seats; }
    public TableStatus getStatus() { return status; }
    public void setStatus(TableStatus status) { this.status = status; }

    @Override
    public String toString() {
        return id + " (" + seats + " ghe) - " + status;
    }
}