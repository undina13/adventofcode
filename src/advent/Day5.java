package advent;
//--- Day 5: Supply Stacks ---
//        The expedition can depart as soon as the final supplies have been unloaded from the ships. Supplies are stored in stacks of marked crates, but because the needed supplies are buried under many other crates, the crates need to be rearranged.
//
//        The ship has a giant cargo crane capable of moving crates between stacks. To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of carefully-planned steps. After the crates are rearranged, the desired crates will be at the top of each stack.
//
//        The Elves don't want to interrupt the crane operator during this delicate procedure, but they forgot to ask her which crate will end up where, and they want to be ready to unload them as soon as possible so they can embark.
//
//        They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input). For example:
//
//        [D]
//        [N] [C]
//        [Z] [M] [P]
//        1   2   3
//
//        move 1 from 2 to 1
//        move 3 from 1 to 3
//        move 2 from 2 to 1
//        move 1 from 1 to 2
//        In this example, there are three stacks of crates. Stack 1 contains two crates: crate Z is on the bottom, and crate N is on top. Stack 2 contains three crates; from bottom to top, they are crates M, C, and D. Finally, stack 3 contains a single crate, P.
//
//        Then, the rearrangement procedure is given. In each step of the procedure, a quantity of crates is moved from one stack to a different stack. In the first step of the above rearrangement procedure, one crate is moved from stack 2 to stack 1, resulting in this configuration:
//
//        [D]
//        [N] [C]
//        [Z] [M] [P]
//        1   2   3
//        In the second step, three crates are moved from stack 1 to stack 3. Crates are moved one at a time, so the first crate to be moved (D) ends up below the second and third crates:
//
//        [Z]
//        [N]
//        [C] [D]
//        [M] [P]
//        1   2   3
//        Then, both crates are moved from stack 2 to stack 1. Again, because crates are moved one at a time, crate C ends up below crate M:
//
//        [Z]
//        [N]
//        [M]     [D]
//        [C]     [P]
//        1   2   3
//        Finally, one crate is moved from stack 1 to stack 2:
//
//        [Z]
//        [N]
//        [D]
//        [C] [M] [P]
//        1   2   3
//        The Elves just need to know which crate will end up on top of each stack; in this example, the top crates are C in stack 1, M in stack 2, and Z in stack 3, so you should combine these together and give the Elves the message CMZ.
//
//        After the rearrangement procedure completes, what crate ends up on top of each stack?
//
//        Your puzzle answer was RNZLFZSJH.
//
//        The first half of this puzzle is complete! It provides one gold star: *
//
//        --- Part Two ---
//        As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.
//
//        Some mud was covering the writing on the side of the crane, and you quickly wipe it away. The crane isn't a CrateMover 9000 - it's a CrateMover 9001.
//
//        The CrateMover 9001 is notable for many new and exciting features: air conditioning, leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.
//
//        Again considering the example above, the crates begin in the same configuration:
//
//        [D]
//        [N] [C]
//        [Z] [M] [P]
//        1   2   3
//        Moving a single crate from stack 2 to stack 1 behaves the same as before:
//
//        [D]
//        [N] [C]
//        [Z] [M] [P]
//        1   2   3
//        However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order, resulting in this new configuration:
//
//        [D]
//        [N]
//        [C] [Z]
//        [M] [P]
//        1   2   3
//        Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
//
//        [D]
//        [N]
//        [C]     [Z]
//        [M]     [P]
//        1   2   3
//        Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
//
//        [D]
//        [N]
//        [Z]
//        [M] [C] [P]
//        1   2   3
//        In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.

//       Before the rearrangement process finishes, update your simulation so that the Elves know where they should stand to be ready to unload the final supplies. After the rearrangement procedure completes, what crate ends up on top of each stack?

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/adventofcode/src/advent/day5.txt");
        FileReader fr = new FileReader(file);


        BufferedReader reader = new BufferedReader(fr);

        String line = reader.readLine();
        ArrayList<String> list = new ArrayList<>();
        while (!"".equals(line)) {
            list.add(line);
            line = reader.readLine();
        }
        String[] counts = list.get(list.size() - 1).split(" ");
        int count = Integer.parseInt(counts[counts.length - 1]);
        list.remove(list.size() - 1);
//ArrayList<Stack<String>>staсk = new ArrayList<>();
        ArrayList<List<String>> staсk = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //   staсk.add(new Stack<>());
            staсk.add(new ArrayList<>());
        }

        for (int i = count - 2; i >= 0; i--) {
            int num = 1;
            for (int j = 0; j < count; j++) {

                if (!String.valueOf(list.get(i).charAt(num)).equals(" ")) {
//           Stack<String> st = staсk.get(j);
//           st.add(String.valueOf(list.get(i).charAt(num)));
//           staсk.set(j, st);
                    List<String> l = staсk.get(j);
                    l.add(String.valueOf(list.get(i).charAt(num)));
                }
                num += 4;
            }
        }

        line = reader.readLine();
        while (line != null) {
            String[] s = line.split(" ");
            int num = Integer.parseInt(s[1]);
            int from = Integer.parseInt(s[3]);
            int to = Integer.parseInt(s[5]);
            ArrayList<String> dd = new ArrayList<>();
            List<String> listFrom = staсk.get(from - 1);
            List<String> listTo = staсk.get(to - 1);
            for (int i = 0; i < num; i++) {
                dd.add(listFrom.get(listFrom.size() - 1));
                listFrom.remove(listFrom.size() - 1);
            }
            for (int i = num - 1; i >= 0; i--) {
                listTo.add(dd.get(i));
            }
//          staсk.set(Integer.parseInt(s[3])-1, from.subList(0, from.size()-num));
//          staсk.set(Integer.parseInt(s[5])-1, to);
            //          for (int i = 0; i < num; i++) {

//                String letter = staсk.get(from-1).pop();
//                staсk.get(to-1).push(letter);
            //          }

            line = reader.readLine();
        }
        for (int i = 0; i < count; i++) {
            //   System.out.print(staсk.get(i).pop());
            List<String> s = staсk.get(i);
            System.out.print(s.get(s.size() - 1));

        }

        reader.close();

    }
}
