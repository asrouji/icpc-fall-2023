package unary_numbers;

import java.util.*;

class Solution {

    private static String unary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append("1");
        }
        sb.append("0");
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextInt()) {
                int n = input.nextInt();
                System.out.println(n + " " + unary(n));
            }
        }
        System.exit(0);
    }

}
