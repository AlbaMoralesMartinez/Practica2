package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VehiculoIndustrialTest {
    @Test
    void constructorInicializaAtributos() {
        VehiculoIndustrial industrial = new VehiculoIndustrial("5555EEE", Categoria.NORMAL, 2019, 12000, 4);

        assertEquals("5555EEE", industrial.getMatricula());
        assertEquals(Categoria.NORMAL, industrial.getCategoria());
        assertEquals(2019, industrial.getAnnio());
        assertEquals(12000, industrial.getCapacidadCarga());
        assertEquals(4, industrial.getNumeroEjes());
        assertEquals("VehiculoIndustrial", industrial.getTipo());
    }

    @Test
    void constructorJsonDeserializaAtributos() {
        String json = "{\"matricula\":\"6666FFF\",\"categoria\":\"SUPERIOR\","
                + "\"annio\":2022,\"disponible\":true,\"capacidadCarga\":18000,\"numeroEjes\":6}";

        VehiculoIndustrial industrial = new VehiculoIndustrial(json);

        assertEquals("6666FFF", industrial.getMatricula());
        assertEquals(Categoria.SUPERIOR, industrial.getCategoria());
        assertEquals(2022, industrial.getAnnio());
        assertTrue(industrial.isDisponible());
        assertEquals(18000, industrial.getCapacidadCarga());
        assertEquals(6, industrial.getNumeroEjes());
    }

    @Test
    void precioBaseDependeDeLaCategoria() {
        assertEquals(200, new VehiculoIndustrial("1", Categoria.NORMAL, 2020, 1000, 2).getPrecioBase());
        assertEquals(300, new VehiculoIndustrial("2", Categoria.ESPECIAL, 2020, 1000, 2).getPrecioBase());
        assertEquals(400, new VehiculoIndustrial("3", Categoria.SUPERIOR, 2020, 1000, 2).getPrecioBase());
    }
}