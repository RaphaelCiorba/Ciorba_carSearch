package carSearch;

import model.Car;

import java.util.HashMap;
import java.util.LinkedList;

public class CarDatabase {

    protected HashMap<String, Car> hm = new HashMap();

    public CarDatabase(){

        MagicGenerator magicGen = new MagicGenerator();

        for(int i = 0; i < 1000; i++){
            Car car = new Car();
            car.setLicensePlate(magicGen.getRandomLicencePlate());
            car.setManufacturer(magicGen.getRandomManufacturer());
            car.setModel(magicGen.getRandomModel(car.getManufacturer()));
            car.setColor(magicGen.getRandomColor());
            car.setOwner(magicGen.getRandomName());
            hm.put(car.getLicensePlate(), car);

            System.out.println(car.getLicensePlate());
        }

    }
    //selber nicht geschafft = Falkenberg hat es mir in der Schule erklärt
    public LinkedList<Car> search(String licensePlate, boolean exact){

        long startTime = System.currentTimeMillis();
        LinkedList<Car> vehicles = new LinkedList();

        if(exact){
            vehicles.add(hm.get(licensePlate));
            System.out.println("Search took: " + (System.currentTimeMillis() - startTime) + "ms (exact)");

            if(vehicles.getFirst() != null)
                return vehicles;
            else
                return null;
        }

        else{
            for(Car v : hm.values()){

                if(v.getLicensePlate().contains(licensePlate.toUpperCase())){
                    vehicles.add(v);
                }
            }
            System.out.println("Search took: " + (System.currentTimeMillis() - startTime) + "ms (pattern search)");
            return vehicles;
        }
    }

}