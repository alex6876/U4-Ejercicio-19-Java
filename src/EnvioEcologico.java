public class EnvioEcologico extends MetodoEnvio {

    public EnvioEcologico(double tarifaBase) {
        super("Distribucion ecologica", tarifaBase);
    }

    @Override
    public double calcularTarifa(double pesoKg, double distanciaKm) {

        return tarifaBase + (pesoKg * 50) + (distanciaKm * 3);
    }
}