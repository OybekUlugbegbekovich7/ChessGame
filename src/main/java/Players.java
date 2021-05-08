public class Players {
    private String name;
    private String email;
    private boolean white;
    private int rank;
    private int age;

    public Players(String name, String email, boolean white, int rank, int age)
    {
        if (name == null || name.isBlank() || name.isEmpty()){
            throw  new IllegalArgumentException("Введите имя грастметера");
        }
        this.name = name;
        if (email.isEmpty() || email.isBlank() || email == null){
            throw new IllegalArgumentException("The email should not be empty");
    }
        if (email.contains("@") == false || email.contains(".") == false){
            throw new IllegalArgumentException("The email adress should contain '@' and '.'" );
        }
        this.email = email;
        this.white = white;
        this.rank = rank;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public boolean getWhite(){
        return white;
    }
    public int getRank(){
        return rank;
    }
    public int getAge(){
        return age;
    }

    public String toString(){
        return "Chess Player name: " + name + " email: " + email + " rank: " + rank + " white: " + white
                + " age: " + age;
    }
    public void setRank(int rank){
        if(rank < 10 || rank > 300){
           throw new IllegalArgumentException("Не правилный код рейтингга");
        }
        this.rank = rank;
    }
    public void moviePiece(Piece piece, Spot spot){
        piece.setSpot(spot);
        System.out.println("Piece" + piece.getName() + " is move to " + spot);
    }
}
