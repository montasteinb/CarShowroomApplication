import cars.Car;
import cars.ShowRoom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

 public class Main {

     ShowRoom showRoom = new ShowRoom();
     Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {
         Main main = new Main();
         main.showMenu();
     }
     void showMenu(){
         String userInput = "";
         do {
             System.out.println("Welcome to the show room, please choose activity: ");
             System.out.println("1. Add car");
             System.out.println("2. View All Car");
             System.out.println("3. View Single Car");
             System.out.println("4. Remove car");
             System.out.println("5. Update car");
             System.out.println("\nEnter Quit to end program...");

             System.out.print("Enter your choice:");
             userInput = scanner.nextLine();

             switch (userInput){
                 case "quit":
                     System.out.println("Exiting application...");
                     break;
                 case "1":
                     addCar();
                     break;
                 case "2":
                     viewAllCars();
                     break;
                 case "3":
                     viewSingleCar();
                     break;
                 case "4":
                     deleteCar();
                     break;
                 case "5":
                     updateCar();
                     break;
                 default:
                     break;

             }

             System.out.println("\n Enter C to continue\n");
             scanner.nextLine();

         }while (!userInput.equalsIgnoreCase( "Quit"));

         return;
    }
    void addCar(){
        System.out.println("\n Add car");

        Car car = new Car();
        System.out.print("Enter Name");
        car.name = scanner.nextLine();

        System.out.print("Enter Manufacturer");
        car.manufacturer = scanner.nextLine();

        System.out.print("Enter type");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);
        System.out.println(message);

     }

    void viewAllCars(){
        ArrayList<Car> allCars = showRoom.getAllCars();

        System.out.println("\nAll available cars\n");
        System.out.println("Id\t Car Name\t Manufacturer\t car type\t");

        int counter = 0;

        for (Car car: allCars){
            System.out.println(counter + ". \t" + car.name + " \t" + car.manufacturer + " \t" + car.type);
            counter ++;
        }
    }

    void viewSingleCar(){
        System.out.println("View car\n");
        System.out.print("Enter car ID");

        int carId = scanner.nextInt();
        Car car = showRoom.getSingleCar(carId);

        System.out.println("Car Number: " + car.id);
        System.out.println("Car Name: " + car.name);
        System.out.println("Car Manufacturer: " + car.manufacturer);
        System.out.print("Car Type: " + car.type);

     }

     void deleteCar(){
         System.out.println("Delete Car\n");
         System.out.println("Enter Car ID");

         int carId = scanner.nextInt();
         String message = showRoom.removeCar(carId);

         System.out.print(message);
     }

     void updateCar(){
         Car car = new Car();
         this.viewAllCars();

         System.out.println("Update Car");

         System.out.println("Enter car id");
         int carId = Integer.parseInt(scanner.nextLine());

         System.out.println("Enter new name for car");
         car.name = scanner.nextLine();

         System.out.println("Enter car type");
         car.type = scanner.nextLine();

         System.out.println("Enter car manufacturer");
         car.manufacturer = scanner.nextLine();

         String response = showRoom.updateCar(carId, car);
         System.out.println(response);

     }

 }

