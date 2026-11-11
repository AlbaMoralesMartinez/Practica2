package telem;

import org.json.JSONObject;

public class VehiculoIndustrial extends Vehiculo {

    private int capacidadCarga;
    private int numeroEjes;

    public VehiculoIndustrial(String matricula, Categoria categoria, int annio,
        int capacidadCarga, int numeroEjes
    ) {
        super(matricula, categoria, annio);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public VehiculoIndustrial(String json) {
        super(json);
        JSONObject obj = new JSONObject(json);
        this.capacidadCarga = obj.getInt("capacidadCarga");
        this.numeroEjes = obj.getInt("numeroEjes");
    }




    @Override 
    public String toString() {
        return new JSONObject(this).toString();
    }
     public String getTipo(){
        return "VehiculoIndustrial";
    }

    public int getPrecioBase() {
        int precioBase = 0;
        switch (getCategoria()) {
            case NORMAL:
                precioBase = 200;
                break;
            case ESPECIAL:
                precioBase = 300;
                break;
            case SUPERIOR:
                precioBase = 400;
                break;
        }
        return precioBase;
    }



}
