import java.util.ArrayList;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(5);
        numeros.add(6);
        numeros.add(77);
        numeros.add(43);
        numeros.add(10);


        //Iterar para mostrar elementos y tamaño de la lista
        System.out.println("Cantidad de números en la lista: " + numeros.size());
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        numeros.add(0,92); //agregar numero entero al principio de la lista
        numeros.add(93);   //agregar numero entero al final de la lista

        System.out.println("Cantidad de números en la lista: " + numeros.size());
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
    }
}
