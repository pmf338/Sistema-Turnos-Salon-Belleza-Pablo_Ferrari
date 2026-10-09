package ar.edu.unahur.obj2.servicios;

import ar.edu.unahur.obj2.Turno;

public class Coloracion extends Servicio{

    private Boolean avisoRetoqueRegistrado;
    private Integer diasParaRetoque;
    
    public Coloracion(Double precioBase, Integer cuposDisponibles, Boolean avisoRetoqueRegistrado,
            Integer diasParaRetoque) {
        super(precioBase, cuposDisponibles);
        this.avisoRetoqueRegistrado = avisoRetoqueRegistrado;
        this.diasParaRetoque = diasParaRetoque;
    }

    @Override
    protected String prefijoComprobante() {
        return "TRN-COL-";
    }

    @Override
    protected void accionPosteriorConfirmacion(Turno turno){
        avisoRetoqueRegistrado = true;
        diasParaRetoque = 30;
    }

    public Boolean tieneAvisoRetoqueRegistrado(){
        return avisoRetoqueRegistrado;
    }

    public Integer getDiasParaRetoque() {
        return diasParaRetoque;
    }

    

    
}
