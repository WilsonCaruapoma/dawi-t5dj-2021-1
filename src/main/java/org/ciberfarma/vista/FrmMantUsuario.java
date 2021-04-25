package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantUsuario frame = new FrmMantUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMantUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manenimiento de  Usuarios:");
		lblNewLabel.setBounds(10, 11, 180, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setBounds(10, 111, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido:");
		lblNewLabel_4.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Clave:");
		lblNewLabel_5.setBounds(10, 136, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha:");
		lblNewLabel_6.setBounds(10, 161, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setBounds(10, 186, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Estado:");
		lblNewLabel_8.setBounds(10, 211, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(56, 33, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(56, 58, 121, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(56, 83, 121, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(56, 108, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JTextField();
		txtClave.setBounds(56, 133, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(56, 158, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(56, 183, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(56, 211, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setBounds(287, 32, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(287, 57, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(287, 82, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar();
			}
		});
		btnConsultar.setBounds(287, 107, 89, 23);
		contentPane.add(btnConsultar);
	}
	
	void Consultar() {
		
		// grabar el objeto
		// 1. fabricar el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Consulta
		Usuario u =em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		if(u!=null) {
		txtNombre.setText(u.getNombre());
		txtApellido.setText(u.getNombre());
		}else {
			JOptionPane.showMessageDialog(this, "Usuario con codigo no existe");
			}
	em.close();
	fabrica.close();
	}


		
void registrar() {
		// grabar el objeto
		// 1. fabricar el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		//u.setCodigo(10);el ID Codigo es AUTO_INCREMENT
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		
		u.setTipo(Integer.parseInt(txtTipo.getText())); 
	   u.setEstado(Integer.parseInt(txtEstado.getText())); 
		
		// 3. empezar mi transacci�n
				em.getTransaction().begin();
                em.persist(u);
			    em.getTransaction().commit();
	    //--cerrar
			    em.close();
			    fabrica.close();
		
	}
}
