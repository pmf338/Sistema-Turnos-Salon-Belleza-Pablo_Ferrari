package ar.edu.unahur.obj2.excepciones;

public class ClienteSinTurnosException extends RuntimeException{

    public ClienteSinTurnosException(){
        super("El cliente no tiene turnos en el historial");
    }
}
