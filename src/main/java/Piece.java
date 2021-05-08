public abstract class Piece {
    private String name;
    private Spot spot;
    private boolean white;
    private String id;
    private boolean killed;

    public Piece(String name, Spot spot, boolean white, String id, boolean killed){
        this.name = name;
        this.spot = spot;
        this.white = white;
        this.id = id;
        this.killed = killed;
    }
    public String getName(){
        return name;
    }
    public Spot getSpot(){
        return spot;
    }
    public boolean getWhite(){
        return white;
    }
    public String getId(){
        return id;
    }
    public boolean getKilled(){
        return killed;
    }
    public void setSpot(Spot spot){
        this.spot = spot;
    }
    public void setKilled(boolean killed){
        this.killed = killed;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", spot=" + spot +
                ", white=" + white +
                ", id='" + id + '\'' +
                ", killed=" + killed +
                '}';
    }
}
