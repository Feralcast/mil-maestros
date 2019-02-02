/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import milmaestros.modelo.ConexionBD;

/**
 *
 * @author 1000Programadores PM
 */
public class RegistroClientes extends JFrame implements ActionListener
{
   ConexionBD conn = new ConexionBD();
    
    private JTextField cajaTextoNombre = new JTextField();
    private JTextField cajaTextoApellidoPaterno = new JTextField();
    private JTextField cajaTextoApellidoMaterno = new JTextField();
    private JTextField cajaTextoRut = new JTextField();
    private JTextField cajaTextoDv = new JTextField();
    private JTextField cajaTextoDireccion = new JTextField();
    private JTextField cajaTextoComuna = new JTextField();
    private JTextField cajaTextoRegion = new JTextField();
    private JTextField cajaTextoTelefono = new JTextField();
    private JTextField cajaTextoEmail = new JTextField();
    private JTextField cajaTextoUsername = new JTextField();
    private JTextField cajaTextoPassword = new JTextField(); 
    
    private JButton aceptar = new JButton("Aceptar");
    private JLabel etiqueta = new JLabel();
    private JLabel nombre = new JLabel();
    private JLabel apellidoPaterno = new JLabel();
    private JLabel apellidoMaterno = new JLabel();
    private JLabel rut = new JLabel();
    private JLabel dv = new JLabel();
    private JLabel direccion = new JLabel();
    private JLabel comuna = new JLabel();
    private JLabel region = new JLabel();
    private JLabel telefono = new JLabel();
    private JLabel email = new JLabel();
    private JLabel username = new JLabel();
    private JLabel password = new JLabel();    
    private JLabel inicio = new JLabel();
   
