public abstract class MetodoEnvio {

    protected String nombre;
    protected double tarifaBase;

    public MetodoEnvio(String nombre, double tarifaBase) {
        this.nombre = nombre;
        this.tarifaBase = tarifaBase;
    }

    public abstract double calcularTarifa(double pesoKg, double distanciaKm);

    public String getNombre() {
        return nombre;
    }
}