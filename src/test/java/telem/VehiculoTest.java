package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VehiculoTest {
    @Test
    void constructorInicializaAtributosComunesYDisponibilidad() {
        Vehiculo vehiculo = new Turismo("1234ABC", Categoria.NORMAL, 2022, 5, 450.0);

        assertEquals("1234ABC", vehiculo.getMatricula());
        assertEquals(Categoria.NORMAL, vehiculo.getCategoria());
        assertEquals(2022, vehiculo.getAnnio());
        assertFalse(vehiculo.isDisponible());

        vehiculo.setDisponible(true);
        assertTrue(vehiculo.isDisponible());
    }
}