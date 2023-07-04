package MidExamFundamentals;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double food = Double.parseDouble(sc.nextLine());
        double hay = Double.parseDouble(sc.nextLine());
        double cover = Double.parseDouble(sc.nextLine());
        double pigWeight = Double.parseDouble(sc.nextLine());


        for (int i = 1; i <= 30; i++) {
            if (food - 0.3 <= 0) {
                System.out.println("Merry must go to the pet store!");
                isEmpty = true;
                break;
            } else {
                food -= 0.3;
            }
            if (i % 2 == 0) {
                if ((hay - 0.05 * food) <= 0) {
                    System.out.println("Merry must go to the pet store!");
                    isEmpty = true;
                    break;
                } else {
                    hay -= 0.05 * food;
                }
            }
            if (i % 3 == 0) {
                if ((cover - (0.3333) * pigWeight) <= 0) {
                    System.out.println("Merry must go to the pet store!");
                    isEmpty = true;
                    break;
                } else {
                    cover -= (0.3333) * pigWeight;
                }
            }
        }
        if (!isEmpty) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    food, hay, cover);
        }
    }
}
