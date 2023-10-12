public class BEV extends Vehicle {

    public BEV(Manufacture manufacture, ElectricEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Battery Electric vehicle characteristics");
    }
    
}
