package telem;

public class TarifaNormal implements ICalculadorPrecio {
    @Override
    public int calcularPrecio(int dias, int precioBaseDiario) {
        return dias * precioBaseDiario;
    }
}