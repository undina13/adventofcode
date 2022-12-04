package advent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/adventofcode/src/advent/day1.txt");
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        String line = reader.readLine();
        while (line != null) {

            if (line.isEmpty()) {
                list.add(0);

            } else {
                int num = Integer.parseInt(line);
                list.set(list.size() - 1, list.get(list.size() - 1) + num);
            }
            line = reader.readLine();
        }
        fr.close();

        Collections.sort(list);
      Collections.reverse(list);
        System.out.println(list);
        System.out.println(list.get(0) + list.get(1) + list.get(2));
    }
}
