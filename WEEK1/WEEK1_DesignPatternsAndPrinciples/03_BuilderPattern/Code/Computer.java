public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGpu() { return gpu; }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + (gpu != null ? ", GPU=" + gpu : "") + "]";
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
} 