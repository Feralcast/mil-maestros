/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.controlador;

import milmaestros.modelo.Modelo;
import milmaestros.vista.Ventana;

/**
 *
 * @author 1000Programadores PM
 */
public abstract class Controlador
{
    private final Ventana ventana;
    private final Modelo modelo;
    
    public Controlador (Ventana ventana, Modelo modelo)
    {
        this.ventana = ventana;
        this.modelo = modelo;
    }

    public Ventana getVentana()
    {
        return ventana;
    }

    public Modelo getModelo()
    {
        return modelo;
    }
    
    public abstract void iniciarControlador();
}
