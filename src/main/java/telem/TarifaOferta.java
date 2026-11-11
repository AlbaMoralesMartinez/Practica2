package telem;

public class TarifaOferta implements ICalculadorPrecio {
    @Override
    public int calcularPrecio(int dias, int precioBaseDiario) {
        double total = dias * precioBaseDiario * 0.70;
        if (dias > 7) {
            total *= 0.90;
        }
        return (int) total;
    }
}