/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.controlador;

import milmaestros.vista.Ventana;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1000Programadores PM
 */
public class ControladorPrincipal
{
    private final HashMap<String, Controlador> mapaControladores;
    private Ventana ventanaVisible;
    
    public ControladorPrincipal ()
    {
        mapaControladores = new HashMap();
    }

    public void agregarControlador(String nombre, Controlador controlador)
    {
        mapaControladores.put(nombre, controlador);
    }
    
    public void iniciarControlador(String nombre)
    {
        if(mapaControladores.containsKey(nombre))
        {
            Controlador controlador = mapaControladores.get(nombre);
            controlador.iniciarControlador();
        }
    }

    public void mostrarVentana(String nombre)
    {
        if(ventanaVisible != null)
        {
            while(ventanaVisible.isVisible())
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(mapaControladores.containsKey(nombre))
        {
            Controlador controlador = mapaControladores.get(nombre);
            ventanaVisible = controlador.getVentana();
            ventanaVisible.setVisible(true);
        }
    }
}
