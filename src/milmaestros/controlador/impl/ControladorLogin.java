/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.controlador.impl;

import milmaestros.controlador.Controlador;
import milmaestros.modelo.impl.ModeloLogin;
import milmaestros.vista.impl.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 1000Programadores PM
 */
public class ControladorLogin extends Controlador implements ActionListener, KeyListener
{
    public ControladorLogin(Login ventana, ModeloLogin modelo)
    {
        super(ventana, modelo);
    }
    
    public Login getLogin()
    {
        return (Login)getVentana();
    }
    
    public ModeloLogin getModeloLogin()
    {
        return (ModeloLogin)getModelo();
    }
    
    @Override
    public void iniciarControlador()
    {
        getLogin().getCajaTextoUsername().addKeyListener(this);
        getLogin().getCajaTextoPassword().addKeyListener(this);
        getLogin().getBotonIngresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        switch(comando)
        {
            case "botonIngresar": validarLogin(); break;
            default: break;
        }
    }

    private void validarLogin() 
    {
        String username = getLogin().getCajaTextoUsername().getText();
        char[] password = getLogin().getCajaTextoPassword().getPassword();
        
        ModeloLogin modeloLogin = getModeloLogin();
        modeloLogin.obtenerUsuario(username);
        
        if(username == null || username.trim().isEmpty()
                || password == null || password.length <= 3 || username.trim().length() <= 3)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un usuario y contraseña válido", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
        else if(modeloLogin.getUsername() == null)
        {
            JOptionPane.showMessageDialog(null, "El usuario ingresado no existe", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
        else if (!username.equals(modeloLogin.getUsername()) || !String.valueOf(password).equals(modeloLogin.getPassword()))
        {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña no coinciden", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            getLogin().setLogueado(true);
            getLogin().setVisible(false);
        }
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("keyTyped: " + e.getKeyChar());
        String username = getLogin().getCajaTextoUsername().getText();
        char[] password = getLogin().getCajaTextoPassword().getPassword();
        
        System.out.println("username: " + username);
        System.out.println("password: " + String.valueOf(password));
        
        if(username != null && !username.trim().isEmpty()
                && password != null && password.length > 3 && username.trim().length() > 3)
        {
            getLogin().getBotonIngresar().setEnabled(true);
        }
        else
        {
            getLogin().getBotonIngresar().setEnabled(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //Nada
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //Nada
    }
}
