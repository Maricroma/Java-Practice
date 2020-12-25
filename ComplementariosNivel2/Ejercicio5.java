import java.util.ArrayList;
import java.util.Arrays;

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> horasTrabajadas = new ArrayList<>(Arrays.asList(6,7,8,4,5));
        ArrayList<Integer> valorPorHora = new ArrayList<>(Arrays.asList(350,345,550,600,320));
        ArrayList<Integer> totalACobrar = new ArrayList<>();
        int pos = 0;
        int total = 0;

        for (int i = 0; i < horasTrabajadas.size(); i++) {
            totalACobrar.add(horasTrabajadas.get(i) * valorPorHora.get(pos));
            pos ++;
        }

        System.out.println("Total a cobrar: " + totalACobrar);

        for (int i = 0; i < totalACobrar.size(); i++) {
            total += totalACobrar.get(i);
        }

        System.out.println("Total final: $" + total);
    }
}
