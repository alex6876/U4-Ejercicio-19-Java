public class EnvioAereo extends MetodoEnvio {

    public EnvioAereo(double tarifaBase) {
        super("Envio aereo nacional", tarifaBase);
    }

    @Override
    public double calcularTarifa(double pesoKg, double distanciaKm) {

        return tarifaBase + (pesoKg * 250) + (distanciaKm * 12);
    }
}