package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.servicios.Servicio;

public class Turno {

    private Cliente cliente;
    private Servicio servicio;
    private Integer cantidadSesiones;
    private Double importeTotal;
    private String comprobante;
    private Boolean confirmado;
    
    public Turno(Cliente cliente, Servicio servicio, Integer cantidadSesiones, Double importeTotal, String comprobante) {
        this.cliente = cliente;
        this.servicio = servicio;
        this.cantidadSesiones = cantidadSesiones;
        this.importeTotal = importeTotal;
        this.comprobante = comprobante;
        this.confirmado = true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Integer getCantidadSesiones() {
        return cantidadSesiones;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public String getComprobante() {
        return comprobante;
    }

    public Boolean estaConfirmado() {
        return confirmado;
    }

    

    
}
