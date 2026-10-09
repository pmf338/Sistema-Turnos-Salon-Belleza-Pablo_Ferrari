package ar.edu.unahur.obj2.categorias;

public class Frecuente implements CategoriaCliente{

    @Override
    public Double aplicarDescuento(Double importe) {
        return importe * 0.90;
    }

    
}
