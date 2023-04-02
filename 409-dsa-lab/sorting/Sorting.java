package sorting;
import java.util.Scanner;

public class Sorting{
    public static void main(String[] args){
        System.out.println("Sorting Main Function");
        System.out.println("Main Function");
        Scanner scan = new Scanner(System.in);
    
        System.out.print("Enter size of Array :");
        int arrSize = scan.nextInt();

        int[] userArr = getArrayFromUser(arrSize);
        System.out.print("Unsorted Array :");
        printArray(userArr);
        System.out.print("\nSorted Array :");
        printArray(selectionSort(userArr));

    }
    public static int[] selectionSort(int[] arr){
        int j;
        System.out.println("array length = "+arr.length);
        for(int i=0;i<arr.length-1;i++){
            System.out.println("pass no (i) = "+i+", arr[i] = "+arr[i]);
            int minIndex = i;
            
            for(j=i+1;j<arr.length;j++){
                System.out.println("(j) = "+j);
                if(arr[j]<arr[minIndex]){
                    minIndex =j;
                }
            }
            if(minIndex!=i){
                System.out.println("swapping");
                int temp = arr[i];
                arr[i]= arr[minIndex];
                arr[minIndex]=temp;
                
            }
        }
        //printArray(arr);
        return arr;
    }
    public static int[] getArrayFromUser(int inputSize){
        System.out.print("Get Array User Input :");
        int[] userArray = new int[inputSize];
        Scanner scanObj = new Scanner(System.in);
        for(int i=0;i<inputSize;i++){
          userArray[i] = scanObj.nextInt();
        }
        return userArray;
      }
      public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+", ");
        }
      }
}