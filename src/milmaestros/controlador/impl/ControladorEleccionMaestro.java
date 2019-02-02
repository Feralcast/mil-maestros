/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.controlador.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


import milmaestros.EleccionMaestro;
import milmaestros.controlador.ControladorPrincipal;

public class ControladorEleccionMaestro extends ControladorPrincipal implements ActionListener
{
	public ControladorEleccionMaestro()
	{
		this.ventana = new EleccionMaestro();
		this.modelo = new ModeloEleccionMaestro();
		
		((EleccionMaestro) this.ventana).getIngresar().addActionListener(this);
		JComboBox<String> combo1 = ((EleccionMaestro) this.ventana).getUsername();
		List<String> usuarios = ((ModeloEleccionMaestro) this.modelo).obtenerRegiones();
		
		for(String region: regiones)
		{
			combo1.addItem(region);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String regiones = (String)((region) this.ventana).getRegion().getSelectedItem();
				
		String mee = ((ModeloEleccionMaestro) this.modelo).buscarRegion(region);
		
		if(mee == null)
		{
			JOptionPane.showMessageDialog(null, "Usuario no existe", "Error de login", JOptionPane.ERROR_MESSAGE);
		}
		else if (!mee.equals(region))
		{
			JOptionPane.showMessageDialog(null, "Password inválida", "Error de login", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Login válido", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}