package MidExamFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numberLine = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        String command = sc.nextLine();
        while (!command.equals("end")) {
            String[] commandLine = command.split(" ");
            if (commandLine[0].equals("decrease")) {
                for (int i = 0; i < numberLine.length; i++) {
                    numberLine[i] -= 1;
                }
            } else if (commandLine[0].equals("swap")) {
                int swapNumberOne = Integer.parseInt(commandLine[1]);
                int swapNumberTwo = Integer.parseInt(commandLine[2]);

                int memory = numberLine[swapNumberTwo];
                numberLine[swapNumberTwo] = numberLine[swapNumberOne];
                numberLine[swapNumberOne] = memory;
            } else if (commandLine[0].equals("multiply")) {
                int numberOne = Integer.parseInt(commandLine[1]);
                int numberTwo = Integer.parseInt(commandLine[2]);

                numberLine[numberOne] *= numberLine[numberTwo];
            }
            command = sc.nextLine();
        }
        for (int element : numberLine) {
            if (element != numberLine[numberLine.length - 1]) {
                System.out.print(element + ", ");
            } else {
                System.out.println(element);
            }
        }
    }
}
