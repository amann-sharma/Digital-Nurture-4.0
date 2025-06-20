public class ComputerBuilderTest {
    public static void main(String[] args) {
        Computer basicPC = new Computer.Builder()
                .setCpu("Intel i3")
                .setRam("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println("Basic PC: " + basicPC);

        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel i7")
                .setRam("32GB")
                .setStorage("1TB SSD")
                .setGpu("NVIDIA RTX 3060")
                .build();
        System.out.println("Gaming PC: " + gamingPC);
    }
} 