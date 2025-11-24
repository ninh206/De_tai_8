import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextInt()) {
            System.out.print("Vui long nhap so nguyen hop le: ");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Xoa bo dem dong
        return result;
    }

    public static double getDouble(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Vui long nhap so thuc hop le: ");
            scanner.next();
        }
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }

    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }
}