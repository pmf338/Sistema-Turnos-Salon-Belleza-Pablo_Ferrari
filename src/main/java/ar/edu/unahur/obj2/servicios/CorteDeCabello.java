package ar.edu.unahur.obj2.servicios;

public class CorteDeCabello extends Servicio{

    public CorteDeCabello(Double precioBase, Integer cuposDisponibles) {
        super(precioBase, cuposDisponibles);
    }

    @Override
    protected String prefijoComprobante() {
        return "TRN-COR-";
    }

    
}
