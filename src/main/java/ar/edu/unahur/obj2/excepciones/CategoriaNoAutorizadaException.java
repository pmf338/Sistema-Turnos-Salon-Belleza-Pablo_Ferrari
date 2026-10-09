package ar.edu.unahur.obj2.excepciones;

public class CategoriaNoAutorizadaException extends RuntimeException{
    public CategoriaNoAutorizadaException(){
        super("No se puede asignar la categoria VIP a un cliente sin turnos previos");
    }
}
