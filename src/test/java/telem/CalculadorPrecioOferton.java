package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioOferton {
    public int calcularPrecioAlquiler(LocalDate inicio, LocalDate fin, Vehiculo vehiculo) {
        int dias = (int) ChronoUnit.DAYS.between(inicio, fin) + 1;
        double precioDiario = vehiculo.getPrecioBase() * 0.70;
        double total = precioDiario * dias;
        if (dias > 7) {
            total = total * 0.90;
        }
        return (int) total;
    }
}


