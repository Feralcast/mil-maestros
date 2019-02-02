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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author carlo
 */
public class RegionComuna extends JFrame 
{
    JComboBox<String> combo1 = new JComboBox();
    JComboBox<String> combo2 = new JComboBox();
        
    public RegionComuna()
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
        
        
        combo1.addItem("Metropolitana");
        combo1.addItem("Valparaíso");
        combo1.setSelectedIndex(-1);
        combo1.setName("combo1");
        combo1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String item = (String)e.getItem();
                switch(item)
                {
                    case "Metropolitana": agregarListaACombo(getComunasMetropolitana()); break;
                    case "Valparaíso": agregarListaACombo(getComunasValparaiso()); break;
                    default: break;
                }
            }
        });
        
        cp.add(combo1);
        cp.add(combo2);
    }
    
    private void agregarListaACombo(ArrayList<String> comunas)
    {
        combo2.removeAllItems();
        
        for(String comuna: comunas)
        {
            combo2.addItem(comuna);
        }
    }
    
    public ArrayList<String> getComunasMetropolitana()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Santiago");
        comunas.add("Providencia");
        comunas.add("Estación Central");
        comunas.add("Recoleta");
        comunas.add("Independencia");
        comunas.add("La Florida");
        comunas.add("Lampa");
        comunas.add("Colina");
        comunas.add("Las Condes");
        comunas.add("Vitacura");
        comunas.add("Puente Alto");
        comunas.add("Macul");
        comunas.add("San Miguel");
        comunas.add("La Cisterna");
        comunas.add("La Granja");
        comunas.add("Maipú");
        comunas.add("Talagante");
        comunas.add("Melipilla");
        comunas.add("Cerro Navia");
        comunas.add("Peñalolén");
        comunas.add("Pudahuel");
        comunas.add("Quinta Normal");
        comunas.add("Padre Hurtado");
        comunas.add("Lo Prado");
        comunas.add("Vitacura");
        comunas.add("La Pintana");
        comunas.add("Lo Barnechea");
        comunas.add("El Bosque");
        comunas.add("Conchalí");
        comunas.add("Pedro Aguirre Cerda");
        comunas.add("La Reina");
        comunas.add("Cerrillos");
        comunas.add("Pirque");
        
        return comunas;
    }
    
    public ArrayList<String> getComunasValparaiso()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Valparaíso");
        comunas.add("Viña del Mar");
        comunas.add("Quilpué");
        comunas.add("Limache");
        comunas.add("Olmué");
        comunas.add("San Antonio");
        comunas.add("Cartagena");
        comunas.add("La Ligua");
        comunas.add("Villa Alemana");
        comunas.add("San Antonio");
        comunas.add("Algarrobo");
        comunas.add("San Felipe");
        comunas.add("Los Andes");
        comunas.add("Quillota");
        comunas.add("La Calera");

        return comunas;
    }
}