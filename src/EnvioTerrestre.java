public class EnvioTerrestre extends MetodoEnvio {

    public EnvioTerrestre(double tarifaBase) {
        super("Transporte terrestre", tarifaBase);
    }

    @Override
    public double calcularTarifa(double pesoKg, double distanciaKm) {

        return tarifaBase + (pesoKg * 100) + (distanciaKm * 5);
    }
}