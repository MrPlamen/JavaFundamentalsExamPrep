package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> items = Arrays.stream(sc.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] inputLine = input.split("\\s+");
            switch (inputLine[0]) {
                case "Urgent":
                    if (!items.contains(inputLine[1])) {
                        items.add(0, inputLine[1]);
                    }
                    break;
                case "Unnecessary":
                    if (items.contains(inputLine[1])) {
                        items.remove(inputLine[1]);
                    }
                    break;
                case "Rearrange":
                    if (items.contains(inputLine[1])) {
                        items.add(inputLine[1]);
                        items.remove(items.indexOf(inputLine[1]));
                    }

                    break;
                case "Correct":
                    if (items.contains(inputLine[1])) {
                        items.set(items.indexOf(inputLine[1]), inputLine[2]);
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < items.size(); i++) {
            if (i == items.size() - 1) {
                System.out.print(items.get(i));
            } else {
                System.out.print(items.get(i) + ", ");
            }
        }
    }
}
