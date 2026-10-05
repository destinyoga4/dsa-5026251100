import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> course = new LinkedHashMap<>();

        int failed = 0;

        System.out.println("===== Enrollment Checks =====");

        while(input.hasNext()){
            String line = input.nextLine();
            String [] data = line.split(" ",2);

            if(data[0].equals("REGISTER")){
                String [] dataRegister = data[1].split(" ");
                int value = Integer.parseInt(dataRegister[1]);
                if(!course.containsKey(dataRegister[0])){
                    if(value == 0){
                        failed++;
                    }
                    else{
                    course.put(dataRegister[0],value);
                    }
                }

                else{
                    if(value == 0){
                        failed++;
                    }
                    else{
                    course.put(dataRegister[0],course.get(dataRegister[0]) + value);
                    }
                }
            }

            else if(data[0].equals("WITHDRAW")){
                String [] dataWithdraw = data[1].split(" ");
                int value = Integer.parseInt(dataWithdraw[1]);

                if(course.containsKey(dataWithdraw[0]) && course.get(dataWithdraw[0])>=value){
                    course.put(dataWithdraw[0],course.get(dataWithdraw[0]) - value);
                }

                else{
                    failed++;
                }
            }

            else{
                if(course.containsKey(data[1])){
                    System.out.println(data[1] + ": " + course.get(data[1]) + " students");
                }

                else{
                    System.out.println(data[1] + ": Not found" );
                }
            }

        }

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for(String c : course.keySet()){
            System.out.println(c + ": " + course.get(c) + " students");
        }

        System.out.println();
        System.out.println("Rejected operations: " + failed);
    }
}