package MidExamFundamentals;

import java.util.*;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numberLine = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        List<Integer> topNumbers = new ArrayList<>();

        int sum = 0;
        for (int element : numberLine) {
            sum += element;
        }
        int average = sum / numberLine.length;

        int count = 0;
        for (int element : numberLine) {
            if (element > average) {
                topNumbers.add(element);
                count++;
            }
        }

        Collections.sort(topNumbers, Collections.reverseOrder());

        if (count == 0) {
            System.out.println("No");
        } else {
            int availableTopNumbers = 0;
            if (topNumbers.size() > 5) {
                availableTopNumbers = 5;
            } else {
                availableTopNumbers = topNumbers.size();
            }
            for (int i = 0; i < availableTopNumbers; i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        }
    }
}
