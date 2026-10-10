package ar.edu.unahur.obj2.peluqueria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Cliente;
import ar.edu.unahur.obj2.ConfiguracionInsumos;
import ar.edu.unahur.obj2.Salon;
import ar.edu.unahur.obj2.Turno;
import ar.edu.unahur.obj2.categorias.Ocasional;
import ar.edu.unahur.obj2.servicios.Coloracion;

public class ServicioColoracionTest {

    @Test 
    public void coloracionRegistraElAvisoDeRetoque(){
        ConfiguracionInsumos configuracion = new ConfiguracionInsumos(500.0);
        Salon salon = new Salon(configuracion,0);
        Cliente cliente = new Cliente("Leandro",new Ocasional(),new ArrayList<Turno>());
        Coloracion coloracion = new Coloracion(20000.0,5,false,0);

        salon.confirmarTurno(cliente,coloracion,1);

        assertTrue(coloracion.tieneAvisoRetoqueRegistrado());
        assertEquals(30,coloracion.getDiasParaRetoque());
    }
}
