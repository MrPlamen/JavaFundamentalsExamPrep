package MidExamFundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] neighbourhood = Arrays.stream(sc.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();

        int jumpLength;
        int jumpPosition = 0;
        String command = sc.nextLine();

        while (!command.equals("Love!")) {
            String[] commandLine = command.split("\\s+");

            jumpLength = Integer.parseInt(commandLine[1]);
            jumpPosition += jumpLength;

            if (jumpPosition >= neighbourhood.length || jumpPosition < 0) {
                jumpPosition = 0;
            }
            if (neighbourhood[jumpPosition] > 0) {
                neighbourhood[jumpPosition] -= 2;
                if (neighbourhood[jumpPosition] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", jumpPosition);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", jumpPosition);
            }
            command = sc.nextLine();
        }

        int failedHouses = 0;
        for (int i = 0; i < neighbourhood.length; i++) {
            if (neighbourhood[i] > 0) {
                failedHouses++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", jumpPosition);
        if (failedHouses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", failedHouses);
        }
    }
}
