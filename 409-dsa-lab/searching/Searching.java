package searching;
import java.util.Scanner;
public class Searching{

    public static void main(String[] args){
        System.out.println("Searching Main Function");

    }
    public static int linearSearch(int[] arr, int toFind){
        System.out.println("Linear Search Fuction");
        System.out.println("Searching for "+toFind);
        // if found , return index
        // not found , return '-1'
        for(int i=0;i<arr.length;i++){
            if(arr[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int toFind){
        System.out.println("Binary Search Fuction");
        System.out.println("Searching for "+toFind);
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==toFind){
                return mid;
            }else if(arr[mid]<toFind){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static int[] getArrayFromUser(int inputSize){
        System.out.println("Get Array User Input");
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