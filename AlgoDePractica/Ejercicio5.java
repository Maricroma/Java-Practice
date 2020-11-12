import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
     
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar == true) {
            
            System.out.println("\nIngrese número: ");
            int num = scan.nextInt();
            for (int i=1; i<=10; i++){
                System.out.println(num + " * " + i + " = " + num*i);
            }
            System.out.println("Desea ingresar otro número? s/n ");
            String resp = scan.next();
            continuar = (resp.equals("n") || resp.equals("N"))?false:true;
        }
        scan.close();

    }
    
}
