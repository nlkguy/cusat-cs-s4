import java.util.Scanner;
public class StringSort{

    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);
        String[] namesArr = new String[10];
        int size = namesArr.length;
        System.out.print("Enter names :");
        for(int i=0;i<10;i++){
            namesArr[i]= scan.nextLine();
        }
        System.out.print("\nun-Sorted :\n");
        for(int i=0;i<10;i++){
            System.out.print((i+1)+") "+namesArr[i]+",\n ");
        }
        int j;
        System.out.println("array length = "+namesArr.length);
        for(int i=0;i<size-1;i++){
            System.out.println("pass no (i) = "+i+", arr[i] = "+namesArr[i]);
            int minIndex = i;
            
            for(j=i+1;j<size;j++){
                System.out.println("(j) = "+j);
                if(namesArr[j].compareTo(namesArr[minIndex])<0){
                    minIndex =j;
                }
            }
            if(minIndex!=i){
                System.out.println("swapping");
                String temp = namesArr[i];
                namesArr[i]= namesArr[minIndex];
                namesArr[minIndex]=temp;
                
            }
        }

        System.out.print("\nSorted :\n");
        for(int i=0;i<10;i++){
            System.out.print((i+1)+") "+namesArr[i]+",\n ");
        }
        scan.close();
    }
}