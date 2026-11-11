package telem;

public class TarifaClienteFrecuente implements ICalculadorPrecio {
    @Override
    public int calcularPrecio(int dias, int precioBaseDiario) {
        int diasConDescuentoInicial = Math.min(dias, 3);
        int diasConDescuentoAdicional = Math.max(dias - 3, 0);
        double total = diasConDescuentoInicial * precioBaseDiario * 0.80
                + diasConDescuentoAdicional * precioBaseDiario * 0.60;
        return (int) total;
    }
}