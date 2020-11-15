import java.util.Scanner;

public class Ej9 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String texto;
        Character buscarLetra;
        int cont=0;

        System.out.println("Ingrese texto: ");
        texto = scan.nextLine();
        System.out.println("Ingrese letra a contar: ");
        buscarLetra = scan.nextLine().charAt(0);

        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == buscarLetra){
                cont++;
            }
        }
        
        if (cont != 0){
            System.out.println(cont);
        }
        else {
            System.out.println("La letra ingresada no se encuentra en el texto.");
        }
        scan.close();

    }
}
