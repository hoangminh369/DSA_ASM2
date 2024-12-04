class Car{
    int year;
    String brand;
    String  color;
    public Car(String color, String brand, int year){
        this.brand = brand;
        this.color = color;
        this.year = year;
    }
    public void start() {

        System.out.println("The car is starting");
        
        }
        public void stop() {
        
        System.out.println("The car is stoping");
        
        }
        public void brake() {
        
        System.out.println("The car is braking");
        
        }
}

public class OOP {
    public static void main(String[] args) {
        Car car2 = new Car("Blue", "Volvo", 2020);
        }
}
