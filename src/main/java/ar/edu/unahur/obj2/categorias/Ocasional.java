package ar.edu.unahur.obj2.categorias;

public class Ocasional implements CategoriaCliente{
    
    @Override
    public Double aplicarDescuento(Double importe){
        return importe;
    }
}
