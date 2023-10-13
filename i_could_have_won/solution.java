package i_could_have_won;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String games = input.nextLine().trim();
            ArrayList<Integer> wins = new ArrayList<>();

            for (int k = 0; k < games.length(); k++) {
                int alicePoints = 0;
                int aliceWins = 0;
                int bobPoints = 0;
                int bobWins = 0;
                for (String win : games.split("")) {
                    if (win.equals("A")) {
                        alicePoints++;
                    } else if (win.equals("B")) {
                        bobPoints++;
                    }

                    if (bobPoints >= k) {
                        bobWins++;
                    }

                    if (alicePoints >= k) {
                        aliceWins++;
                    }

                    if (alicePoints >= k || bobPoints >= k) {
                        alicePoints = 0;
                        bobPoints = 0;
                    }
                }
                if (aliceWins > bobWins) {
                    wins.add(k);
                }
            }
            String output = "";
            System.out.println(wins.size());
            for (Integer k : wins) {
                output += Integer.toString(k) + " ";
            }
            System.out.print(output.trim());
        }
    }
}