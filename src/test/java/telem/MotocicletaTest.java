package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MotocicletaTest {
    @Test
    void constructorInicializaAtributos() {
        Motocicleta moto = new Motocicleta("3333CCC", Categoria.NORMAL, 2020, 650);

        assertEquals("3333CCC", moto.getMatricula());
        assertEquals(Categoria.NORMAL, moto.getCategoria());
        assertEquals(2020, moto.getAnnio());
        assertEquals(650, moto.getCilindrada());
        assertEquals("Motocicleta", moto.getTipo());
    }

    @Test
    void constructorJsonDeserializaAtributos() {
        String json = "{\"matricula\":\"4444DDD\",\"categoria\":\"ESPECIAL\","
                + "\"annio\":2024,\"disponible\":true,\"cilindrada\":900}";

        Motocicleta moto = new Motocicleta(json);

        assertEquals("4444DDD", moto.getMatricula());
        assertEquals(Categoria.ESPECIAL, moto.getCategoria());
        assertEquals(2024, moto.getAnnio());
        assertTrue(moto.isDisponible());
        assertEquals(900, moto.getCilindrada());
    }

    @Test
    void precioBaseDependeDeLaCategoria() {
        assertEquals(50, new Motocicleta("1", Categoria.NORMAL, 2020, 125).getPrecioBase());
        assertEquals(80, new Motocicleta("2", Categoria.ESPECIAL, 2020, 125).getPrecioBase());
        assertEquals(100, new Motocicleta("3", Categoria.SUPERIOR, 2020, 125).getPrecioBase());
    }
}