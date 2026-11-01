import java.util.Scanner;

public class Main {

    // Algoritma yang cocok dengan note yang diberikan adalah algoritma insertion sort secara descending

    public static void insertionSort(int [] arr, int passes){
        for (int i=1; i<=passes && i<arr.length ; i++){
            int key = arr[i];
            int j = i - 1;
            while (j>= 0 && arr[j] < key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = input.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = input.nextInt();
        }
        input.close();

        insertionSort(branches, 3);

        for (int i = 0; i < n; i++) {
            System.out.print(branches[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = linearSearch(branches, targets[i]);
            if (idx != -1) {
                System.out.println(targets[i] + ": FOUND at index " + idx);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
