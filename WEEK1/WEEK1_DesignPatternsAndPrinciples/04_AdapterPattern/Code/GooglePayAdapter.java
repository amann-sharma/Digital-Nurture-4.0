public class GooglePayAdapter implements PaymentProcessor {
    private GooglePayGateway gpay;
    public GooglePayAdapter(GooglePayGateway gpay) {
        this.gpay = gpay;
    }
    @Override
    public void processPayment(double amount) {
        gpay.makeGPayPayment(amount);
    }
} 