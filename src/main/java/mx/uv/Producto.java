package mx.uv;

public class Producto {
    private String idProducto;
    private String categoria;
    private String sabor;
    private String precio;
    private String cantidad;
    
    
    public Producto(String idProducto, String categoria, String sabor, String precio, String cantidad) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.sabor = sabor;
        this.precio = precio;
        this.cantidad = cantidad;
       
    }


 public String getIdProducto() {
    return idProducto;
}

public void setId(String idProducto) {
    this.idProducto = idProducto;
}

public String getCategoria() {
    return categoria;
}
public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public String getSabor() {
    return sabor;
}
public void setSabor(String sabor) {
    this.sabor = sabor;
}
public String getPrecio() {
    return precio;
}


public void setPrecio(String precio) {
    this.precio = precio;
}

public String getCantidad() {
    return cantidad;
}


public void setCantidad(String cantidad) {
    this.cantidad = cantidad;
}


}