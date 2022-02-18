package MidExamFundamentals;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employeeOneCapacity = Integer.parseInt(sc.nextLine());
        int employeeTwoCapacity = Integer.parseInt(sc.nextLine());
        int employeeThreeCapacity = Integer.parseInt(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        int initialStudents = students;

        int deskCapacity = employeeOneCapacity + employeeTwoCapacity + employeeThreeCapacity;
        int studentsLeft = 0;
        int count = 0;

        while (students > 0) {
            if (count%4 != 0) {
                students = students - deskCapacity;
            }
            count++;
        }
        if (initialStudents > 0) {
            System.out.printf("Time needed: %dh.", count - 1);
        } else {
            System.out.printf("Time needed: %dh.", count);
        }
    }
}
