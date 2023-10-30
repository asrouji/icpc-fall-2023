package balance_of_powers;

import java.util.*;

public class Balance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine(); // num legislators
		String[] legislators = in.nextLine().split(" ");
		Map<String, Integer> counts = new HashMap<String, Integer>();
		int maxCount = 0;
		String maxLegislator = "";
		for (String legislator : legislators) {
			int legislatorCount = counts.getOrDefault(legislator, 0) + 1;
			if (legislatorCount > maxCount) {
				maxCount = legislatorCount;
				maxLegislator = legislator;
			}
			counts.put(legislator, legislatorCount);
		}
		int lowerTwoTotal = 0;
		if (maxLegislator.equals("1")) {
			lowerTwoTotal = counts.getOrDefault("2", 0) + counts.getOrDefault("3", 0);
		} else if (maxLegislator.equals("2")) {
			lowerTwoTotal = counts.getOrDefault("1", 0) + counts.getOrDefault("3", 0);
		} else if (maxLegislator.equals("3")) {
			lowerTwoTotal = counts.getOrDefault("1", 0) + counts.getOrDefault("2", 0);
		}
		if (lowerTwoTotal >= maxCount) {
			System.out.println("Power Balanced");
		} else if (maxLegislator.equals("1")) {
			System.out.println("Future One Dominates");
		} else if (maxLegislator.equals("2")) {
			System.out.println("Two-gether Dominates");
		} else if (maxLegislator.equals("3")) {
			System.out.println("Triple Harmony Dominates");
		}
		in.close();
		System.exit(0);
	}

}
