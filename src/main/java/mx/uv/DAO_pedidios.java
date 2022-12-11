package mx.uv;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.jdbc.PreparedStatement;
// import com.mysql.jdbc.Statement;
import java.sql.*;
public class DAO_pedidios {
      // en el dao se establece la conexion a la BD
      private static Conexion c = new Conexion();

      // este metodo regresa un conjunto de usuarios que cumpla un criterio
      public static List<Pedidos> damePedidos() {
          Statement stm = null;
          ResultSet rs = null;
          Connection conn = null;
          List<Pedidos> resultado = new ArrayList<>();
  
          conn = c.getConnection();
  
          try {
              String sql = "SELECT * from pedidos";
              stm = (Statement) conn.createStatement();
              rs = stm.executeQuery(sql);
              while (rs.next()) {
                  Pedidos u = new Pedidos(rs.getString("id_usuario"), rs.getString("tipo_pastel"), rs.getString("direccion"), rs.getString("comentario"));
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
                  conn.close();
              } catch (Exception e) {
                  System.out.println(e);
              }
          }
  
          return resultado;
      }
  
      public static String crearPedido(Pedidos u) {
          PreparedStatement stm = null;
          Connection conn = null;
          String msj = "";
  
          conn = c.getConnection();
          try {
              String sql = "INSERT INTO pedidos (id_usuario, tipo_pastel, direccion, comentario) values (?,?,?,?)";
              stm = (PreparedStatement) conn.prepareStatement(sql);
              stm.setString(1, u.getId_usuario());
              stm.setString(2, u.getTipo_pastel());
              stm.setString(3, u.getDireccion());
              stm.setString(4, u.getComentario());
              if (stm.executeUpdate() > 0)
                  msj = "pedido agregado";
              else
                  msj = "pedido no agregado";
  
          } catch (Exception e) {
              System.out.println(e);
          } finally {
              if (stm != null) {
                  try {
                      stm.close();
                  } catch (Exception e) {
                      System.out.println(e);
                  }
                  stm = null;
              }
              try {
                  conn.close();
              } catch (Exception e) {
                  System.out.println(e);
              }
          }
          return msj;
      }

      
}
