import java.util.Scanner;

public class Ejercicio3 {

    private static String bienvenida = "\n****************Bienvenido*****************";

    public static void main(String[] args) {

        System.out.println(bienvenida);
        
        Scanner scan = new Scanner(System.in);
        boolean continuar = true;

        while (continuar == true) {
            System.out.println("\nIngrese nota del alumno: ");
            int nota = scan.nextInt();
            System.out.println(clasifNota(nota));


            System.out.println("Desea ingresar otra nota? s/n ");
            String resp = scan.next();
            continuar = (resp.equals("n") || resp.equals("N"))?false:true;
        }
        scan.close();
    }
    
    public static String clasifNota(int nota) {
        if (nota > 92){
            return "Excelente";
        }else if (nota > 84){
            return "Sobresaliente";
        }else if(nota > 74){
            return "Distinguido";
        }else if(nota > 59){
            return "Bueno";
        }else{
            return "Desaprobado";
        }
    }
    
}
