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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
    private JComboBox<String> comboRegion = new JComboBox();
    private JComboBox<String> comboComuna = new JComboBox();
    private JTextField cajaTextoTelefono = new JTextField();
    private JTextField cajaTextoEmail = new JTextField();
    private JTextField cajaTextoUsername = new JTextField();
    private JPasswordField cajaTextoPassword = new JPasswordField(); 
    
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
        
        comuna.setBounds(30, 290, 130, 30);
        comuna.setName("cajaTextoComuna");
        comuna.setText("Comuna");
        cp.add(comuna);
        
        comboComuna.setBounds(150, 290, 200, 30);
        comboComuna.setActionCommand("comboComuna");
        comboComuna.setName("comboComuna");
        cp.add(comboComuna);
        
        region.setBounds(30, 250, 130, 30);
        region.setName("cajaTextoRegion");
        region.setText("Región");
        cp.add(region);
        
        comboRegion.setBounds(150, 250, 200, 30);
        comboRegion.setActionCommand("comboRegion");
        comboRegion.setName("comboRegion");
        cp.add(comboRegion);
    
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
        cajaTextoPassword.setName("password: " + String.valueOf(password));
        cp.add(cajaTextoPassword);
        
        aceptar.setBounds(220, 550, 130, 30);
        aceptar.setActionCommand("Aceptar");
        aceptar.setName("Aceptar");
        aceptar.addActionListener(this);
        cp.add(aceptar);
        
        etiqueta.setBounds(50, 500, 250, 30);
        etiqueta.setName("Aceptar");
        cp.add(etiqueta);
        
        comboRegion.addItem("Arica y Parinacota");
        comboRegion.addItem("Tarapacá");
        comboRegion.addItem("Antofagasta");
        comboRegion.addItem("Atacama");
        comboRegion.addItem("Coquimbo");
        comboRegion.addItem("Valparaíso");
        comboRegion.addItem("Metropolitana");
        comboRegion.addItem("OHiggins");
        comboRegion.addItem("Maule");
        comboRegion.addItem("Ñuble");
        comboRegion.addItem("Biobío");
        comboRegion.addItem("Araucanía");
        comboRegion.addItem("Los Ríos");
        comboRegion.addItem("Los Lagos");
        comboRegion.addItem("Aysén");
        comboRegion.addItem("Magallanes");
        comboRegion.setSelectedIndex(-1);
        comboRegion.setName("combo1");

        comboRegion.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String item = (String)e.getItem();
                switch(item)
                {
                    case "Arica y Parinacota": agregarListaACombo(getComunasArica()); break;
                    case "Tarapacá": agregarListaACombo(getComunasTarapaca()); break;
                    case "Antofagasta": agregarListaACombo(getComunasAntofagasta()); break;
                    case "Atacama": agregarListaACombo(getComunasAtacama()); break;
                    case "Coquimbo": agregarListaACombo(getComunasCoquimbo()); break;
                    case "Valparaíso": agregarListaACombo(getComunasValparaiso()); break;
                    case "Metropolitana": agregarListaACombo(getComunasMetropolitana()); break;
                    case "OHiggins": agregarListaACombo(getComunasOHiggins()); break;
                    case "Maule": agregarListaACombo(getComunasMaule()); break;
                    case "Ñuble": agregarListaACombo(getComunasNuble()); break;
                    case "Biobío": agregarListaACombo(getComunasBiobio()); break;
                    case "Araucanía": agregarListaACombo(getComunasAraucania()); break;
                    case "Los Ríos": agregarListaACombo(getComunasLosRios()); break;
                    case "Los Lagos": agregarListaACombo(getComunasLosLagos()); break;
                    case "Aysén": agregarListaACombo(getComunasAysen()); break;
                    case "Magallanes": agregarListaACombo(getComunasMagallanes()); break;
                    default: break;
                }
            }
        });
        
    }
    
    private void agregarListaACombo(ArrayList<String> comunas)
    {
        comboComuna.removeAllItems();
        
        for(String comuna: comunas)
        {
            comboComuna.addItem(comuna);
        }
    }
    
    public ArrayList<String> getComunasArica()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Arica");
        comunas.add("Camarones");
        comunas.add("General Lagos");
        comunas.add("Putre");

        return comunas;
    }
    
    public ArrayList<String> getComunasTarapaca()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Alto Hospicio");
        comunas.add("Camiña");
        comunas.add("Colchane");
        comunas.add("Huara");
        comunas.add("Iquique");
        comunas.add("Pica");
        comunas.add("Pozo Almonte");

        return comunas;
    }
        
    public ArrayList<String> getComunasAntofagasta()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Antofagasta");
        comunas.add("Calama");
        comunas.add("María Elena");
        comunas.add("Mejillones");
        comunas.add("Ollagüe");
        comunas.add("San Pedro de Atacama");
        comunas.add("Sierra Gorda");
        comunas.add("Taltal");
        comunas.add("Tocopilla");

        return comunas;
    }
    
    public ArrayList<String> getComunasAtacama()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Alto del Carmen");
        comunas.add("Caldera");
        comunas.add("Chañaral");
        comunas.add("Copiapó");
        comunas.add("Diego de Almagro");
        comunas.add("Freirina");
        comunas.add("Huasco");
        comunas.add("Tierra Amarilla");
        comunas.add("Vallenar");

        return comunas;
    }
    
    public ArrayList<String> getComunasCoquimbo()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Andacollo");
        comunas.add("Canela");
        comunas.add("Combarbalá");
        comunas.add("Coquimbo");
        comunas.add("Illapel");
        comunas.add("La Higuera");
        comunas.add("La Serena");
        comunas.add("Los Vilos");
        comunas.add("Monte Patria");
        comunas.add("Ovalle");
        comunas.add("Paihuano");
        comunas.add("Punitaqui");
        comunas.add("Salamanca");
        comunas.add("Río Hurtado");
        comunas.add("Vicuña");

        return comunas;
    }
    
    public ArrayList<String> getComunasValparaiso()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Algarrobo");
        comunas.add("Cabildo");
        comunas.add("Calle Larga");
        comunas.add("Cartagena");
        comunas.add("Casablanca");
        comunas.add("Catemu");
        comunas.add("Concón");
        comunas.add("El Quisco");
        comunas.add("El Tabo");
        comunas.add("Hijuelas");
        comunas.add("Isla de Pascua");
        comunas.add("Juan Fernández");
        comunas.add("La Calera");
        comunas.add("La Cruz");
        comunas.add("La Ligua");
        comunas.add("Limache");
        comunas.add("Llay-Llay");
        comunas.add("Los Andes");
        comunas.add("Nogales");
        comunas.add("Olmué");
        comunas.add("Panquehue");
        comunas.add("Papudo");
        comunas.add("Petorca");
        comunas.add("Puchuncaví");
        comunas.add("Putaendo");
        comunas.add("Quillota");
        comunas.add("Quilpué");
        comunas.add("Quintero");
        comunas.add("Rinconada");
        comunas.add("San Antonio");
        comunas.add("San Esteban");
        comunas.add("San Felipe");
        comunas.add("Santa María");
        comunas.add("Santo Domingo");
        comunas.add("Valparaíso");
        comunas.add("Villa Alemana");
        comunas.add("Viña del Mar");
        comunas.add("Zapallar");

        return comunas;
    }
    
    public ArrayList<String> getComunasMetropolitana()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Alhué");
        comunas.add("Buin");
        comunas.add("Calera de Tango");
        comunas.add("Cerrillos");
        comunas.add("Cerro Navia");
        comunas.add("Colina");
        comunas.add("Conchalí");
        comunas.add("Curacaví");
        comunas.add("El Bosque");
        comunas.add("El Monte");
        comunas.add("Estación Central");
        comunas.add("Huechuraba");
        comunas.add("Independencia");
        comunas.add("Isla de Maipo");
        comunas.add("La Cisterna");
        comunas.add("La Granja");
        comunas.add("La Florida");
        comunas.add("La Pintana");
        comunas.add("La Reina");
        comunas.add("Lampa");
        comunas.add("Las Condes");
        comunas.add("Lo Barnechea");
        comunas.add("Lo Espejo");
        comunas.add("Lo Prado");
        comunas.add("Macul");
        comunas.add("Maipú");
        comunas.add("María Pinto");
        comunas.add("Melipilla");
        comunas.add("Ñuñoa");
        comunas.add("Padre Hurtado");
        comunas.add("Paine");
        comunas.add("Pedro Aguirre Cerda");
        comunas.add("Peñaflor");
        comunas.add("Peñalolén");
        comunas.add("Pirque");
        comunas.add("Providencia");
        comunas.add("Pudahuel");
        comunas.add("Puente Alto");
        comunas.add("Quilicura");
        comunas.add("Quinta Normal");
        comunas.add("Recoleta");
        comunas.add("Renca");
        comunas.add("San Bernardo");
        comunas.add("San Miguel");
        comunas.add("San Joaquín");
        comunas.add("San José de Maipo");
        comunas.add("San Pedro");
        comunas.add("San Ramón");
        comunas.add("Santiago");
        comunas.add("Talagante");
        comunas.add("Til Til");
        comunas.add("Vitacura");
 
        return comunas;
    }
    
    public ArrayList<String> getComunasOHiggins()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Chépica");
        comunas.add("Chimbarongo");
        comunas.add("Codegua");
        comunas.add("Coinco");
        comunas.add("Coltauco");
        comunas.add("Doñihue");
        comunas.add("Graneros");
        comunas.add("La Estrella");
        comunas.add("Las Cabras");
        comunas.add("Litueche");
        comunas.add("Lolol");
        comunas.add("Machalí");
        comunas.add("Malloa");
        comunas.add("Marchihue");
        comunas.add("Mostazal");
        comunas.add("Nancagua");
        comunas.add("Navidad");
        comunas.add("Olivar");
        comunas.add("Palmilla");
        comunas.add("Paredones");
        comunas.add("Peralillo");
        comunas.add("Peumo");
        comunas.add("Pichidegua");
        comunas.add("Pichilemu");
        comunas.add("Placilla");
        comunas.add("Pumanque");
        comunas.add("Quinta de Tilcoco");
        comunas.add("Rancagua");
        comunas.add("Rengo");
        comunas.add("Requínoa");
        comunas.add("San Fernando");
        comunas.add("San Vicente de Tagua Tagua");
        comunas.add("Santa Cruz");
              
        return comunas;
    }
    
    public ArrayList<String> getComunasMaule()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Cauquenes");
        comunas.add("Chanco");
        comunas.add("Colbún");
        comunas.add("Constitución");
        comunas.add("Curepto");
        comunas.add("Curicó");
        comunas.add("Empedrado");
        comunas.add("Hualañé");
        comunas.add("Licantén");
        comunas.add("Linares");
        comunas.add("Longaví");
        comunas.add("Maule");
        comunas.add("Molina");
        comunas.add("Parral");
        comunas.add("Pelarco");
        comunas.add("Pelluhue");
        comunas.add("Pencahue");
        comunas.add("Rauco");
        comunas.add("Retiro");
        comunas.add("Río Claro");
        comunas.add("Romeral");
        comunas.add("Sagrada Familia");
        comunas.add("San Clemente");
        comunas.add("San Javier");
        comunas.add("San Rafael");
        comunas.add("Talca");
        comunas.add("Teno");
        comunas.add("Vichuquén");
        comunas.add("Villa Alegre");
        comunas.add("Yerbas Buenas");

        return comunas;
    }
     
    public ArrayList<String> getComunasNuble()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Bulnes");
        comunas.add("Chillán");
        comunas.add("Chillán Viejo");
        comunas.add("Cobquecura");
        comunas.add("Coihueco");
        comunas.add("Coelemu");
        comunas.add("El Carmen");
        comunas.add("Ninhue");
        comunas.add("Ñiquén");
        comunas.add("Pemuco");
        comunas.add("Pinto");
        comunas.add("Portezuelo");
        comunas.add("Quillón");
        comunas.add("Quirihue");
        comunas.add("Ránquil");
        comunas.add("San Carlos");
        comunas.add("San Fabián");
        comunas.add("San Ignacio");
        comunas.add("San Nicolás");
        comunas.add("Treguaco");
        comunas.add("Yungay");

        return comunas;
    }
    
    public ArrayList<String> getComunasBiobio()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Alto Biobío");
        comunas.add("Antuco");
        comunas.add("Arauco");
        comunas.add("Cabrero");
        comunas.add("Cañete");
        comunas.add("Chiguayante");
        comunas.add("Concepción");
        comunas.add("Contulmo");
        comunas.add("Coronel");
        comunas.add("Florida");
        comunas.add("Hualpén");
        comunas.add("Hualqui");
        comunas.add("Laja");
        comunas.add("Lebu");
        comunas.add("Los Álamos");
        comunas.add("Los Ángeles");
        comunas.add("Lota");
        comunas.add("Mulchén");
        comunas.add("Nacimiento");
        comunas.add("Negrete");
        comunas.add("Penco");
        comunas.add("Quilaco");
        comunas.add("Quilleco");
        comunas.add("San Pedro de la Paz");
        comunas.add("San Rosendo");
        comunas.add("Santa Bárbara");
        comunas.add("Santa Juana");
        comunas.add("Talcahuano");
        comunas.add("Tirúa");
        comunas.add("Tomé");
        comunas.add("Tucapel");
        comunas.add("Yumbel");

        return comunas;
    }
    public ArrayList<String> getComunasAraucania()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Angol");
        comunas.add("Carahue");
        comunas.add("Cholchol");
        comunas.add("Collipulli");
        comunas.add("Cunco");
        comunas.add("Curacautín");
        comunas.add("Curarrehue");
        comunas.add("Ercilla");
        comunas.add("Freire");
        comunas.add("Galbarino");
        comunas.add("Gorbea");
        comunas.add("Lautaro");
        comunas.add("Loncoche");
        comunas.add("Lonquimay");
        comunas.add("Los Sauces");
        comunas.add("Lumaco");
        comunas.add("Melipeuco");
        comunas.add("Nueva Imperial");
        comunas.add("Padre Las Casas");
        comunas.add("Perquenco");
        comunas.add("Pitrufquén");
        comunas.add("Pucón");
        comunas.add("Puerto Saavedra");
        comunas.add("Purén");
        comunas.add("Renaico");
        comunas.add("Temuco");
        comunas.add("Teodoro Shmith");
        comunas.add("Toltén");
        comunas.add("Traiguén");
        comunas.add("Victoria");
        comunas.add("Vilcún");
        comunas.add("Villarrica");
        
        return comunas;
    }
    public ArrayList<String> getComunasLosRios()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Corral");
        comunas.add("Futrono");
        comunas.add("La Unión");
        comunas.add("Lago Ranco");
        comunas.add("Lanco");
        comunas.add("Los Lagos");
        comunas.add("Máfil");
        comunas.add("Mariquina");
        comunas.add("Paillaco");
        comunas.add("Panguipulli");
        comunas.add("Río Bueno");
        comunas.add("Valdivia");
        
        return comunas;
    }
    public ArrayList<String> getComunasLosLagos()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Ancud");
        comunas.add("Calbuco");
        comunas.add("Castro");
        comunas.add("Chaitén");
        comunas.add("Chonchi");
        comunas.add("Cochamó");
        comunas.add("Curaco de Vélez");
        comunas.add("Dalcahue");
        comunas.add("Fresia");
        comunas.add("Frutillar");
        comunas.add("Futaleufú");
        comunas.add("Hualaihué");
        comunas.add("Llanquihue");
        comunas.add("Los Muermos");
        comunas.add("Maullín");
        comunas.add("Osorno");
        comunas.add("Palena");
        comunas.add("Puerto Montt");
        comunas.add("Puerto Octay");
        comunas.add("Puerto Varas");
        comunas.add("Puqueldón");
        comunas.add("Purranque");
        comunas.add("Puyehue");
        comunas.add("Queilén");
        comunas.add("Quemchi");
        comunas.add("Quellón");
        comunas.add("Quinchao");
        comunas.add("Río Negro");
        comunas.add("San Juan de la Costa");
        comunas.add("San Pablo");
        
        return comunas;
    }
    public ArrayList<String> getComunasAysen()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Aysén");
        comunas.add("Chile Chico");
        comunas.add("Cisnes");
        comunas.add("Cochrane");
        comunas.add("Coyhaique");
        comunas.add("Guaitecas");
        comunas.add("Lago Verde");
        comunas.add("O'Higgins");
        comunas.add("Río Ibáñez");
        comunas.add("Tortel");

        return comunas;
    }
    public ArrayList<String> getComunasMagallanes()
    {
        ArrayList<String> comunas = new ArrayList();
        comunas.add("Antártica");
        comunas.add("Cabo de Hornos");
        comunas.add("Laguna Blanca");
        comunas.add("Natales");
        comunas.add("Porvenir");
        comunas.add("Primavera");
        comunas.add("Punta Arenas");
        comunas.add("Río Verde");
        comunas.add("San Gregorio");
        comunas.add("Timaukel");
        comunas.add("Torres del Paine");

        return comunas;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        
        if(comando.equals("Aceptar"))
        {
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente(nombre, apellidoPaterno, apellidoMaterno, rut, dv, direccion, comuna, region, telefono, email)"+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

                ps.setString(1, cajaTextoNombre.getText());
                ps.setString(2, cajaTextoApellidoPaterno.getText());
                ps.setString(3, cajaTextoApellidoMaterno.getText());
                ps.setString(4, cajaTextoRut.getText());
                ps.setString(5, cajaTextoDv.getText());
                ps.setString(6, cajaTextoDireccion.getText());
                ps.setString(7, (String)comboComuna.getSelectedItem());
                ps.setString(8, (String)comboRegion.getSelectedItem());
                ps.setString(9, cajaTextoTelefono.getText());
                ps.setString(10, cajaTextoEmail.getText());
                ps.executeUpdate();
                
                String aceptar = "¡Datos guardados exitosamente!";
                etiqueta.setText(aceptar);
                JOptionPane.showMessageDialog(null, aceptar);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
        



