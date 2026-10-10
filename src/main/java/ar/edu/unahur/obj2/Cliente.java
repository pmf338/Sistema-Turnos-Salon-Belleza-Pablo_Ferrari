package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.categorias.CategoriaCliente;
import ar.edu.unahur.obj2.categorias.VIP;
import ar.edu.unahur.obj2.excepciones.CategoriaNoAutorizadaException;
import ar.edu.unahur.obj2.excepciones.ClienteSinTurnosException;

public class Cliente {

    private final String nombre;
    private CategoriaCliente categoria;
    private List<Turno> historial = new ArrayList<>();
    
    public Cliente(String nombre, CategoriaCliente categoria, List<Turno> historial) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.historial = validarHistorial(historial);
    }

    private List<Turno> validarHistorial(List<Turno> historial){
        if(historial.isEmpty()){
            throw new ClienteSinTurnosException();
        }
        return historial;
    }

    public void asignarCategoria(CategoriaCliente nuevaCategoria){
        if(nuevaCategoria instanceof VIP && historial.isEmpty()){
            throw new CategoriaNoAutorizadaException();
        }

        categoria = nuevaCategoria;
    }

    public void agregarTurno(Turno turno){
        historial.add(turno);
    }

    public Double calcularCostoTotalTurnos(){
        return historial.stream().mapToDouble(Turno::getImporteTotal).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaCliente getCategoria() {
        return categoria;
    }

    public List<Turno> getHistorial() {
        return historial;
    }

    

    
}
