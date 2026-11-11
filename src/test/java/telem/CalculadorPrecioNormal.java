package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioNormal implements IcalculadorPrecio {
    public int calcularPrecioAlquiler(LocalDate inicio, LocalDate fin, Vehiculo vehiculo) {
        int precioBase = vehiculo.getPrecioBase();
        int dias = (int) ChronoUnit.DAYS.between(inicio, fin) + 1;
        return dias * precioBase;
    }
}