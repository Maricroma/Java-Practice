import java.util.Scanner;

public class Ejercicio2 {

    private static String bienvenida = "\n****************Bienvenido*****************";

    public static void main(String[] args) {

        System.out.println(bienvenida);

        boolean continuar = true;
        Scanner scan = new Scanner(System.in);
        
        while (continuar == true) {
            
            System.out.println("\nPor favor, ingrese los números a continuación: ");
            int a = scan.nextInt(); 
            int b = scan.nextInt();
            int c = scan.nextInt();
            mostrarNum(a, b, c);

            System.out.println("Desea continuar? s/n ");
            String resp = scan.next();
            continuar = (resp.equals("n") || resp.equals("N"))?false:true;
        }
        scan.close();

    }

    public static void mostrarNum(int a, int b, int c) {
        System.out.println("El primer número ingresado es: " + a);
        System.out.println("El segundo número ingresado es: " + b);
        System.out.println("El tercer número ingresado es: " + c);

    }
    
}
