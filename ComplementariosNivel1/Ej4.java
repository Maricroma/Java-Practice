import java.util.Scanner;

//Factorial de un número

public class Ej4 {
    
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         int num, factorial = 1;

         System.out.println("Ingrese número: ");
         num = scan.nextInt();

        for (int i = 1; i < (num+1); i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial de " + num + " es: " + factorial);
        scan.close();


    }
}
