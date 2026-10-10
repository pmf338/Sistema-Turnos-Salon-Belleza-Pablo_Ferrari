package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cliente;
import ar.edu.unahur.obj2.ConfiguracionInsumos;
import ar.edu.unahur.obj2.Salon;
import ar.edu.unahur.obj2.Turno;
import ar.edu.unahur.obj2.categorias.Ocasional;
import ar.edu.unahur.obj2.servicios.Servicio;
import ar.edu.unahur.obj2.servicios.TratamientoCapilar;

public class ServicioCapilarTest {

    @Test
    public void tratamientoPermiteReservarVariasSesiones() {
    ConfiguracionInsumos configuracion = new ConfiguracionInsumos(500.0);
    Salon salon = new Salon(configuracion,0);
    Cliente cliente = new Cliente("Pablo", new Ocasional(),new ArrayList<Turno>());
    Servicio tratamiento = new TratamientoCapilar(10000.0, 10);

    Turno turno = salon.confirmarTurno(cliente, tratamiento, 3);

    assertEquals(3, turno.getCantidadSesiones());
    assertEquals(7, tratamiento.getCuposDisponibles());
    }
}
