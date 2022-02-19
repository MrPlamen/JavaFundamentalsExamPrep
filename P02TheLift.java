package MidExamFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean alreadyPrinted = false;

        int peopleWaiting = Integer.parseInt(sc.nextLine());
        int[] wagons = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();


        for (int i = 0; i < wagons.length; i++) {
            if (peopleWaiting <= 0) {
                break;
            }
            int availableSpace = 4 - wagons[i];
            if (peopleWaiting > availableSpace) {
                if (i == wagons.length-1) {
                    wagons[i] = 4;
                    peopleWaiting -= availableSpace;
                    System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
                    break;
                } else {
                    wagons[i] = 4;
                    peopleWaiting -= availableSpace;
                }
            } else {
                wagons[i] += peopleWaiting;
                peopleWaiting -= availableSpace;
                if (i == wagons.length-1 && wagons[i] < 4) {
                    System.out.println("The lift has empty spots!");
                    alreadyPrinted = true;
                    break;
                }
            }
        }
        if (wagons[wagons.length-1] < 4 && peopleWaiting <= 0 && !alreadyPrinted) {
            System.out.println("The lift has empty spots!");
        }
        for (int element : wagons) {
            System.out.print(element + " ");
        }
    }
}
