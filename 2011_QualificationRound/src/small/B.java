package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B implements Runnable {

	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "B-large-practice.in"; // attempt0
	static String outputFile = "B-large-practice.out";

	public static void main(String[] args) {
		new Thread(new B()).start();
	}

	public String readLine() throws Exception {

		return in.readLine();

	}

	public void run() {
		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));

			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void solve() throws Exception {

		int noOfCases = Integer.parseInt(readLine());

		for (int i = 0; i < noOfCases; i++) {

			HashMap<String, String> combineList = new HashMap<String, String>();
			List<String> opposeListFirstChar = new ArrayList<String>();
			List<String> opposeListSecondChar = new ArrayList<String>();
			String[] opposeIndexList = new String[26];

			String[] s = readLine().split(" ");

			int noOfCombines = Integer.parseInt(s[0]);
			for (int j = 1; j <= noOfCombines; j++) {
				String combination1 = String.valueOf(s[j].charAt(0))
						+ String.valueOf(s[j].charAt(1));
				String combination2 = String.valueOf(s[j].charAt(1))
						+ String.valueOf(s[j].charAt(0));

				String replacement = String.valueOf(s[j].charAt(2));

				combineList.put(combination1, replacement);
				combineList.put(combination2, replacement);

			}

			int noOfOppose = Integer.parseInt(s[noOfCombines + 1]);

			int jValue = 0;
			if (noOfCombines == 0) {
				jValue = 1;
			} else {
				jValue = noOfCombines;
			}
			if (noOfOppose == 0) {
				jValue = jValue++;
			} else {
				jValue = jValue + noOfOppose;
			}
			// System.out.println("Jvalue"+jValue);
			if (noOfOppose != 0) {
				for (int j = noOfCombines + 2; j <= (noOfCombines + noOfOppose + 1); j++) {
					String opposition = s[j];
					// System.out.println(s[j]);
					opposeIndexList[opposition.charAt(0) - 65] = opposeIndexList[opposition
							.charAt(0) - 65]
							+ String.valueOf(opposition.charAt(1));
					opposeIndexList[opposition.charAt(1) - 65] = opposeIndexList[opposition
							.charAt(1) - 65]
							+ String.valueOf(opposition.charAt(0));

					opposeListFirstChar
							.add(String.valueOf(opposition.charAt(0)));
					opposeListSecondChar.add(String.valueOf(opposition
							.charAt(1)));

					// Considering the reverse of letters hold
					opposeListFirstChar
							.add(String.valueOf(opposition.charAt(1)));
					opposeListSecondChar.add(String.valueOf(opposition
							.charAt(0)));

				}
			}

			int noOfElements = Integer
					.parseInt(s[noOfCombines + noOfOppose + 2]);
			String elementList = s[noOfCombines + noOfOppose + 3];
			System.out.println("Element List: " + elementList);
			List<String> resultList = new ArrayList<String>();
			String result = "[";
			resultList.add(String.valueOf(elementList.charAt(0)));

			List<String> elements = new ArrayList<String>();

			for (int j = 0; j < noOfElements; j++) {
				elements.add(String.valueOf(elementList.charAt(j)));
			}
			int loopIndex = 1;
			// System.out.println(combineList);
			while (loopIndex < elements.size()) {

				// String currentElement =
				// String.valueOf(elementList.charAt(loopIndex));
				System.out.println("elements: " + elements);
				System.out.println("resultList: " + resultList);
				String currentElement = elements.get(loopIndex);
				String forCombine = String.valueOf(elements.get(loopIndex - 1))
						+ currentElement;
				// System.out.println("forcombine: "+forCombine);
				if (combineList.containsKey(forCombine)) {
					if (resultList.size() > 0) {
						String temp = resultList.remove(resultList.size() - 1);
						// System.out.println("removed element: "+temp);
					}
					resultList.add(combineList.get(forCombine));
					elements.remove(loopIndex - 1);
					elements.remove(loopIndex - 1);
					elements.add(loopIndex - 1, combineList.get(forCombine));
					System.out.println("combine: resultList: " + resultList);
					System.out.println("combine: elements: " + elements);
					continue;

				}else if (opposeIndexList[currentElement.charAt(0) - 65] != null
						&& opposeIndexList[currentElement.charAt(0) - 65]
								.length() > 0) {

					System.out.println("current Element: " + currentElement);
					resultList.add(currentElement);

					char[] charSet = opposeIndexList[currentElement.charAt(0) - 65]
							.toCharArray();
					boolean opposed = false;
					for (int x = 0; x < charSet.length; x++) {
						if (resultList.contains(String.valueOf(charSet[x]))) {
							int len = resultList.size();
							resultList.removeAll(resultList);

							if (elements.size() > 0) {
								for (int m = 0; m < len; m++) {
									elements.remove(0);
								}
							}

							if (elements.size() > 0) {
								resultList.add(elements.get(0));
							}
							opposed = true;
							break;
						}

					}
					if (opposed) {
						loopIndex = 1;
					} else {
						loopIndex++;
					}

				} else {
					resultList.add(currentElement);
					loopIndex++;
				}

			}

			for (int j = 0; j < resultList.size(); j++) {
				if (j == 0) {
					result = result + resultList.get(j);
				} else {
					result = result + ", " + resultList.get(j);
				}
			}
			result = result + "]";

			System.out.println("Case #" + (i + 1) + ": " + result);
			out.write("Case #" + (i + 1) + ": " + result + "\n");
		}
	}
}
