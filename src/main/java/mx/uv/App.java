package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;

import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App {
    public static Gson gson = new Gson();

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        // Aqui va el CORS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            System.out.println(accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            System.out.println(accessControlRequestMethod);
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((req, res)-> res.header("Access-Control-Allow-Origin", "*"));


        get("/usuarios", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DAO.dameUsuarios());
        });

        get("/lista", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DAO.LisProductos());
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setId(id);
            // usuarios.put(id, u);

            DAO dao = new DAO();
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearUsuario(u));
            objetoJson.addProperty("id", id);
            return objetoJson;
        });

        post("/usuarioB", (req, res) -> {
            String payload = req.body();
            Usuario u = gson.fromJson(payload, Usuario.class);
            String email = u.getEmail();
            String password = u.getPassword();

            DAO dao = new DAO();
            JsonObject objetoJson = new JsonObject();
            dao.buscarUsuario(email, password);
            return objetoJson;
        });
        
    get("/productos", (req, res) -> {
        res.type("application/json");
        return gson.toJson(DAO.LisProductos());
      });
  
      post("/creaProductos", (req, res) -> {
        String id = UUID.randomUUID().toString();
        String datosUsu = req.body();
        final Producto p1 = gson.fromJson(datosUsu, Producto.class);
        p1.setId(id);
        DAO.NewProducto(p1);
        return DAO.NewProducto(p1);
      });
  
      get("/borrarProducto", (req, res) -> {
        System.out.println(req.queryParams("id"));
        return DAO.eliminaDAO(req.queryParams("id"));
      });

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
    }
}
