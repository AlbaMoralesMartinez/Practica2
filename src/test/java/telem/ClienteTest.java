package telem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClienteTest {
    @Test
    void constructorInicializaNombreYDni() {
        Cliente cliente = new Cliente("Ana Pérez", "12345678Z");

        assertEquals("Ana Pérez", cliente.getNombre());
        assertEquals("12345678Z", cliente.getDni());
    }

    @Test
    void toStringSerializaNombreYDni() {
        Cliente cliente = new Cliente("Ana Pérez", "12345678Z");
        org.json.JSONObject json = new org.json.JSONObject(cliente.toString());

        assertEquals("Ana Pérez", json.getString("nombre"));
        assertEquals("12345678Z", json.getString("dni"));
    }
}