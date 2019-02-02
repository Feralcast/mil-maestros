/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.vista.impl;

import milmaestros.vista.Ventana;
import milmaestros.vista.panels.BackgroundPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import milmaestros.EleccionMaestro;
import milmaestros.RegistroClientes;
import milmaestros.RegistroEleccion;

/**
 *
 * @author 1000Programadores PM
 */
public final class VentanaPrincipal extends Ventana
{
    private JLabel etiquetaBienvenida;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JPanel panelEste;
    private JPanel panelOeste;
    private JTabbedPane panelDePestanas;
    private JPanel panelInicio;
    
    private JToolBar barraDeHerramientas;
    private JButton botonLogin;
    private JButton botonRegistro;
    private JButton botonBusqueda;
    
    private static final Font FUENTE_PESTANA = new Font("Verdana", Font.BOLD, 12);

    public VentanaPrincipal()
    {
        super("Mil Maestros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(getPanelDePestanas(), BorderLayout.CENTER);
        cp.add(getPanelNorte(), BorderLayout.NORTH);
        cp.add(getPanelSur(), BorderLayout.SOUTH);
        cp.add(getPanelEste(), BorderLayout.EAST);
        cp.add(getPanelOeste(), BorderLayout.WEST);
    }

    public JLabel getEtiquetaBienvenida()
    {
        if (etiquetaBienvenida == null)
        {
            etiquetaBienvenida = new JLabel(" ");
            etiquetaBienvenida.setBounds(0,30,200,10);
    
        }
        return etiquetaBienvenida;
    }

    public JPanel getPanelInicio()
    {
        if (panelInicio == null)
        {
            try
            {
                Image bgImagen = ImageIO.read(new File("resources/imagenes/bg/wp2224998.jpg"));
                panelInicio = new BackgroundPanel(bgImagen, BackgroundPanel.ACTUAL);
                ((BackgroundPanel)panelInicio).setImageAlignmentX(0);
                ((BackgroundPanel)panelInicio).setImageAlignmentY(0);
                panelInicio.add(getBotonBusqueda());
            }
            catch (IOException ex)
            {
                panelInicio = new JPanel();
            }

            panelInicio.add(getEtiquetaBienvenida());
        }
        return panelInicio;
    }
    
    public JTabbedPane getPanelDePestanas()
    {
        if (panelDePestanas == null)
        {
            panelDePestanas = new JTabbedPane();
            panelDePestanas.add(getPanelInicio(), 0);
            panelDePestanas.setName("panelDePestanas");
            panelDePestanas.setTitleAt(0, "Inicio");
            panelDePestanas.setIconAt(0, new ImageIcon("resources/imagenes/home_page.png"));
            panelDePestanas.setFont(FUENTE_PESTANA);
        }
        return panelDePestanas;
    }

    public JPanel getPanelNorte()
    {
        if (panelNorte == null)
        {
            GridLayout gl = new GridLayout(1, 1);
            gl.setHgap(5);
            gl.setVgap(5);
            panelNorte = new JPanel();
            panelNorte.setLayout(gl);
            panelNorte.setSize(getContentPane().getWidth(), 200);
            panelNorte.setLocation(0, 0);
            panelNorte.add(getBarraDeHerramientas());
        }
        return panelNorte;
    }

    public JPanel getPanelSur()
    {
        if (panelSur == null)
        {
            panelSur = new JPanel();
        }
        return panelSur;
    }

    public JPanel getPanelEste()
    {
        if (panelEste == null)
        {
            panelEste = new JPanel();
        }
        return panelEste;
    }

    public JPanel getPanelOeste()
    {
        if (panelOeste == null)
        {
            panelOeste = new JPanel();
        }
        return panelOeste;
    }

    public JToolBar getBarraDeHerramientas()
    {
        if(barraDeHerramientas == null)
        {
            barraDeHerramientas = new JToolBar("barraPrincipal");
            barraDeHerramientas.setBounds(0, 0, getPanelNorte().getWidth(), getPanelNorte().getHeight());
            barraDeHerramientas.add(getBotonLogin());
            barraDeHerramientas.add(getBotonRegistro());
        }
        return barraDeHerramientas;
    }

    public JButton getBotonLogin()
    {
        if(botonLogin == null)
        {
            botonLogin = new JButton();
            botonLogin.setName("botonLogin");
            botonLogin.setActionCommand("botonLogin");
            botonLogin.setText("");
            botonLogin.setToolTipText("Login");
            botonLogin.setIcon(new ImageIcon("resources/imagenes/login.jpg"));
            botonLogin.setSize(32, 32);
            botonLogin.setLocation(0, 0);
        }
        botonLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource()==botonLogin)
                {
                Login log = new Login();
                log.setVisible(true); 
                }
            }
            });
        return botonLogin;
    }

    public JButton getBotonRegistro()
    {
        if(botonRegistro == null)
        {
            botonRegistro = new JButton();
            botonRegistro.setName("botonRegistro");
            botonRegistro.setActionCommand("botonRegistro");
            botonRegistro.setText("");
            botonRegistro.setToolTipText("Registrarse");
            botonRegistro.setIcon(new ImageIcon("resources/imagenes/registro.png"));
            botonRegistro.setSize(32, 32);
            botonRegistro.setLocation(64, 0);
        }
        
        botonRegistro.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource()==botonRegistro)
                {
                RegistroEleccion  re = new RegistroEleccion();
                re.setVisible(true); 
                }
            }
            });
        return botonRegistro;
              
    }
    
    public JButton getBotonBusqueda()
    {
        if(botonBusqueda == null)
        {
            botonBusqueda = new JButton();
            botonBusqueda.setName("botonBusqueda");
            botonBusqueda.setActionCommand("botonBusqueda");
            botonBusqueda.setText("");
            botonBusqueda.setToolTipText("Haz click para buscar un Maestro");
            botonBusqueda.setIcon(new ImageIcon("resources/imagenes/bg/click.png"));
            botonBusqueda.setSize(426, 128);
            botonBusqueda.setLocation(750, 50);
        }
        
        botonBusqueda.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource()==botonBusqueda)
                {
                EleccionMaestro  em = new EleccionMaestro();
                em.setVisible(true); 
                }
            }
            });
        return botonBusqueda;
    }    
}
   

