package mx.uv.bd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    public static List<Usuario> dameUsuarios() {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;

        con = Conexion.getConnection();

        List<Usuario> resultado = new ArrayList<>();

    
        try {
            String sql = "SELECT * from usuarios";
            stm = (Statement) con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            rs = null;
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                stm = null;
            }
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return resultado;
    }


    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuarios (id, nombre, email, password) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getEmail());
            stm.setString(4, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "El usuario fue agregado";
            else
                msj = "El usuario no se agrego";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }

    /**Buscar un usuario para poder iniciar sesión */

    public void buscarUsuario( String email, String password){
          Statement stm = null;
            ResultSet rs = null;
            Connection con = null;

            con = conexion.getConnection();
            try{
                String sql = "SELECT * FROM usuarios WHERE email='"+email+ "' AND password='"+ password +"'";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                if(rs.next()){
                    System.out.println("Bienvenido usuario");
                    if(java.awt.Desktop.isDesktopSupported()){
                        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                        if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)){
                            try{
                                
                                java.net.URI uri = new java.net.URI("https://www.youtube.com/shorts/mmyj1GVjMvk");
                                desktop.browse(uri);
                            } catch (URISyntaxException | IOException ex) {}
                        }
                    }

                }else{
                    System.out.println("No se pudo ingresar");
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally{
                if (stm != null) {
                    try {
                        stm.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }  
            

    }
}



 