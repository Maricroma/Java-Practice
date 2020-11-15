import java.util.Scanner;

public class Ej1 {
    
    public static void main(String[] args) {
        String usuario;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese su nombre a continuación: ");
        usuario = scan.next();

        System.out.println("HOLA " + usuario.toUpperCase() + "!!!" );
        scan.close();

    }
}