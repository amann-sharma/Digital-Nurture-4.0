public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor paytm = new PaytmAdapter(new PaytmGateway());
        PaymentProcessor gpay = new GooglePayAdapter(new GooglePayGateway());
        paytm.processPayment(500);
        gpay.processPayment(1200);
    }
} 