/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.modelo.impl;

import milmaestros.modelo.ConexionBD;
import milmaestros.modelo.Modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1000Programadores PM
 */
public class ModeloLogin implements Modelo
{
    private String username;
    private String password;

    public ModeloLogin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void obtenerUsuario(String usernameConsulta)
    {
        String sql = "SELECT username, password "
                + "FROM cliente "
                + "WHERE username = '" + usernameConsulta + "'";
        
        try
        {
            ResultSet rs = new ConexionBD().ejecutarConsulta(sql);
            
            if(rs.next())
            {
                username = rs.getString("username");
                password = rs.getString("password");
            }
            else
            {
                username = null;
                password = null;
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
