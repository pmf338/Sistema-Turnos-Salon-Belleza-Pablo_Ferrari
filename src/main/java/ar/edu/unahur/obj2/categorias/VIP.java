package ar.edu.unahur.obj2.categorias;

public class VIP implements CategoriaCliente{

    @Override
    public Double aplicarDescuento(Double importe) {
        return importe * 0.80;
    }

}
