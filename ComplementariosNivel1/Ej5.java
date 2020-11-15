import java.util.Scanner;

//Multiplicación por sumas sucesivas

public class Ej5 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int num1,num2, result=0;

        System.out.println("Ingrese número a multiplicar: ");
        num1 = scan.nextInt();
        System.out.println("Indique por cuánto lo quiere multiplicar: ");
        num2 = scan. nextInt();

        for (int i = 0; i < num2; i++) {
            result = result + num1;
        }
        System.out.println(num1 + " x " + num2 + " = " + result);
        scan.close();
    }
}
