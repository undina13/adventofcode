package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/adventofcode/src/advent/day2.txt");
        FileReader fr = new FileReader(file);
//      Map<String, Integer> combinations = Map.of( "A X", 4,
//                "A Y", 8,
//                "A Z", 3,
//                "B X", 1,
//                "B Y", 5,
//                "B Z", 9,
//                "C X", 7,
//                "C Y", 2,
//                "C Z", 6);

        Map<String, Integer> combinations = Map.of( "A X", 3,
                "A Y", 4,
                "A Z", 8,
                "B X", 1,
                "B Y", 5,
                "B Z", 9,
                "C X", 2,
                "C Y", 6,
                "C Z", 7);

       int score = 0;
        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        while (line != null) {
           score+=combinations.get(line);

            line = reader.readLine();
        }
        fr.close();
        System.out.println(score);

    }
}
