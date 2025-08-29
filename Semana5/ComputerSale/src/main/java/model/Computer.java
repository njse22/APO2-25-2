package model;

public class Computer implements Comparable<Computer> {

    // Brand
    private String id;
    private String brand;
    private int ram;
    private int processors;
    private double processingSpeed;
    private char operatingSystem;

    public Computer(String id, String brand,  int ram, int processors, double processingSpeed, char operatingSystem) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.processors = processors;
        this.processingSpeed = processingSpeed;
        this.operatingSystem = operatingSystem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getProcessors() {
        return processors;
    }

    public void setProcessors(int processors) {
        this.processors = processors;
    }

    public double getProcessingSpeed() {
        return processingSpeed;
    }

    public void setProcessingSpeed(double processingSpeed) {
        this.processingSpeed = processingSpeed;
    }

    public char getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(char operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(Computer o) {
        return this.brand.compareTo(o.getBrand());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", brand =" + brand +
                ", ram=" + ram +
                ", processors=" + processors +
                ", processingSpeed=" + processingSpeed +
                ", operatingSystem=" + operatingSystem +
                '}';
    }
}
