package searching;
import java.util.Scanner;
// linear search aka sequemtial search
// if present - return location index 
// not present - return '-1'
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

    int loc = binarySearch(searchfor,userArr);
    //int loc = linearSearch(searchfor,userArr);
    if(loc==-1){
      System.out.println("Not Found");
    }else{
      System.out.println("Found @ "+loc);
    }

  }


  public static int binarySearch(int num,int[] arr){
    System.out.println("Binary Search Function");
    System.out.println("Searching for "+num);

    int low = 0;
    int high = arr.length-1;
    
    while(low<=high){
      int mid = (low+high)/2;
      System.out.println("low = "+low+" high = "+high+" mid = "+mid);

      if(num == arr[mid]){
        return mid;
      }
      if(num<arr[mid]){
        high = mid-1;
      }
      if(num>arr[mid]){
        low = mid+1;
      }
    }
    return -1;
  }

  public static int linearSearch(int num, int[] arr){
    System.out.println("Linear Search Function");
    System.out.println("Searching for "+num);
    for(int i=0;i<arr.length;i++){
      if(arr[i]==num){
        return i;
      }
    }
    return -1;
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
  