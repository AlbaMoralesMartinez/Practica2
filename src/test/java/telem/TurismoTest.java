package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TurismoTest {
    @Test
    void constructorInicializaAtributos() {
        Turismo turismo = new Turismo("1111AAA", Categoria.ESPECIAL, 2021, 5, 420.5);

        assertEquals("1111AAA", turismo.getMatricula());
        assertEquals(Categoria.ESPECIAL, turismo.getCategoria());
        assertEquals(2021, turismo.getAnnio());
        assertEquals(5, turismo.getPlazas());
        assertEquals(420.5, turismo.getCapacidadMaletero(), 0.001);
        assertEquals("Turismo", turismo.getTipo());
    }

    @Test
    void constructorJsonDeserializaAtributos() {
        String json = "{\"matricula\":\"2222BBB\",\"categoria\":\"SUPERIOR\","
                + "\"annio\":2023,\"disponible\":true,\"plazas\":7,\"capacidadMaletero\":510.5}";

        Turismo turismo = new Turismo(json);

        assertEquals("2222BBB", turismo.getMatricula());
        assertEquals(Categoria.SUPERIOR, turismo.getCategoria());
        assertEquals(2023, turismo.getAnnio());
        org.junit.jupiter.api.Assertions.assertTrue(turismo.isDisponible());
        assertEquals(7, turismo.getPlazas());
        assertEquals(510.5, turismo.getCapacidadMaletero(), 0.001);
    }

    @Test
    void precioBaseDependeDeLaCategoria() {
        assertEquals(50, new Turismo("1", Categoria.NORMAL, 2020, 4, 300).getPrecioBase());
        assertEquals(80, new Turismo("2", Categoria.ESPECIAL, 2020, 4, 300).getPrecioBase());
        assertEquals(100, new Turismo("3", Categoria.SUPERIOR, 2020, 4, 300).getPrecioBase());
    }
}