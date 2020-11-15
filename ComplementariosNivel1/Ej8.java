import java.util.Scanner;

public class Ej8 {
    
    public static void main(String[] args) {

        String nombreCompleto, ciudad, direccion, edad;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Por favor, ingrese los siguientes datos... ");
        System.out.println("Nombre y apellido: ");
        nombreCompleto = scan.nextLine();
        System.out.println("Edad: ");
        edad = scan.nextLine();
        System.out.println("Dirección: ");
        direccion = scan.nextLine();
        System.out.println("Ciudad: ");
        ciudad = scan.nextLine();

        System.out.println("\n" + ciudad + " - " + direccion + " - " + edad + " - " + nombreCompleto);
        scan.close();
    }
}
