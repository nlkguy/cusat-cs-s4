package searching;
import java.util.Scanner;

public class LinearSearch{
    
  public static void main(String[] args){
    System.out.println("Main Function");
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter size of Array :");
    int arrSize = scan.nextInt();

    int[] userArr = getArrayFromUser(arrSize);
    printArray(userArr);

    System.out.print("\nEnter number to Search :");
    int searchfor = scan.nextInt();

    linearSearch(searchfor,userArr);
  }
  public static void linearSearch(int num, int[] arr){
    System.out.println("Linear Search Function");
    System.out.println("Searching for "+num);
    for(int i=0;i<arr.length;i++){
      if(arr[i]==num){
        System.out.println("Found");
      }
    }
    System.out.println("Not Found");
  }
  // get Array as user input , 
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
  