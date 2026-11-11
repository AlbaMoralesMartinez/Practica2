package telem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculadorPrecioClienteFrecuente implements IcalculadorPrecio {
    public int calcularPrecioAlquiler(LocalDate inicio, LocalDate fin, Vehiculo vehiculo) {
        int dias = (int) ChronoUnit.DAYS.between(inicio, fin) + 1;
        double precioBase = vehiculo.getPrecioBase();
        double total = 0;
        if (dias <= 3) {
            total = dias * (precioBase * 0.80); // 20% de descuento los primeros 3 días
        } else {
            total = 3 * (precioBase * 0.80);
            int diasRestantes = dias - 3;
            total += diasRestantes * (precioBase * 0.60); // 40% de descuento a partir del cuarto día
        }
        
        return (int) total;
    }
}

