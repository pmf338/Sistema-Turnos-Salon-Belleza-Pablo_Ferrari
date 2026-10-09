package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.servicios.Servicio;

public class Salon {
    private final ConfiguracionInsumos configuracion;
    private Integer cantidadTurnosConfirmados;
    
    public Salon(ConfiguracionInsumos configuracion, Integer cantidadTurnosConfirmados) {
        this.configuracion = configuracion;
        this.cantidadTurnosConfirmados = cantidadTurnosConfirmados;
    }

    public Turno confirmarTurno(Cliente cliente,Servicio servicio,Integer cantidadSesiones){
        Turno turno = servicio.confirmarTurno(cliente, cantidadSesiones, configuracion);
        cantidadTurnosConfirmados++;

        return turno;
    }

    public void actualizarRecargo(Double nuevoRecargo){
        configuracion.setRecargo(nuevoRecargo);
    }

    public ConfiguracionInsumos getConfiguracion() {
        return configuracion;
    }

    public Integer getCantidadTurnosConfirmados() {
        return cantidadTurnosConfirmados;
    }

    
}
