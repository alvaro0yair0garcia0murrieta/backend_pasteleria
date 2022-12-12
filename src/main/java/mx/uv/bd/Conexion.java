package mx.uv.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static ProcessBuilder processBuilder = new ProcessBuilder();

    private static String url = "jdbc:mysql://db4free.net:3306/canolli_01"; //processBuilder.environment().get("DB"); // "jdbc:mysql://db4free.net:3306/ejemplo";
    private static String driverName =  "com.mysql.cj.jdbc.Driver"; // "com.mysql.jdbc.Driver"; //
    private static String username= "canolli_01";//processBuilder.environment().get("USERDB");//USERDB= canolli_01
    private static String password =  "sistemasweb";//processBuilder.environment().get("PASSDB");;//PASSDB= sistemasweb
    // variable de conexion
    private static Connection connection = null;

public static Connection getConnection(){
    try {
        Class.forName(driverName);
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        System.out.println(" SQL:" + e);
    } catch (ClassNotFoundException e){
        System.out.println("Driver:" + e);
    }
    return connection;
}
}
