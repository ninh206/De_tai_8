public class VipDiscount implements DiscountPolicy {
    @Override
    public double getDiscountAmount(double totalAmount) {
        // Giam 5% neu hoa don > 1 trieu
        return (totalAmount > 1000000) ? totalAmount * 0.05 : 0.0;
    }
}