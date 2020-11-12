import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        
        System.out.println("************Bienvenido************");
        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Ingrese un número: ");
            int num = scan.nextInt();
            System.out.println("El número ingresado es: " + num + "\n");
            System.out.println("Elija una opción: \n1) Volver a ejecutar\n2) Salir");
            opcion = scan.nextInt();
        } while (opcion == 1);

        scan.close();
        System.out.println("******Hasta luego********");

    }
    
}
