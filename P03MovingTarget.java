package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] inputLine = input.split(" ");
            int index = Integer.parseInt(inputLine[1]);
            int power = Integer.parseInt(inputLine[2]);

            switch (inputLine[0]) {
                case "Shoot":
                    if (index >= 0 && index < targets.size()) {
                        if (targets.get(index) - power <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, targets.get(index) - power);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, power);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (index + power >= targets.size() || index - power < 0) {
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = index - power; i <= index + power; i++) {
                            targets.set(i, -1);
                        }
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            if (targets.get(i) != -1) {
                if (i == targets.size() - 1) {
                    System.out.print(targets.get(i));
                } else {
                    System.out.print(targets.get(i) + "|");
                }
            }
        }
    }
}
