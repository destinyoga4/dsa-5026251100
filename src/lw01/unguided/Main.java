import java.util.Scanner;

public class Main {
    public static void main( String[] args ){

        Scanner input = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int n = input.nextInt();
        Rental [] rentals = new Rental[n];
        int [] units = new int[n];

        for (int i=0 ; i < n ; i++){
            String type = input.next();
            String id = input.next();
            int days = input.nextInt();
            int unit = input.nextInt();

            units[i] = unit;

            if (type.equals("LAPTOP")){
                rentals[i] = new LaptopRental(id,days);
            }

            else {
                rentals[i] = new ProjectorRental(id,days);
            }
        }

        for (int i=0 ; i<n ; i++){
            System.out.println(rentals[i].summary(units[i]));
        }
    }
}
