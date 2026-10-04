import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class Main {
  static void playlist(){

    Scanner input = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

    List<String> playlist = new LinkedList<>();

    while (input.hasNextLine()){
        String line = input.nextLine();
        String [] split = line.split(" ",2);
        if(split[0].equals("ADD")){
            playlist.add(split[1]);
        }
        else if (split[0].equals("INSERT")){
            String [] splitInsert = split[1].split(" ",2);
            int index = Integer.parseInt(splitInsert[0]);
            playlist.add(index,splitInsert[1]);
        }
        else{
            for (String p : playlist){
                if(split[1].equals(p)){
                    playlist.remove(p);
                    break;
                }
            }
        }
    }

    System.out.println("===== Problem 1 =====");
    System.out.println("Total songs: " + playlist.size());
    for(int i=0 ; i<playlist.size() ; i++){
        System.out.println((i+1) + ": " + playlist.get(i));
    }

  }  

  static void workshop(){
    Scanner input = new Scanner(Main.class.getResourceAsStream("participants.txt"));
    Set <String> participants = new LinkedHashSet<>();
    int count = 0;
    while (input.hasNext()){
        String name = input.next();
        if(participants.contains(name)){
            count++;
        }
        participants.add(name);
    }
    System.out.println("===== Problem 2 =====");
    System.out.println("Unique participants: " + participants.size());
    int urutan = 1;
    for(String p : participants){
        System.out.println(urutan + ". " + p);
        urutan++;
    }
    System.out.println("Duplicate registrations: " + count);
    
    
  }

  static void inventory(){
    Scanner input = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
    Map<String, Integer> inventory = new LinkedHashMap<>();
    int failed = 0;
    while(input.hasNextLine()){
        String type = input.next();
        String product = input.next();
        int quantity = input.nextInt();
        
        if(type.equals("ADD")){
            if(inventory.containsKey(product)){
                int currentStock = inventory.get(product);
                inventory.put(product,currentStock + quantity);
            }
            else{
                inventory.put(product,quantity);
            }
            
        }
        
        else{
            if(inventory.containsKey(product) && quantity<=inventory.get(product)){
                int currentStock = inventory.get(product);
                inventory.put(product,currentStock - quantity);
            }
            else{
                failed++;
            }
        }
    }
    System.out.println("===== Problem 3 =====");
    for (String i : inventory.keySet()){
        System.out.println(i + ": " + inventory.get(i));
    }
    System.out.println("Failed sales: " + failed);
  }

  public static void main(String[] args){
    playlist();
    System.out.println();
    workshop();
    System.out.println();
    inventory();
  }
}