    public RegistroClientes()
    {
        super("Formulario para Datos personales");
        setSize(400, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(null);
        
        inicio.setBounds(30, 10, 250, 30);
        inicio.setName("inicio");
        inicio.setText("COMPLETE LOS SIGUIENTES DATOS:");
        cp.add(inicio);
        
        nombre.setBounds(30, 50, 130, 30);
        nombre.setName("cajaTextoNombre");
        nombre.setText("Nombre(s)");
        cp.add(nombre);
        
        cajaTextoNombre.setBounds(150, 50, 200, 30);
        cajaTextoNombre.setActionCommand("cajaTextoNombre");
        cajaTextoNombre.setName("cajaTextoNombre");
        cp.add(cajaTextoNombre);
        
        apellidoPaterno.setBounds(30, 90, 130, 30);
        apellidoPaterno.setName("cajaTextoApellidoPaterno");
        apellidoPaterno.setText("Apellido Paterno");
        cp.add(apellidoPaterno);
        
        cajaTextoApellidoPaterno.setBounds(150, 90, 200, 30);
        cajaTextoApellidoPaterno.setActionCommand("cajaTextoApellidoPaterno");
        cajaTextoApellidoPaterno.setName("cajaTextoApellidoPaterno");
        cp.add(cajaTextoApellidoPaterno);
                
        apellidoMaterno.setBounds(30, 130, 130, 30);
        apellidoMaterno.setName("cajaTextoApellidoMaterno");
        apellidoMaterno.setText("Apellido Materno");
        cp.add(apellidoMaterno);
        
        cajaTextoApellidoMaterno.setBounds(150, 130, 200, 30);
        cajaTextoApellidoMaterno.setActionCommand("cajaTextoApellidoMaterno");
        cajaTextoApellidoMaterno.setName("cajaTextoApellidoMaterno");
        cp.add(cajaTextoApellidoMaterno);
        
        rut.setBounds(30, 170, 130, 30);
        rut.setName("cajaTextoRut");
        rut.setText("RUT");
        cp.add(rut);
        
        cajaTextoRut.setBounds(150, 170, 130, 30);
        cajaTextoRut.setActionCommand("cajaTextoRut");
        cajaTextoRut.setName("cajaTextoRut");
        cp.add(cajaTextoRut);
        
        dv.setBounds(290, 170, 30, 30);
        dv.setName("cajaTextoDv");
        dv.setText("-");
        cp.add(dv);
        
        cajaTextoDv.setBounds(300, 170, 50, 30);
        cajaTextoDv.setActionCommand("cajaTextoDv");
        cajaTextoDv.setName("cajaTextoDv");
        cp.add(cajaTextoDv);
        
        direccion.setBounds(30, 210, 130, 30);
        direccion.setName("cajaTextoDireccion");
        direccion.setText("Dirección");
        cp.add(direccion);
        
        cajaTextoDireccion.setBounds(150, 210, 200, 30);
        cajaTextoDireccion.setActionCommand("cajaTextoDireccion");
        cajaTextoDireccion.setName("cajaTextoDireccion");
        cp.add(cajaTextoDireccion);
        
        comuna.setBounds(30, 250, 130, 30);
        comuna.setName("cajaTextoComuna");
        comuna.setText("Comuna");
        cp.add(comuna);
        
        cajaTextoComuna.setBounds(150, 250, 200, 30);
        cajaTextoComuna.setActionCommand("cajaTextoComuna");
        cajaTextoComuna.setName("cajaTextoComuna");
        cp.add(cajaTextoComuna);
        
        region.setBounds(30, 290, 130, 30);
        region.setName("cajaTextoRegion");
        region.setText("Región");
        cp.add(region);
        
        cajaTextoRegion.setBounds(150, 290, 200, 30);
        cajaTextoRegion.setActionCommand("cajaTextoRegion");
        cajaTextoRegion.setName("cajaTextoRegion");
        cp.add(cajaTextoRegion);
        
        telefono.setBounds(30, 330, 180, 30);
        telefono.setName("cajaTextoTelefono");
        telefono.setText("Teléfono                        +56");
        cp.add(telefono);
        
        cajaTextoTelefono.setBounds(180, 330, 170, 30);
        cajaTextoTelefono.setActionCommand("cajaTextoTelefono");
        cajaTextoTelefono.setName("cajaTextoTelefono");
        cp.add(cajaTextoTelefono);
        
        email.setBounds(30, 370, 130, 30);
        email.setName("cajaTextoEmail");
        email.setText("E-mail");
        cp.add(email);
        
        cajaTextoEmail.setBounds(150, 370, 200, 30);
        cajaTextoEmail.setActionCommand("cajaTextoEmail");
        cajaTextoEmail.setName("cajaTextoEmail");
        cp.add(cajaTextoEmail);
        
        username.setBounds(30, 450, 130, 30);
        username.setName("cajaTextoUsername");
        username.setText("Elija Nombre Usuario");
        cp.add(username);
        
        cajaTextoUsername.setBounds(150, 450, 200, 30);
        cajaTextoUsername.setActionCommand("cajaTextoUsername");
        cajaTextoUsername.setName("cajaTextoUsername");
        cp.add(cajaTextoUsername);
        
        password.setBounds(30, 490, 130, 30);
        password.setName("cajaTextoPassword");
        password.setText("Elija Contraseña");
        cp.add(password);
        
        cajaTextoPassword.setBounds(150, 490, 200, 30);
        cajaTextoPassword.setActionCommand("cajaTextoPassword");
        cajaTextoPassword.setName("cajaTextoPassword");
        cp.add(cajaTextoPassword);
        
        aceptar.setBounds(220, 550, 130, 30);
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
        
        if(comando.equals("Aceptar"))
        {
            PreparedStatement ps = conn.ejecutarConsulta("INSERT INTO cliente(nombre, apellidoPaterno, apellidoMaterno, rut, direccion, comuna, region, telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    
            ps.setString(1,cajaTextoNombre.getText());
            String texto = cajaTextoNombre.getText();
            String aceptar = "¡Datos guardados exitosamente!";
            etiqueta.setText(aceptar);
            JOptionPane.showMessageDialog(null, aceptar);
        }
    }
}
        


} 
