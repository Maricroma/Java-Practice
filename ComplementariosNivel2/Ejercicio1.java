import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        ArrayList<String> ciudadesFav = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Boolean continuar = true;
        int opcion = 0;

        while(continuar) {
            try {
                System.out.println("\nElija una opción a continuación: ");
                System.out.println("1)Ingresar nueva ciudad \n2)Mostrar ranking \n3)Salir");
                opcion = scan.nextInt();
                opcion = menu(ciudadesFav, opcion);
                if (opcion == 3 ) {
                    continuar = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError> La opción ingresada no es válida.");
                continuar = false;
            }
        }
        scan.close();
    }

    public static Integer menu(ArrayList<String> ciudadesFav, int opcion){
        if(opcion == 1) {
            String nuevaCiudad = pedirCiudad();
            ingresarCiudad(ciudadesFav, nuevaCiudad);
            mensajeOk();
        }else if(opcion == 2){
            listarCiudades(ciudadesFav);
            mensajeOk();
        }else if(opcion == 3){
            mensajeSalir();
        }else {
            System.out.println("La opción ingresada no es correcta. Por favor inténtelo otra vez.");
        }
        return opcion;

    }

    public static ArrayList<String> ingresarCiudad(ArrayList<String> ciudades, String nuevaCiudad){
        ciudades.add(nuevaCiudad);
        return ciudades;
    }

    public static String pedirCiudad(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Indique nombre de la ciudad: ");
        return (scan.nextLine());
    }

    public static void listarCiudades(ArrayList<String> ciudades){
        int pos = 1;
        for (String ciudad : ciudades) {
            System.out.println("#" + pos + " - " + ciudad);
            pos ++;
        }
    }

    public static void mensajeOk(){
        System.out.println("Operación realizada exitosamente.");
    }

    public static void mensajeSalir() {
        System.out.println("Hasta luego.");
    }
}