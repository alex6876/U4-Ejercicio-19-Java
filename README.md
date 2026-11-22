# Simulación de Sistema Tarifario y Métodos de Envío (Clases Abstractas, Herencia y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de cálculo de tarifas y presupuestos logísticos, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos métodos de envío (terrestre, aéreo nacional y distribución ecológica) con fórmulas diferenciadas según el peso del paquete, la distancia recorrida y la tarifa base. Pone en práctica conceptos fundamentales de la Programación Orientada a Objetos (POO) como la generalización de atributos protegidos (`protected`), el uso de constructores mediante `super` con denominaciones fijas por modalidad, la definición de métodos abstractos (`abstract`), la sobrescritura polimórfica de comportamiento (`@Override`), el encapsulamiento mediante métodos de consulta y el procesamiento desacoplado en memoria sin persistencia en base de datos.

---

## Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas por modalidad de envío, un componente generador de presupuestos y un punto de ejecución:

* **`MetodoEnvio` (Clase Abstracta)**: Centraliza los atributos y el contrato común para cualquier modalidad de envío dentro del sistema tarifario.
* **Atributos protegidos (`protected`)**: `nombre` y `tarifaBase`, accesibles directamente por las subclases para calcular el costo final de cada envío.
* **Constructor**: Inicializa `nombre` y `tarifaBase`.
* **Métodos operativos**:
* `abstract double calcularTarifa(double pesoKg, double distanciaKm)`: Método abstracto que obliga a cada método de envío a definir su propia fórmula de cálculo a partir del peso en kilogramos y la distancia en kilómetros.
* `getNombre()`: Getter público para consultar de forma encapsulada la denominación del método de envío.




* **`EnvioTerrestre`**: Extiende de `MetodoEnvio` para modelar el transporte por carretera con una tarifa base configurable y un nombre fijo `"Transporte terrestre"`.
* **Constructor**: Recibe `tarifaBase` e invoca a `super("Transporte terrestre", tarifaBase)`.
* **Sobrescritura (`@Override`)**:
* `calcularTarifa(double pesoKg, double distanciaKm)`: Calcula `tarifaBase + (pesoKg * 100) + (distanciaKm * 5)`.




* **`EnvioAereo`**: Extiende de `MetodoEnvio` para modelar el traslado aéreo de carga con denominación fija `"Envio aereo nacional"` y recargos más altos por peso y distancia.
* **Constructor**: Recibe `tarifaBase` e invoca a `super("Envio aereo nacional", tarifaBase)`.
* **Sobrescritura (`@Override`)**:
* `calcularTarifa(double pesoKg, double distanciaKm)`: Calcula `tarifaBase + (pesoKg * 250) + (distanciaKm * 12)`.




* **`EnvioEcologico`**: Extiende de `MetodoEnvio` para modelar entregas de bajo impacto ambiental bajo el nombre `"Distribucion ecologica"` y costos reducidos por unidad de peso y distancia.
* **Constructor**: Recibe `tarifaBase` e invoca a `super("Distribucion ecologica", tarifaBase)`.
* **Sobrescritura (`@Override`)**:
* `calcularTarifa(double pesoKg, double distanciaKm)`: Calcula `tarifaBase + (pesoKg * 50) + (distanciaKm * 3)`.




* **`SistemaTarifario`**: Componente controlador encargado de generar y mostrar por consola el presupuesto de un envío.
* **Método operativo**: `generarPresupuesto(MetodoEnvio metodo, double pesoKg, double distanciaKm)`: Recibe polimórficamente cualquier instancia de `MetodoEnvio`, invoca `calcularTarifa(pesoKg, distanciaKm)` e imprime el nombre del método, el peso, la distancia y el costo total.


* **`Main`**: Punto de entrada del programa. Instancia `SistemaTarifario`, crea objetos `EnvioTerrestre` (`500`), `EnvioAereo` (`1000`) y `EnvioEcologico` (`200`), define un `peso` de `10` kg y una `distancia` de `100` km, y ejecuta `generarPresupuesto(...)` para cada modalidad.

---

## Reglas de Negocio y Control de Validación

* **Contrato Estricto de Tarificación:** Mediante `MetodoEnvio`, cualquier nueva modalidad de envío que se agregue al sistema debe implementar obligatoriamente `calcularTarifa(double pesoKg, double distanciaKm)`.
* **Fórmulas Especializadas por Modalidad:** Cada subclase encapsula su propia ecuación de costos (`$100/kg` y `$5/km` en terrestre; `$250/kg` y `$12/km` en aéreo; `$50/kg` y `$3/km` en ecológico) sumada a su `tarifaBase`, evitando condicionales centralizados en el sistema tarifario.
* **Desacoplamiento mediante Polimorfismo:** `SistemaTarifario` opera exclusivamente contra la abstracción `MetodoEnvio`, resolviendo en tiempo de ejecución el cálculo de cada método sin acoplarse a sus clases concretas.

---

## Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
=== PRESUPUESTO DE ENVIO ===
Metodo: Transporte terrestre
Peso: 10.0 kg
Distancia: 100.0 km
Costo total: $2000.0
-------------------------
=== PRESUPUESTO DE ENVIO ===
Metodo: Envio aereo nacional
Peso: 10.0 kg
Distancia: 100.0 km
Costo total: $4700.0
-------------------------
=== PRESUPUESTO DE ENVIO ===
Metodo: Distribucion ecologica
Peso: 10.0 kg
Distancia: 100.0 km
Costo total: $1000.0
-------------------------

```

---

## Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo:** Uso de una clase abstracta y sobrescritura de métodos (`@Override`) para calcular tarifas distintas bajo una misma referencia.
* **Herencia y Encapsulamiento:** Reutilización de atributos protegidos y constructores con `super`, exponiendo el nombre mediante `getNombre()`.
* **Separación de Responsabilidades:** División clara entre las reglas tarifarias de cada método de envío, la emisión de presupuestos en `SistemaTarifario` y la ejecución de pruebas en `Main`.
