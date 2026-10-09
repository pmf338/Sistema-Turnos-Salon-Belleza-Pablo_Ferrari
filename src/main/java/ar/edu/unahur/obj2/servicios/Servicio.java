package ar.edu.unahur.obj2.servicios;

import ar.edu.unahur.obj2.Cliente;
import ar.edu.unahur.obj2.ConfiguracionInsumos;
import ar.edu.unahur.obj2.Turno;
import ar.edu.unahur.obj2.excepciones.CantidadInvalidaException;
import ar.edu.unahur.obj2.excepciones.PrecioNegativoException;

public abstract class Servicio {

    private static Integer contadorComprobantes = 0;
    private final Double precioBase;
    private Integer cuposDisponibles;
    
    public Servicio(Double precioBase, Integer cuposDisponibles) {
       
        this.precioBase = validarPrecioBase(precioBase);
        this.cuposDisponibles = cuposDisponibles;
    }

    private Double validarPrecioBase(Double precioBase){
        if (precioBase < 0) {
            throw new PrecioNegativoException();
        }
        return precioBase;
    }

    public Turno confirmarTurno(Cliente cliente,Integer cantidadSesiones,ConfiguracionInsumos configuracion){
        
        validarCantidad(cantidadSesiones);

        if(!permiteMultiplesSesiones() && cantidadSesiones != 1){
            throw new CantidadInvalidaException();
        }

        if(cantidadSesiones > this.cuposDisponibles){
            throw new IllegalStateException("No hay suficientes cupos disponibles.");
        }

        Double subTotal = this.precioBase * cantidadSesiones;
        Double importeConDescuento = cliente.getCategoria().aplicarDescuento(subTotal);
        Double importeFinal = importeConDescuento + configuracion.getRecargo();
        String comprobante = generarComprobante();

        Turno turno = new Turno(cliente,this,cantidadSesiones,importeFinal,comprobante);

        cuposDisponibles -= cantidadSesiones;
        cliente.agregarTurno(turno);
        accionPosteriorConfirmacion(turno);

        return turno;
    }

    private void validarCantidad(Integer cantidadSesiones){
        if(cantidadSesiones == null || cantidadSesiones <= 0){
            throw new CantidadInvalidaException();
        }
    }

    protected Boolean permiteMultiplesSesiones(){
        return false;
    }

    protected abstract String prefijoComprobante();

    protected String generarComprobante(){
        contadorComprobantes++;
        return prefijoComprobante() + contadorComprobantes;
    }

    protected void accionPosteriorConfirmacion(Turno turno){}

    public Double getPrecioBase() {
        return precioBase;
    }

    public Integer getCuposDisponibles() {
        return cuposDisponibles;
    }

    

    
}
