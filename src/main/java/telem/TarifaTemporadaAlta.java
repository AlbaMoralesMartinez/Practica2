package telem;

public class TarifaTemporadaAlta implements ICalculadorPrecio {
    @Override
    public int calcularPrecio(int dias, int precioBaseDiario) {
        return dias * precioBaseDiario * 2;
    }
}