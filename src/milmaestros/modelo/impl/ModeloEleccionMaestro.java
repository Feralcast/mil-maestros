/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.modelo.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import milmaestros.modelo.ConexionBD;

public class ModeloEleccionMaestro extends ConexionBD
{
	public String buscarRegion(String regiones) 
	{
		//String password = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			conn = obtenerConexion();
			stmt = conn.createStatement();
			
			String sql = "SELECT region FROM regiones";
			
			 rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				password = rs.getString("password");
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			//Error
		}
		finally
		{
			if(conn != null) { 
				try { conn.close(); } catch (SQLException e) { } 
			}
			
			if(stmt != null) { 
				try { stmt.close(); } catch (SQLException e) { } 
			}
			
			if(rs != null) { 
				try { rs.close(); } catch (SQLException e) { } 
			}
		}
		
		return password;
	}

	public List<String> obtenerRegiones() 
	{
		List<String> usuarios = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			conn = obtenerConexion();
			stmt = conn.createStatement();
			
			String sql = "SELECT region FROM regiones";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String region = rs.getString("region");
				combo1.add(region);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			//Error
		}
		finally
		{
			if(conn != null) { 
				try { conn.close(); } catch (SQLException e) { } 
			}
			
			if(stmt != null) { 
				try { stmt.close(); } catch (SQLException e) { } 
			}
			
			if(rs != null) { 
				try { rs.close(); } catch (SQLException e) { } 
			}
		}
		
		return regiones;
	}

}