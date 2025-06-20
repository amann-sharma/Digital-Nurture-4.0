public class MobileApp implements Observer {
    private String user;
    public MobileApp(String user) {
        this.user = user;
    }
    @Override
    public void update(String stock, double price) {
        System.out.println("[Mobile] " + user + " notified: " + stock + " price is now Rs." + price);
    }
} 