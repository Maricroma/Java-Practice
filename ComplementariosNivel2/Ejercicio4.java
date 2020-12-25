import java.util.ArrayList;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        
        ArrayList<String> estudiantes = new ArrayList<>();
        estudiantes.add("Laura");
        estudiantes.add("Carla");
        estudiantes.add("Romina");
        estudiantes.add("Matias");
        estudiantes.add("Nahir");
        estudiantes.add("Elías");
        estudiantes.add("Marina");
        estudiantes.add("Damián");
        estudiantes.add("Jorge");
        estudiantes.add("Jeremías");
        estudiantes.add("Nahuel");
        estudiantes.add("Soledad");

        ArrayList<String> curso1 = new ArrayList<String>(estudiantes.subList(0, 4));
        ArrayList<String> curso2 = new ArrayList<String>(estudiantes.subList(4, 8));
        ArrayList<String> curso3 = new ArrayList<String>(estudiantes.subList(8, estudiantes.size()));

        System.out.println("Alumnos del Curso 1: " + curso1);
        System.out.println("Alumnos del Curso 2: " + curso2);
        System.out.println("Alumnos del Curso 3: " + curso3);
    }
}
