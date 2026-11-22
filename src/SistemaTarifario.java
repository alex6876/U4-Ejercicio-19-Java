public class SistemaTarifario {

    public void generarPresupuesto(MetodoEnvio metodo, double pesoKg, double distanciaKm) {

        double costo = metodo.calcularTarifa(pesoKg, distanciaKm);

        System.out.println("=== PRESUPUESTO DE ENVIO ===");
        System.out.println("Metodo: " + metodo.getNombre());
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Costo total: $" + costo);
        System.out.println("-------------------------");
    }
}