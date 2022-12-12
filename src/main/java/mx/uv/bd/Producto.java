package mx.uv.bd;

public class Producto {
    private String id;
    private String tipo;
    private String sabor;
    private int cantidad;
    private String tamaño;
    private double precio;

public Producto(String id, String tipo, String sabor, int cantidad, String tamaño, double precio){
    this.setId(id);
    this.setTipo(tipo);
 }

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    this.tipo = tipo;
}

public String getSabor() {
    return sabor;
}

public void setSabor(String sabor) {
    this.sabor = sabor;
}

public int getCantidad() {
    return cantidad;
}

public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}

public String getTamaño() {
    return tamaño;
}

public void setTamaño(String tamaño) {
    this.tamaño = tamaño;
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    this.precio = precio;
}

}
