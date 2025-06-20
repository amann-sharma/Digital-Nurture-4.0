public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.payAmount(1500);
        context.setPaymentStrategy(new PayPalPayment("priya@gmail.com"));
        context.payAmount(2500);
    }
} 