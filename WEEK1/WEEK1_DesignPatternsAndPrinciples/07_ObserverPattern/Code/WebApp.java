public class WebApp implements Observer {
    private String user;
    public WebApp(String user) {
        this.user = user;
    }
    @Override
    public void update(String stock, double price) {
        System.out.println("[Web] " + user + " notified: " + stock + " price is now Rs." + price);
    }
} 