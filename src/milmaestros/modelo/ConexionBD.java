/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1000Programadores PM
 */
public class ConexionBD
{
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/mil_maestros?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Santiago";

    static final String USERNAME = "root";
    static final String PASSWORD = "";
    
    public ConexionBD ()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
        }
        catch (ClassNotFoundException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection crearConexion() throws SQLException
    {
        return DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
    }
    
    private Statement crearSentencia() throws SQLException
    {
        return crearConexion().createStatement();
    }
    
    public ResultSet ejecutarConsulta(String sql) throws SQLException
    {
        return crearSentencia().executeQuery(sql);
    }

    public PreparedStatement prepareStatement(String insert_into_clientenombre_apellidoPaterno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
