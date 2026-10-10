package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cliente;
import ar.edu.unahur.obj2.ConfiguracionInsumos;
import ar.edu.unahur.obj2.Salon;
import ar.edu.unahur.obj2.Turno;
import ar.edu.unahur.obj2.categorias.Ocasional;
import ar.edu.unahur.obj2.categorias.VIP;
import ar.edu.unahur.obj2.servicios.CorteDeCabello;
import ar.edu.unahur.obj2.servicios.Servicio;

public class ClienteTest {

    @Test 
    public void unClientePuedePasarA_VIP_DespuesDeSuPrimerTurno(){
        ConfiguracionInsumos configuracion = new ConfiguracionInsumos(500.0);
        Salon salon = new Salon(configuracion,0);
        Cliente cliente = new Cliente("Cecilia",new Ocasional(),new ArrayList<Turno>());
        Servicio corte = new CorteDeCabello(10000.0,5);

        salon.confirmarTurno(cliente, corte, 1);
        cliente.asignarCategoria(new VIP());

        assertInstanceOf(VIP.class,cliente.getCategoria());
    }
}
