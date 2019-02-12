/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros;

import milmaestros.vista.impl.MiVentana;
import milmaestros.vista.impl.VentanaPrincipal;

/**
 *
 * @author 1000Programadores PM
 */
public class MilMaestros
{
    public static void main(String[] args)
    {
        
        RegistroClientes rc = new RegistroClientes();
        rc.setVisible(true);
        
        RegistroMaestros rm = new RegistroMaestros();
        rm.setVisible(false);
        
        RegistroEleccion re = new RegistroEleccion();
        re.setVisible(false);
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(false);
        
        MiVentana mv = new MiVentana();
        mv.setVisible(false);
        
        EleccionMaestro em = new EleccionMaestro();
        em.setVisible(false);
        
        
        
    }
}
