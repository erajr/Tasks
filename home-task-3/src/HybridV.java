public class HybridV extends Vehicle {

    public HybridV(Manufacture manufacture, HybridEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Hybrid vehicle characteristics");
    }    
    
}
