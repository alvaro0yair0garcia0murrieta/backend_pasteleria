package mx.uv;

public class Pedidos {
     String id_usuario, tipo_pastel, direccion, comentario;

    public Pedidos(String id_usuario, String tipo_pastel, String direccion, String comentario) {
        this.id_usuario = id_usuario;
        this.tipo_pastel = tipo_pastel;
        this.direccion = direccion;
        this.comentario = comentario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_pastel() {
        return tipo_pastel;
    }

    public void setTipo_pastel(String tipo_pastel) {
        this.tipo_pastel = tipo_pastel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
     
}
