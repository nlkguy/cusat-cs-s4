package basics;
import java.util.Scanner;

public class ArrayMisc{

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