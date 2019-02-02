/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milmaestros.vista.impl;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class MiVentana extends JFrame 
{
    JComboBox<String> combo1 = new JComboBox();
    JComboBox<String> combo2 = new JComboBox();
        
    public MiVentana()
    {
        super("Titulo de ventana");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        JLabel etiqueta = new JLabel("Nombre: ");
        JTextField texto = new JTextField(20);
        JButton boton = new JButton("Saludar");
        cp.add(etiqueta);
        cp.add(texto);
        cp.add(boton);
        boton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Hola " + texto.getText());
            }
        });
        
        
        combo1.addItem("Chile");
        combo1.addItem("Argentina");
        combo1.addItem("Brasil");
        combo1.setSelectedIndex(-1);
        combo1.setName("combo1");
        combo1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String item = (String)e.getItem();
                switch(item)
                {
                    case "Chile": agregarListaACombo(getCiudadesChile()); break;
                    case "Argentina": agregarListaACombo(getCiudadesArgentina()); break;
                    case "Brasil": agregarListaACombo(getCiudadesBrasil()); break;
                    default: break;
                }
            }
        });
        
        cp.add(combo1);
        cp.add(combo2);
    }
    
    private void agregarListaACombo(ArrayList<String> ciudades)
    {
        combo2.removeAllItems();
        
        for(String ciudad: ciudades)
        {
            combo2.addItem(ciudad);
        }
    }
    
    public ArrayList<String> getCiudadesChile()
    {
        ArrayList<String> ciudades = new ArrayList();
        ciudades.add("Santiago");
        ciudades.add("Valparaiso");
        ciudades.add("Rancagua");
        return ciudades;
    }
    
    public ArrayList<String> getCiudadesArgentina()
    {
        ArrayList<String> ciudades = new ArrayList();
        ciudades.add("Mendoza");
        ciudades.add("Buenos Aires");
        ciudades.add("Bariloche");
        return ciudades;
    }
    public ArrayList<String> getCiudadesBrasil()
    {
        ArrayList<String> ciudades = new ArrayList();
        ciudades.add("Rio de Janeiro");
        ciudades.add("Sao Paulo");
        ciudades.add("Florianopolis");
        return ciudades;
    }
}

