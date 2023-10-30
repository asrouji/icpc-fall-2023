package cables;

import java.util.*;
import java.util.stream.Stream;

public class Cables {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			double[] in = Stream.of(s.nextLine().split(" ")).mapToDouble(x -> Double.parseDouble(x)).toArray();
			double h1 = in[0] * 1.75, h2 = in[2] * 1.75;
			double d = Math.sqrt(Math.pow(h1 - h2, 2) + Math.pow(in[1] - in[3], 2));

			if (((d + 4) * 0.0254) < 0.5) {
				System.out.println(0.5);
			} else {
				double min = Math.min(in[1] + in[3], 38 - in[1] - in[3]) + Math.abs(h1 - h2);
				d = (min + 8) * 0.0254;
				// account for side
				if (d < 1) {
					System.out.println(1);
				} else if (d < 2) {
					System.out.println(2);
				} else if (d < 3) {
					System.out.println(3);
				} else {
					System.out.println(5);
				}
			}
		}
		s.close();
		System.exit(0);
	}
}