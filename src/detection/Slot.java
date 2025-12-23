package detection;


public class Slot {
    public int x;
    public int y;
    public boolean isFree;

    public Slot(int x, int y) {
        this.x = x;
        this.y = y;
        this.isFree = true;
    }
}