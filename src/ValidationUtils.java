public class ValidationUtils {

    public static boolean isValidPhone(String phone) {
        // Kiem tra so dien thoai phai la so va tu 10-11 ky tu
        return phone != null && phone.matches("\\d{10,11}");
    }

    public static boolean isValidDate(String date) {
        // Kiem tra dinh dang yyyy-MM-dd don gian
        return date != null && date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}