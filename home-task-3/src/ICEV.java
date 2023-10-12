public class ICEV extends Vehicle {

    public ICEV(Manufacture manufacture, CombustionEngine engine) {
        super(manufacture, engine);
    }

    @Override
    public void ShowCharacteristics() {
        System.out.println("Internal Combustion Engine Vehcile Characteristics");
    }    

}
