package example.codeclan.com.rockpaperscissors2;


import java.util.Random;

public class Computer {

    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public static void main(String[] args) {

    }


}
