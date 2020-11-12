import java.util.Scanner;

public class Ejercicio4 {

    private static String bienvenida = "\n****************Bienvenido*****************";

    public static void main(String[] args) {
        System.out.println(bienvenida);
        
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar == true) {
            
            System.out.println("\nIngrese número: ");
            int num = scan.nextInt();
            mostrarDia(num);
            
            System.out.println("Desea ingresar otro número? s/n ");
            String resp = scan.next();
            continuar = (resp.equals("n") || resp.equals("N"))?false:true;
        }
        scan.close();


    }

    public static void mostrarDia(int num) {

        switch(num) {
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Martes");
                break;
            case 4:
                System.out.println("Miércoles");
                break;
            case 5:
                System.out.println("Jueves");
                break;
            case 6:
                System.out.println("Viernes");
                break;
            case 7:
                System.out.println("Sábado");
                break;

        }
    }
    
}
