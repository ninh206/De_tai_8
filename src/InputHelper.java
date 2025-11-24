import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    // Nhap so nguyen co gioi han min
    public static int getInt(String prompt, int min) {
        int result;
        while (true) {
            System.out.print(prompt + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Vui long nhap so nguyen hop le: ");
                scanner.next();
            }
            result = scanner.nextInt();
            scanner.nextLine(); // Xoa bo dem
            if (result >= min) break;
            System.out.println("Gia tri phai >= " + min);
        }
        return result;
    }

    public static int getInt(String prompt) {
        return getInt(prompt, Integer.MIN_VALUE);
    }

    // Nhap so thuc co gioi han min
    public static double getDouble(String prompt, double min) {
        double result;
        while (true) {
            System.out.print(prompt + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Vui long nhap so thuc hop le: ");
                scanner.next();
            }
            result = scanner.nextDouble();
            scanner.nextLine();
            if (result >= min) break;
            System.out.println("Gia tri phai >= " + min);
        }
        return result;
    }

    public static double getDouble(String prompt) {
        return getDouble(prompt, -Double.MAX_VALUE);
    }

    // Nhap chuoi khong duoc de trong
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        String s = scanner.nextLine().trim();
        while (s.isEmpty()) {
            System.out.print("Khong duoc de trong. " + prompt + ": ");
            s = scanner.nextLine().trim();
        }
        return s;
    }
}