package model;


import java.util.*;

public class ComputerSale {
    private List<Computer> comps;

    public ComputerSale(Computer[] computers) {
        this.comps = Arrays.asList(computers);
    }

    public void setComputers(Computer[] computers) {
        comps = Arrays.asList(computers);
    }

    public Computer[] getComps() {
        return comps.toArray(new Computer[comps.size()]);
    }

    public void selectionSort(Comparator<Computer> comparator){
        for(int i = 0; i < comps.size() -1; i++){
            for(int j = i+1; j < comps.size(); j++){
                if(comparator.compare(comps.get(i), comps.get(j)) > 0) {
                    Computer min = comps.get(j);
                    Computer max = comps.get(i);

                    comps.set(i, min);
                    comps.set(j, max);
                }
            }
        }
    }

    public void sortByBrandSelection(){
        for(int i = 0; i < comps.size() -1; i++){
            for(int j = i+1; j < comps.size(); j++){
                if(comps.get(i).compareTo(comps.get(j)) > 0) {
                    Computer min = comps.get(j);
                    Computer max = comps.get(i);

                    comps.set(i, min);
                    comps.set(j, max);
                }
            }
        }
    }

    public void sortByBrandInsertion(){

    }

    // inserción
    public void sortByBrand(){

    }

    // Burbuja
    public void sortByProcessing(){
        int n = comps.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                double processingA = comps.get(j).getProcessors() * comps.get(j).getProcessingSpeed();
                double processingB = comps.get(j+1).getProcessors() * comps.get(j+1).getProcessingSpeed();
                if (processingA > processingB) {
                    Computer temp = comps.get(j);
                    comps.set(j, comps.get(j + 1));
                    comps.set(j + 1, temp);
                }
            }
        }
    }

    // debe utilizar el ordenamiento de la clase Arrays teniendo en cuenta que primero debe ordenar
    // por marca, y si son iguales, el criterio de desempate es el sistema operativo. Debe definir una clase que implemente
    // Comparator en otro archivo.
    public void sortByBrandAndOS(){
    }

    // debe utilizar ordenamiento de la clase Arrays. La clase que implementa Comparator debe ser anónima.
    public void sortByRam(){
    }

    // lleva a cabo el ordenamiento basado en compareTo usando Arrays, pero en orden
    //inverso al definido en compareTo, sin modificar dicho método y sin definir una nueva clase que implemente
    //Comparator.
    public void sortByBrandReverse(){
    }

    /**
     * Generates an array of {@code Computer} objects with random attributes.
     * This method creates a specified number of computers, assigning random
     * values for RAM, processors, processing speed, and operating system to each one.
     * The ID for each computer is generated as a unique UUID.
     *
     * @param c The total number of computers to generate.
     * This should be a non-negative integer value.
     * @return A fixed-size array containing {@code Computer} objects with
     * randomized attributes.
     */
    public static Computer[] generateRandomComputers(int c) {
        Random random = new Random();
        Computer[] computers = new Computer[c];

        for (int i = 0; i < c; i++) {
            String id = UUID.randomUUID().toString();
            int ram = (random.nextInt(4) + 1) * 4;
            int processors = random.nextInt(4) + 1;
            double processingSpeed = 1.5 + (4.5 - 1.5) * random.nextDouble();

            char[] osOptions = {'W', 'L', 'M'};
            char operatingSystem = osOptions[random.nextInt(osOptions.length)];
            String[] brandOptions = {"1", "2", "3", "4"};
            String brand = brandOptions[random.nextInt(brandOptions.length)];

            computers[i] = new Computer(id, brand, ram, processors, processingSpeed, operatingSystem);
        }
        return computers;
    }


}
