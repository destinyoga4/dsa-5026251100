import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.sound.sampled.Line;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList <String[]> request = new LinkedList<>(); 
        LinkedList <String[]> book = new LinkedList<>(); 
        LinkedList <String[]> member = new LinkedList<>();  
        Stack<String[]> failed = new Stack<>();
        LinkedList<String[]> success = new LinkedList<>();

        while (input.hasNextLine()){
            String [] data = {input.next(), input.next()};
            request.add(data);
        }

        String [] kalkulus = {"Kalkulus", "2"};
        String [] fisika = {"Fisika", "1"};
        String [] statistika = {"Statistika", "2"};

        book.add(kalkulus);
        book.add(fisika);
        book.add(statistika);

        for ( String [] data : request){
            String name = data[0];
            String title = data[0];

            for (String [] m : member){
                boolean status = false;

                if (name.equals(m[0])){
                    status = true;
                }

                if (!status){
                    m[0] = name;
                    m[1] = "0";
                }
            }
        }
  
        for(String [] data : request){
            String name = data[0];
            String title = data[1];
            boolean status = false;

            for (String[] m : member){
                String n = m[0];
                if(n.equals(name)){
                    status = true;
                    
                }
            }

            if(!status) {
                    String[] j = {name,"0"};
                    member.add(j);
                }

        }

        Queue <String[]> process = new LinkedList<>(request);

        while(!process.isEmpty()){
            String [] d = process.poll();
            String name = d[0];
            String title = d[1];
            for (String[] m : member){
                String n = m[0];
                if(n.equals(name)){
                    for(String[] t : book){
                        String tbook = t[0];
                        if(tbook.equals(title)){
                            int stock = Integer.parseInt(t[1]);
                            int limit = Integer.parseInt(m[1]);
                            if(stock >0 && limit < 2){
                                stock -= 1;
                                limit += 1;                             
                                m[1] = Integer.toString(limit);
                                t[1] = Integer.toString(stock);
                                success.add(d);
                            }

                            else {
                                failed.push(d);
                            }
                        }
                    }
                }
            } 
        }
        System.out.println("===Successfully Processed Requests===");
        for (String [] s : success){
            System.out.println(s[0] + " " + s[1]);
        }
        System.out.println();

        System.out.println("===Remaining Book Stock===");
        for (String [] b : book){
            System.out.println(b[0] + " : " + b[1]);
        }

        System.out.println();
        System.out.println("=== Failed Requests ===");
        while (!failed.isEmpty()){
            String [] f = failed.pop();
            System.out.println(f[0] + " " + f[1]);
        }





    }
}
