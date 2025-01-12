package Practica.Base_de_Datos_Y_Archivos;
import java.sql.*;
/**
 * Ese archivo de java trata de metodos que se utilizan para conectar,
 * hacer consultas o modificar una base de datos
 * @author Mparr
 * @date 13/05/2024
 */
public class Metodos_para_Java_conectada_a_BBDD {
    private static final String url = "jdbc:mysql://192.168.80.153:3306/prueba";//Ejemplo de url cambiar si no es el ordenador del instituto
    private static final String user = "manuel";//Ejemplo de user cambiar si no es el ordenador del instituto
    private static final String password = "Opassword78%";//Ejemplo de password cambiar si no es el ordenador del instituto

    /**
     * Metodo que te permite conectarte a la base de datos
     * @return La conexion a la base de datos para que se pueda utilizar
     */
    private static Connection conectar() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }//Fin try-catch
    }//Fin de conectar

    /**
     * Metodo para crear un Statement que nos permita hacer consultas
     * @param con La conexion  a la base de datos
     * @return El Statement listo para ser utilizado
     */
    private static Statement crearStatement(Connection con) {
        try {
            return con.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al crear el statement: " + e.getMessage());
            return null;
        }//Fin de crearStatement
    }//Fin de crearStatement

    /**
     * Metodo que cierra la conexion a la base  de datos y el Statement
     * @param con Conexion que quieres cerrar
     * @param instruccion Statement que quieres cerrar
     */
    private static void cerrar(Connection con, Statement instruccion) {
        try {
            instruccion.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }//Fin try-catch
    }//Fin de cerrar

    /**
     * Metodo que inserta informacion a una tabla
     * @param instruccion Statement que realiza la insercion
     * @param insercion Insercion
     */
    private static void insertaNuevaInformacion(Statement instruccion, String insercion) {
        try {
            int filasAfectadas = instruccion.executeUpdate(insercion);
            System.out.println("Se ha insertado corectamente " + filasAfectadas+" fila");
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta: " + e.getMessage());
        }//Fin try-catch
    }//Fin de insertarNuevaInformacion

    /**
     * Metodo que elimina un registro de una tabla
     * @param instruccion Statement que realiza la eliminacion
     * @param consulta Sentencia de delete
     */
    private static void eliminarInformacion(Statement instruccion, String consulta) {
        try {
            int filasAfectadas = instruccion.executeUpdate(consulta);
            System.out.println("Se ha eliminado corectamente " + filasAfectadas+" fila");
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta: " + e.getMessage());
        }//Fin try-catch
    }//Fin EliminarEmpleado

    /**
     * Metodo que realiza una consulta a la base de datos
     * @param instruccion Statement que ejecuta la consulta
     * @param consulta Consulta que se va hacer
     */
    private static void hacerConsulta(Statement instruccion,String consulta) {
        try {
            ResultSet resultado = instruccion.executeQuery(consulta);
            while (resultado.next()) {
            }/*Dentro del bucle la informacion que quieres extraer con .getnombre de dato y
             mostrar con  println o añadirlo todo en una variable o StringBuilder*/
            resultado.close();
        } catch (SQLException e) {
            System.out.println("Error al hacer la consulta: " + e.getMessage());
        }//Fin try-catch
    }//Fin de hacerConsulta

    /**
     * Metodo que hace una consulta utilizando el PreparedStament
     * @param nombreParametro1-Lo que se quiere buscar
     * @param nombreParametro2-El filtro de la información
     * @param con-La conexion
     * @param consulta-La consulta que se quier hacer
     */
    private static void hacerConsultaConPrepared(String nombreParametro1,String nombreParametro2,Connection con,String consulta) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(consulta);

            pstmt.setString(1, nombreParametro1);
            pstmt.setString(2, nombreParametro2);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                /*
                Declarar las variables corespondientes
                e imprimirlas por pantalla
                 */
            }//Fin while
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 7: Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//Fin try-catch
        }//Fin try-catch-finally
    }//Fin de hacerConsultasConPrepared

    /**
     * Metodo que obtiene la metadata de la base de datos
     * @param con -La conexion
     */
    private static void ObtenerMetadata(Connection con) {
        try {
            DatabaseMetaData metaData = con.getMetaData();

            // Mostrar información general
            System.out.println("Nombre del Producto: " + metaData.getDatabaseProductName());
            System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
            System.out.println("Nombre del Driver: " + metaData.getDriverName());
            System.out.println("Versión del Driver: " + metaData.getDriverVersion());

            // Obtener lista de tablas
            ResultSet rsTables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("Tablas en la base de datos:");
            while (rsTables.next()) {
                String tableName = rsTables.getString("TABLE_NAME");
                System.out.println("Tabla: " + tableName);
            }//Fin while

            ResultSet rsColumns = metaData.getColumns(null, null, "tu_tabla", "%");
            System.out.println("\nColumnas en la tabla 'tu_tabla':");
            while (rsColumns.next()) {
                String columnName = rsColumns.getString("COLUMN_NAME");
                String columnType = rsColumns.getString("TYPE_NAME");
                int columnSize = rsColumns.getInt("COLUMN_SIZE");
                System.out.println("Columna: " + columnName + " | Tipo: " + columnType + " | Tamaño: " + columnSize);
            }//Fin while
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Paso 4: Cerrar la conexión
            try {
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//Fin try-catch
        }//Fin try-catch-finally
    }//Fin de ObtenerMetadata
}//Fin de Metodos_para_Java_conectada_a_BBDD
