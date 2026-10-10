package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.servicios.CorteDeCabello;
import ar.edu.unahur.obj2.servicios.Servicio;

public class CorteDeCabelloTest {

    @Test 
    public void dadoPrecioBaseYCuposValidos_alCrearElServicio_quedanRegistrados() {
        Servicio servicio = new CorteDeCabello(10000.0,5); 

        assertEquals(10000.0,servicio.getPrecioBase());
        
        assertEquals(5,servicio.getCuposDisponibles());
    }
}
