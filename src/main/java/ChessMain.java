import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {

        ChessMain chessMain = new ChessMain();
        ArrayList<Players> players = chessMain.createPlayers();
        for (Players play : players) {
            System.out.println(play);
        }
        HashMap<String, Piece> pieceHashMap = chessMain.createPiece();
        System.out.println(pieceHashMap);
        chessMain.play(players, pieceHashMap);

//        System.out.println("Введите имя грасмастера");
//        Scanner scanner = new Scanner(System.in);
//        String nameCus = scanner.nextLine();
//        String nameCus2 = scanner.nextLine();
//        System.out.println("Введите рейтинг грасмастера");
//        int reyt1 = scanner.nextInt();
//        int reyt2 = scanner.nextInt();
//        Players whitePlayer = new Players(nameCus, "gary@mail.ru", true, reyt1, 32);
//        Players blackPlayer = new Players(nameCus2, "rustam.Q@index.uz", false, reyt2, 25);

//        System.out.println(whitePlayer.getName() + "- самый круто грасместер в мире");
//        System.out.println(blackPlayer.getName() + "- самый молодой грасместер в мире, у него " + blackPlayer.getAge() + " лет");

//        System.out.println(whitePlayer);
//        try {
//            whitePlayer.setRank(8);
//        }catch (IllegalArgumentException err){
//            System.out.println(" bunday qima kuyasan" +
//                    "kuyasan");
//        }
//        System.out.println(whitePlayer.getRank());
    }
    public ArrayList<Players> createPlayers(){
        Players whitePlayer = new Players("garry  Gosparov", "gary@mail.ru", true, 2, 32);
        Players blackPlayer = new Players("Rustam Qosimjonov", "rustam.Q@index.uz", false, 7, 25);
        ArrayList<Players> list = new ArrayList<>();
        list.add(whitePlayer);
        list.add(blackPlayer);

        return list;
    }
    public HashMap<String, Piece> createPiece(){
        King whiteKing = new King(new Spot("h", 7), true, "King_white", false);
        Pawn whitePawn = new Pawn(new Spot("g", 7), true, "Pawn_white", false);
        Horse blackHorse = new Horse(new Spot("d", 6), false, "Horse_black", false);
        King blackKing = new King(new Spot("d", 8), false, "King_black", false);
        Pawn whitePawn2 = new Pawn(new Spot("a", 7), true, "Pawn_white2", false);

        HashMap<String, Piece> pieceHashMap = new HashMap<>();
        pieceHashMap.put(whiteKing.getId(), whiteKing);
        pieceHashMap.put(whitePawn.getId(), whitePawn);
        pieceHashMap.put(blackHorse.getId(), blackHorse);
        pieceHashMap.put(blackKing.getId(), blackKing);
        pieceHashMap.put(whitePawn2.getId(), whitePawn2);
        return pieceHashMap;
    }

    public void play(ArrayList<Players> players, HashMap<String, Piece> pieceHashMap){
        try{
            players.get(0).moviePiece(pieceHashMap.get("Pawn_white"), new Spot("a", 8));
        }
        catch (IllegalArgumentException error){
            System.out.println("the move is incorrect, please again");
            // retry functionality
        }
        players.get(1).moviePiece(pieceHashMap.get("Horse_black"), new Spot("c", 8));
    }
}
