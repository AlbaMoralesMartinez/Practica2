package telem;

import java.time.LocalDate;

public interface IcalculadorPrecio {
    int calcularPrecioAlquiler(LocalDate inicio, LocalDate fin, Vehiculo vehiculo);
}

