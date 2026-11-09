import java.util.Scanner;

public class Main {

    public static void selectionSort(int[] arr, int passes){
        for (int i=0 ; i < passes; i++){
            int smallest = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j] < arr[smallest] ){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    public static int linearSearch(int[] arr, int target){
        for (int i=0; i<arr.length ; i++){
            if(arr[i]==target){
                return i; 
            }
        }
        return -1;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(Main.class.getResourceAsStream("card2.txt"));

        int n = input.nextInt();
        int [] card = new int[n];

        for (int i=0; i<n; i++){
            card[i] = input.nextInt();
        }

        selectionSort(card,2);
        for(int c : card){
            System.out.print(c + " ");
        }
        System.out.println();

        int m = input.nextInt();
        int[] request = new int[m];

        for(int i=0; i<m ; i++){
            request[i] = input.nextInt();
        }

        for(int r : request){
            int index = linearSearch(card,r);
            if(index!=-1){
                System.out.println(r + ": FOUND at index " + index );
            }
            else{
                System.out.println(r + ": NOT FOUND");
            }
        }
    }
}
