package fair_fare;

import java.util.*;

public class FairFare {

	private static Loc getDirectionAfterTurn(Loc oldDirection, String turn) {
		if (turn.equals("L")) {
			if (oldDirection.row == 1 && oldDirection.col == 0) {
				return new Loc(0, 1);
			}
			if (oldDirection.row == 0 && oldDirection.col == 1) {
				return new Loc(-1, 0);
			}
			if (oldDirection.row == -1 && oldDirection.col == 0) {
				return new Loc(0, -1);
			}
			if (oldDirection.row == 0 && oldDirection.col == -1) {
				return new Loc(1, 0);
			}
		} else {
			if (oldDirection.row == 1 && oldDirection.col == 0) {
				return new Loc(0, -1);
			}
			if (oldDirection.row == 0 && oldDirection.col == 1) {
				return new Loc(1, 0);
			}
			if (oldDirection.row == -1 && oldDirection.col == 0) {
				return new Loc(0, 1);
			}
			if (oldDirection.row == 0 && oldDirection.col == -1) {
				return new Loc(-1, 0);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNextLine()) {
			String[] route = in.nextLine().split("");
			Loc direction = new Loc(1, 0);
			Loc location = new Loc(0, 0);
			int cost = 0;
			for (String dir : route) {
				if (dir.equals("D")) {
					location = location.move(direction);
					cost++;
				} else {
					direction = getDirectionAfterTurn(direction, dir);
				}
			}
			int manDist = new Loc(0, 0).dist(location);
			if (cost <= manDist) {
				System.out.println("fair fare");
			} else {
				System.out.println("overpaid by " + (cost - manDist));
			}
		}

		in.close();
		System.exit(0);
	}

	record Loc(int row, int col) {
		Loc move(Loc direction) {
			return new Loc(this.row + direction.row, this.col + direction.col);
		}

		int dist(Loc other) {
			return Math.abs(this.row - other.row) + Math.abs(this.col - other.col);
		}
	}

}
