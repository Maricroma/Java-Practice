import java.util.Scanner;

public class Ej3 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int num;

        System.out.println("Ingrese el número: ");
        num = scan.nextInt();

        for (int i = 1; i < (num+1); i++) {
            for (int j = 1; j < (i+1); j++) {  
                System.out.print(j); 
            }
            System.out.println(""); 
            
        }
        scan.close();
    }
}
