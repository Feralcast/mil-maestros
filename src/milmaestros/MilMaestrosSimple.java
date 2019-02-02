/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros;

import milmaestros.controlador.impl.ControladorLogin;
import milmaestros.controlador.impl.ControladorVentanaPrincipal;
import milmaestros.modelo.impl.ModeloLogin;
import milmaestros.modelo.impl.ModeloVentanaPrincipal;
import milmaestros.vista.impl.Login;
import milmaestros.vista.impl.VentanaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class MilMaestrosSimple
{
    public static void main(String[] args)
    {
        ControladorLogin cl = new ControladorLogin(new Login(), new ModeloLogin(null, null));
        cl.iniciarControlador();
        cl.getLogin().setVisible(true);
        
        while(cl.getLogin().isVisible())
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(MilMaestrosSimple.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ControladorVentanaPrincipal cvp = new ControladorVentanaPrincipal(new VentanaPrincipal(), new ModeloVentanaPrincipal());
        cvp.iniciarControlador();
        cvp.getVentanaPrincipal().setVisible(true);
    }
}
