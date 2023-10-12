public class App {
    public static void main(String[] args) throws Exception {

        Manufacture mercedes = new Manufacture("Mercedes-Benz"); // Combustion Car
        Manufacture audi = new Manufacture("Audi"); // Electric Car
        Manufacture bmw = new Manufacture("BMW"); // Hybrid Car

        CombustionEngine mercedesEngine = new CombustionEngine();
        ElectricEngine audiEngine = new ElectricEngine();
        HybridEngine bmwEngine = new HybridEngine();

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new ICEV(mercedes, mercedesEngine);
        vehicles[1] = new BEV(audi, audiEngine);
        vehicles[2] = new HybridV(bmw, bmwEngine);

        for(int i = 0; i < vehicles.length; i++) {
            System.out.println("Manufacture: " + vehicles[i].getManufacture().getMake());
            System.out.print("Characteristics: ");
            vehicles[i].ShowCharacteristics();
            System.out.println();
        }

    }

}
