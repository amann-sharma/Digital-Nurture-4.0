public class ProxyTest {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.jpg");
        img1.display(); // loads and displays
        img1.display(); // just displays,cached
        img2.display(); // loads and displays
    }
} 