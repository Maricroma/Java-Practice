import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        ArrayList<Integer> baraja = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8,9,10));

        System.out.println("Elementos de la baraja: ");
        /*for (Integer carta : baraja) {
            System.out.println(carta);
        }*/
        baraja.stream().forEach(e -> System.out.print("\t" + e));

        System.out.println("\n\nElementos de la baraja en orden inverso: ");
        /*for (int i = baraja.size() - 1; i >= 0; i--) {
            System.out.println(baraja.get(i));
        }*/
        Collections.reverse(baraja);
        System.out.println(baraja);

        System.out.println("Elementos de la baraja mezclados: ");
        Collections.shuffle(baraja);
        System.out.println(baraja);
    }
}
