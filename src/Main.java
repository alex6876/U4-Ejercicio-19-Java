public class Main {

    public static void main(String[] args) {

        SistemaTarifario sistema = new SistemaTarifario();

        MetodoEnvio terrestre = new EnvioTerrestre(500);
        MetodoEnvio aereo = new EnvioAereo(1000);
        MetodoEnvio ecologico = new EnvioEcologico(200);

        double peso = 10;
        double distancia = 100;

        sistema.generarPresupuesto(terrestre, peso, distancia);

        sistema.generarPresupuesto(aereo, peso, distancia);

        sistema.generarPresupuesto(ecologico, peso, distancia);
    }
}