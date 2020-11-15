import java.util.Scanner;

public class Ej6 {
    //Calculo de potencia
    public static void main(String[] args) {
        
        Scanner scan  = new Scanner(System.in);
        int num1, num2, potencia=1;

        System.out.println("Ingrese el número: ");
        num1 = scan.nextInt();
        System.out.println("Indique la potencia: ");
        num2 = scan.nextInt();

        for (int i = 0; i < num2; i++) {
            potencia = potencia * num1;
        }
        System.out.println(num1 + " elevado a " + num2 + " = " + potencia);
        scan.close();
    }
}
