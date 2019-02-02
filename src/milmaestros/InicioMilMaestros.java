/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros;

import milmaestros.controlador.impl.ControladorVentanaPrincipal;
import milmaestros.controlador.ControladorPrincipal;
import milmaestros.controlador.impl.ControladorLogin;
import milmaestros.modelo.impl.ModeloLogin;
import milmaestros.modelo.impl.ModeloVentanaPrincipal;
import milmaestros.vista.impl.Login;
import milmaestros.vista.impl.VentanaPrincipal;

/**
 *
 * @author 1000Programadores PM
 */
public class InicioMilMaestros
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ControladorPrincipal cp = new ControladorPrincipal();
        cp.agregarControlador("login", new ControladorLogin(new Login(), new ModeloLogin(null, null)));
        cp.agregarControlador("principal", new ControladorVentanaPrincipal(new VentanaPrincipal(), new ModeloVentanaPrincipal()));
        cp.iniciarControlador("login");
        cp.mostrarVentana("login");
        cp.iniciarControlador("principal");
        cp.mostrarVentana("principal");
    }
}
