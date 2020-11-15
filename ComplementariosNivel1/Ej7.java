import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ej7 {
    //Convertir minúsculas a mayúsculas
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Map <Character, Character> letra = new HashMap();
        letra.put('a', 'A');
        letra.put('b', 'B');
        letra.put('c', 'C');
        letra.put('d', 'D');
        letra.put('e', 'E');
        letra.put('f', 'F');
        letra.put('g', 'G');
        letra.put('h', 'H');
        letra.put('i', 'I');
        letra.put('j', 'J');
        letra.put('k', 'K');
        letra.put('l', 'L');
        letra.put('m', 'M');
        letra.put('n', 'N');
        letra.put('ñ', 'Ñ');
        letra.put('o', 'O');
        letra.put('p', 'P');
        letra.put('q', 'Q');
        letra.put('r', 'R');
        letra.put('s', 'S');
        letra.put('t', 'T');
        letra.put('u', 'U');
        letra.put('v', 'V');
        letra.put('w', 'W');
        letra.put('x', 'X');
        letra.put('y', 'Y');
        letra.put('z', 'Z');

        System.out.println("Ingrese su texto: ");
        String text = scan.nextLine();

        for (int i = 0; i < text.length(); i++) {
            if (letra.containsKey(text.charAt(i))){
                System.out.print(letra.get(text.charAt(i)));
            }
            else{
                System.out.print(" ");
            }
        }
        scan.close();   
    }
}
