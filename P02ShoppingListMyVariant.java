package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingListMyVariant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> items = Arrays.stream(sc.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] inputLine = input.split(" ");
            switch (inputLine[0]) {
                case "Urgent":
                    if (!items.contains(inputLine[1])) {
                        items.add(0, inputLine[1]);
                    }
                    break;
                case "Unnecessary":
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(inputLine[1])) {
                            items.remove(i);
                        }
                    }
                    break;
                case "Rearrange":
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(inputLine[1])) {
                            items.add(inputLine[1]);
                            items.remove(i);
                        }
                    }
                    break;
                case "Correct":
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).equals(inputLine[1])) {
                            items.set(i, inputLine[2]);
                        }
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < items.size(); i++) {
            if (i == items.size()-1) {
                System.out.print(items.get(i));
            } else {
                System.out.print(items.get(i) + ", ");
            }
        }
    }
}
