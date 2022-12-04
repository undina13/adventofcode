package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/adventofcode/src/advent/day3.txt");
        FileReader fr = new FileReader(file);
        Map<String, Integer> combinations = new HashMap<>();
        int sum = 1;

        for (char i = 'a'; i <= 'z'; i++) {
            combinations.put(String.valueOf(i), sum);
            sum++;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            combinations.put(String.valueOf(i), sum);
            sum++;
        }


        BufferedReader reader = new BufferedReader(fr);

//        String line = reader.readLine();
//        int score = 0;
//        while (line != null) {
//            String line1 = line.substring(0, (line.length()) / 2);
//            String line2 = line.substring((line.length()) / 2, line.length());
//            for (int i = 0; i < line1.length(); i++) {
//                if (line2.contains(String.valueOf(line1.charAt(i)))) {
//                    score += combinations.get(String.valueOf(line1.charAt(i)));
//                    break;
//                }
//            }
//            line = reader.readLine();
//        }

        String line1 = reader.readLine();
        String line2 = reader.readLine();
        String line3 = reader.readLine();
        int score = 0;
        while (line3 != null) {

            for (int i = 0; i < line1.length(); i++) {
                if (line2.contains(String.valueOf(line1.charAt(i)))&&line3.contains(String.valueOf(line1.charAt(i)))) {
                    score += combinations.get(String.valueOf(line1.charAt(i)));
                    break;
                }
            }
            line1 = reader.readLine();
            line2 = reader.readLine();
            line3 = reader.readLine();
        }
        reader.close();
        System.out.println(score);
    }
}
