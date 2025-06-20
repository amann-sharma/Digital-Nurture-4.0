public class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemote();
    }
    private void loadFromRemote() {
        System.out.println("Loading " + filename + " from remote server...");
    }
    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
} 