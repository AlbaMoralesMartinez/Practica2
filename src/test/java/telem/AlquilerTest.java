package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AlquilerTest {
    @Test
    void constructorInicializaVehiculoClienteYFechas() {
        Vehiculo vehiculo = new Turismo("7777GGG", Categoria.NORMAL, 2021, 5, 400);
        Cliente cliente = new Cliente("Luis García", "87654321X");
        LocalDate inicio = LocalDate.of(2025, 3, 10);
        LocalDate fin = LocalDate.of(2025, 3, 12);

        Alquiler alquiler = new Alquiler(vehiculo, cliente, inicio, fin);

        assertSame(vehiculo, alquiler.getVehiculo());
        assertSame(cliente, alquiler.getCliente());
        assertEquals(inicio, alquiler.getFechaInicio());
        assertEquals(fin, alquiler.getFechaFin());
    }

    @Test
    void calculaPrecioIncluyendoAmbosDias() {
        Alquiler alquiler = new Alquiler(
                new Motocicleta("8888HHH", Categoria.NORMAL, 2020, 125),
                new Cliente("Luis García", "87654321X"),
                LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 12));

        assertEquals(Alquiler.PRECIO_BASE, alquiler.calcularPrecioAlquiler(
                LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 10)));
        assertEquals(3 * Alquiler.PRECIO_BASE, alquiler.calcularPrecioAlquiler(
                LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 12)));
    }

    @Test
    void calculaPrecioSegunLaEstrategiaAplicada() {
        LocalDate inicio = LocalDate.of(2025, 7, 1);
        LocalDate fin = LocalDate.of(2025, 7, 3);
        Vehiculo vehiculo = new Motocicleta("9999III", Categoria.NORMAL, 2020, 125);
        Cliente cliente = new Cliente("Eva López", "12345678A");

        Alquiler tarifaNormal = new Alquiler(vehiculo, cliente, inicio, fin, new TarifaNormal());
        Alquiler temporadaAlta = new Alquiler(vehiculo, cliente, inicio, fin, new TarifaTemporadaAlta());

        assertEquals(150, tarifaNormal.calcularPrecioAlquiler(inicio, fin));
        assertEquals(225, temporadaAlta.calcularPrecioAlquiler(inicio, fin));
    }
}