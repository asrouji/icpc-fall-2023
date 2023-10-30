package swamptalk;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Swamptalk {
	static Map<String, Integer> vars = new HashMap<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> program = new ArrayList<>();
		int programCounter = 0;
		Map<String, Integer> labels = new HashMap<>();

		while (s.hasNext()) {
			String line = s.nextLine().trim();
			if (line.length() > 0 && line.charAt(0) != '*') {
				program.add(line);
			}
		}

		String id = "([A-Za-z]\\w+)\\s*";
		String label = id + ":\\s*";
		Pattern labelPattern = Pattern.compile(label + "(.*)");
		for (int i = 0; i < program.size(); i++) {
			Matcher labelMatch = labelPattern.matcher(program.get(i));
			if (labelMatch.matches()) {
				labels.put(labelMatch.group(1), i);
			}
		}

		String keyword = "\\s*(set|show|halt|gotoif[zpm])\\s*";
		Pattern idPattern = Pattern.compile(id + "(.*)");
		Pattern instructionPattern = Pattern.compile("(" + label + ")?" + keyword + "(.*)");

		for (String line = program.get(programCounter); !line.contains("halt"); line = program.get(programCounter)) {
			Matcher instructionMatch = instructionPattern.matcher(line);
			instructionMatch.matches();
			switch (instructionMatch.group(3)) {
				case "set" -> {
					Matcher idMatch = idPattern.matcher(instructionMatch.group(4));
					idMatch.matches();
					vars.put(idMatch.group(1), evalExp(idMatch.group(2)));
				}
				case "show" -> {
					System.out.println(evalExp(instructionMatch.group(4)));
				}
				case "halt" -> {
					s.close();
					System.exit(0);
				}
				case "gotoifz" -> {
					Matcher labelMatch = idPattern.matcher(instructionMatch.group(4));
					labelMatch.matches();
					if (evalExp(labelMatch.group(2)) == 0) {
						programCounter = labels.get(labelMatch.group(1));
						continue;
					}
				}
				case "gotoifp" -> {
					Matcher labelMatch = idPattern.matcher(instructionMatch.group(4));
					labelMatch.matches();
					if (evalExp(labelMatch.group(2)) > 0) {
						programCounter = labels.get(labelMatch.group(1));
						continue;
					}
				}
				case "gotoifm" -> {
					Matcher labelMatch = idPattern.matcher(instructionMatch.group(4));
					labelMatch.matches();
					if (evalExp(labelMatch.group(2)) < 0) {
						programCounter = labels.get(labelMatch.group(1));
						continue;
					}
				}
			}

			programCounter++;
		}

		s.close();
		System.exit(0);
	}

	private static int evalExp(String exp) {
		exp = exp.replaceAll("\\s", "");
		int sum = 0;
		for (String e : exp.split("\\+")) {
			String[] splitE = e.split("-");
			for (int i = 0; i < splitE.length; i++) {
				if (i == 0) {
					try {
						sum += Integer.parseInt(splitE[i]);
					} catch (NumberFormatException _e) {
						sum += vars.getOrDefault(splitE[i], 0);
					}
				} else {
					try {
						sum -= Integer.parseInt(splitE[i]);
					} catch (NumberFormatException _e) {
						sum -= vars.getOrDefault(splitE[i].trim(), 0);
					}
				}
			}

		}

		return sum;
	}
}
