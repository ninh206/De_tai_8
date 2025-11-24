public class TestRunner {
    public static void runAllTests() {
        System.out.println("=== BAT DAU CHAY TEST CASE ===");
        testBookingSuccess();
        testBookingFail();
        testCalculateInvoice();
        System.out.println("=== KET THUC TEST CASE ===");
    }

    // Cac ham test se them sau
    private static void testBookingSuccess() { System.out.println("Test 1: Pending..."); }
    private static void testBookingFail() { System.out.println("Test 2: Pending..."); }
    private static void testCalculateInvoice() { System.out.println("Test 3: Pending..."); }
}