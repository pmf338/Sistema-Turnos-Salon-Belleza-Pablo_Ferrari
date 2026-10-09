package ar.edu.unahur.obj2.excepciones;

public class CantidadInvalidaException extends RuntimeException{
    
    public CantidadInvalidaException(){
        super("La cantidad de sesiones debe ser mayor que cero");
    }

}
