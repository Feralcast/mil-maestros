/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 1000Programadores PM
 */
public class RegistroEleccion extends JFrame implements ActionListener
{
    private JRadioButton usuario = new JRadioButton("SoyUsuario");
    private JRadioButton maestro = new JRadioButton("SoyMaestro");
    private JButton aceptar = new JButton("Aceptar");
    private JLabel inicio = new JLabel();
    private JLabel etiqueta = new JLabel();
   
    public RegistroEleccion()
    {
        super("Registro");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(null);
        
        inicio.setBounds(30, 10, 330, 50);
        inicio.setName("inicio");
        inicio.setText("ESCOJA LA OPCIÓN QUE CORRESPONDA:");
        cp.add(inicio);
        
        usuario.setBounds(30, 60, 130, 30);
        usuario.setName("usuario");
        usuario.setText("Soy Usuario");
        cp.add(usuario);
        
        maestro.setBounds(30, 90, 130, 30);
        maestro.setName("maestro");
        maestro.setText("Soy Maestro");
        cp.add(maestro);  
        
        ButtonGroup bg = new ButtonGroup (); 
        bg.add(usuario);
        bg.add(maestro);    

        aceptar.setBounds(30, 130, 130, 30);
        aceptar.setActionCommand("Aceptar");
        aceptar.setName("Aceptar");
        aceptar.addActionListener(this);
        cp.add(aceptar);
        
        etiqueta.setBounds(50, 500, 250, 30);
        etiqueta.setName("Aceptar");
        cp.add(etiqueta);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        
        if(maestro.isSelected())
        {
        RegistroMaestros  rm = new RegistroMaestros();
        rm.setVisible(true);     
        } 
        
        else if (usuario.isSelected())
        {
        RegistroClientes  rc = new RegistroClientes();
        rc.setVisible(true);     
        } 
        
        else    
        {
            String aceptar = "Debe escoger una opción";
            etiqueta.setText(aceptar);
            JOptionPane.showMessageDialog(null, aceptar);
        }
    }
}
 
