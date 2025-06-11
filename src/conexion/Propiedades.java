package conexion;

import java.io.InputStream;
import java.util.Properties;

public class Propiedades {
    private static final Properties props = new Properties();

    static {
        try {
            // Intenta cargar desde diferentes ubicaciones
            String[] rutasPosibles = {
                    "config.properties",
                    "/config.properties",
                    "resources/config.properties",
                    "/resources/config.properties"
            };

            boolean cargado = false;

            for (String ruta : rutasPosibles) {
                try (InputStream input = Propiedades.class.getClassLoader().getResourceAsStream(ruta)) {
                    if (input != null) {
                        props.load(input);
                        System.out.println("Archivo config.properties cargado desde: " + ruta);
                        cargado = true;
                        break;
                    }
                }
            }

            if (!cargado) {
                System.err.println("No se encontró el archivo config.properties en ninguna ubicación");
                // Cargar valores por defecto
                cargarValoresPorDefecto();
            }

        } catch (Exception e) {
            System.err.println("Error al cargar config.properties: " + e.getMessage());
            e.printStackTrace();
            cargarValoresPorDefecto();
        }
    }

    private static void cargarValoresPorDefecto() {
        System.out.println("Cargando valores por defecto...");
        props.setProperty("nombre_bd", "persona");
        props.setProperty("usuario_bd", "root");
        props.setProperty("clave_bd", "");
        props.setProperty("url_bd", "jdbc:mysql://localhost:3306/persona?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        props.setProperty("driver_bd", "com.mysql.cj.jdbc.Driver");
    }

    public static String get(String clave) {
        String valor = props.getProperty(clave);
        if (valor == null) {
            System.err.println("No se encontró la propiedad: " + clave);
        }
        return valor;
    }
}
