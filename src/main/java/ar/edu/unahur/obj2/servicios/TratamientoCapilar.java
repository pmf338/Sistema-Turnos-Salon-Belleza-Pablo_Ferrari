package ar.edu.unahur.obj2.servicios;

public class TratamientoCapilar extends Servicio{

    public TratamientoCapilar(Double precioBase, Integer cuposDisponibles) {
        super(precioBase, cuposDisponibles);
    }

    @Override
    protected String prefijoComprobante() {
        return "TRN-TRA-";
    }

    @Override 
    protected Boolean permiteMultiplesSesiones(){
        return true;
    }

}
