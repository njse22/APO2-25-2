package ui;

import model.Computer;
import model.ComputerSale;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ComputerSale controller = new ComputerSale(new Computer[]{});
        Computer[] comps =  ComputerSale.generateRandomComputers(4);
        controller.setComputers(comps);
        printArray(controller.getComps());
        //controller.sortByBrandSelection();

        Comparator<Computer> comparator = (c1, c2) -> {
           return c1.getProcessors() - c2.getProcessors();
        };

        controller.selectionSort(comparator);

        System.out.println("********************************************************");
        printArray(controller.getComps());

    }

    public static void printArray(Computer[] sc){
        for(Computer c : sc){
            System.out.println(c);
        }
    }
}
