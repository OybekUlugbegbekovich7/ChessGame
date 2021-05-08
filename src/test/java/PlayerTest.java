import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class PlayerTest {

    private static ArrayList<Players> players;
    private static HashMap<String, Piece> pieceHashMap;
    @BeforeAll
    public static void setUp(){
        ChessMain chessMain = new ChessMain();
        players = chessMain.createPlayers();
        pieceHashMap = chessMain.createPiece();
    }
    @BeforeEach
    public void beforeEachTest(){
        System.out.println("Running before each");
    }
    @AfterEach
    public void afterEachtest(){
        System.out.println("Running after each");
    }
    @AfterAll
    public static void tearDown(){
        System.out.println("Running after all the test");
    }
    @Test
    public void validMoveTest(){
        players.get(0).moviePiece(pieceHashMap.get("King_white"), new Spot("h", 8));

        Assertions.assertEquals(8, pieceHashMap.get("King_white").getSpot().getY());
    }
    @Test
    public void playerCreationSuccessTest(){
        Players whitePlayers = new Players("garry  Gosparov", "gary@mail.ru", true, 2, 32);
        Assertions.assertEquals("garry  Gosparov", whitePlayers.getName());
        Assertions.assertEquals("gary@mail.ru", whitePlayers.getEmail());
        Assertions.assertEquals(true, whitePlayers.getWhite());
        Assertions.assertEquals(2, whitePlayers.getRank());
        Assertions.assertEquals(32, whitePlayers.getAge());
    }
    @ParameterizedTest
    @MethodSource("nameError")
    public void playerCreationIncorrectNameTest(String name){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           Players whitePlayer = new Players(name, "gary@mail.ru", true, 2, 32);
        });
    }

    @ParameterizedTest
    @MethodSource("emailError")
    public void playerCreationIncorrectEmailTest(String email){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Players whitePlayer = new Players("gary", email, true, 2, 32);
        });
    }

    static Stream<String> nameError(){
        return Stream.of("", "  ", null);
    }
    static Stream<String> emailError(){
        return Stream.of("", "  ", null, "gary", "garry.garymail.ru");
    }
}


