package MidExamFundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> darts = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String indexTarget = sc.nextLine();
        int shotTarget = 0;
        int[] keepingTrack = new int[darts.size()];

        while (!(indexTarget).equals("End")) {
            shotTarget = Integer.parseInt(indexTarget);
            if (shotTarget < darts.size()) {
                keepingTrack[shotTarget] = -1;
                int shotValue = darts.get(shotTarget);
                darts.set(shotTarget, -1);
                for (int i = 0; i < darts.size(); i++) {
                    if (keepingTrack[i] != -1) {
                        if (darts.get(i) > shotValue) {
                            darts.set(i, (darts.get(i) - shotValue));
                        } else {
                            darts.set(i, (darts.get(i) + shotValue));
                        }
                    }
                }
            }
            indexTarget = sc.nextLine();
        }
        int sum = 0;
        for (int arrayPosition : keepingTrack) {
            if (arrayPosition == -1) {
                sum++;
            }
        }
        System.out.printf("Shot targets: %d -> ", sum);
        for (int var : darts) {
            System.out.print(var + " ");
        }
    }
}
