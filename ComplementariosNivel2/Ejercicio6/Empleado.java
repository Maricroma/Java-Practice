package Ejercicio6;

public abstract class Empleado {
    private String nombreCompleto;
    private int dni;
    private int hsTrabajadas;
    private int valorPorHora;

    public Empleado(String nombreCompleto, int dni, int hsTrabajadas, int valorPorHora) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.hsTrabajadas = hsTrabajadas;
        this.valorPorHora = valorPorHora;
    }

    public int calcularSueldo(){
        return 0;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getHsTrabajadas() {
        return hsTrabajadas;
    }

    public void setHsTrabajadas(int hsTrabajadas) {
        this.hsTrabajadas = hsTrabajadas;
    }

    public int getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(int valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

}
