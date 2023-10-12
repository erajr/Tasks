public class Manufacture {
    private String make;

    public Manufacture(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Manufacture [make=" + make + "]";
    }

    
}
