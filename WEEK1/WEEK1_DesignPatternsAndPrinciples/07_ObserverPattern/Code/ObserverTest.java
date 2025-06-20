public class ObserverTest {
    public static void main(String[] args) {
        StockMarket tcs = new StockMarket("TCS", 3500);
        Observer rahulMobile = new MobileApp("Rahul");
        Observer priyaWeb = new WebApp("Priya");
        tcs.registerObserver(rahulMobile);
        tcs.registerObserver(priyaWeb);
        tcs.setPrice(3550);
        tcs.setPrice(3600);
        tcs.removeObserver(rahulMobile);
        tcs.setPrice(3700);
    }
} 