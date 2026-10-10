package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cliente;
import ar.edu.unahur.obj2.ConfiguracionInsumos;
import ar.edu.unahur.obj2.Salon;
import ar.edu.unahur.obj2.Turno;
import ar.edu.unahur.obj2.categorias.Ocasional;
import ar.edu.unahur.obj2.servicios.CorteDeCabello;
import ar.edu.unahur.obj2.servicios.Servicio;

public class ServicioOcasionalTest {

    @Test
    public void unClienteOcasionalPagaElPrecioMasElRecargo(){
        ConfiguracionInsumos configuracion = new ConfiguracionInsumos(500.0);
        Salon salon = new Salon(configuracion,0);
        Cliente cliente = new Cliente("Ramiro",new Ocasional(),new ArrayList<Turno>());
        Servicio corte = new CorteDeCabello(10000.0,5);
        
        var turno = salon.confirmarTurno(cliente, corte, 1);

        assertEquals(10500.0,turno.getImporteTotal());
        assertEquals(4,corte.getCuposDisponibles());
    }
}
