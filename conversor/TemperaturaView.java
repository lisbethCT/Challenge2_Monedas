package conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperaturaView extends JPanel{
	private JLabel txtRespuestaComplemento;
	private JTextField txtRespuesta;
	private JComboBox cbMostrar;
	private JButton btnSeleccionar;
	private JTextField txtCantidad;
	private String[] opciones = { "Seleccione una opción", 
			"1-Convertir de °C a °F",
			"2-Convertir de °F a °C"};

	
	
	public TemperaturaView() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(10,40,460,210);
		inciarComponentes();	
	}
	
	void inciarComponentes() {
		JLabel lbInstrucciones = new JLabel("Acontinuación, ingrese los grados a convertir");
		lbInstrucciones.setBounds(10, 10, 280, 20);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(300, 10, 150, 20);

		cbMostrar = new JComboBox(opciones);
		cbMostrar.setBounds(10, 40, 280, 20);

		btnSeleccionar = new JButton("Convertir");
		btnSeleccionar.setBounds(300, 40, 150, 20);
		
		txtRespuestaComplemento=new JLabel();
		txtRespuestaComplemento.setBounds(10, 100, 150, 30);
		txtRespuestaComplemento.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtRespuesta = new JTextField();
		txtRespuesta.setBounds(300, 100, 150, 30);
		txtRespuesta.setBorder(BorderFactory.createLineBorder(Color.black));
		txtRespuesta.setEditable(false);
		txtRespuesta.setFont(new Font("Serif", Font.ITALIC, 18));
		txtRespuesta.setHorizontalAlignment(txtRespuesta.CENTER);

		calcularrBoton();
		num(txtCantidad);

		add(lbInstrucciones);
		add(txtCantidad);
		add(cbMostrar);
		add(btnSeleccionar);
		add(txtRespuesta);
		add(txtRespuestaComplemento);
	}

	private void calcularrBoton() {
		btnSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtCantidad.getText().equals("")) {
					mensaje("Debe ingresar una cantidad correcta");
					txtCantidad.setFocusable(true);
				} else {
					int caso = cbMostrar.getSelectedIndex();
					switch (caso) {
					case 1:
						Conversores.ConvertirTemperatura("F", txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(opciones[1]);
						System.out.println(opciones[1]);
						break;
					case 2:
						Conversores.ConvertirTemperatura("C", txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(opciones[2]);
						System.out.println(opciones[2]);
						break;
					default:
						mensaje("Seleccione una opcion valida");
						break;
					}
				}
			}
		});
		
	}
	
	public void mensaje(String msj) {
		JOptionPane.showMessageDialog(null, msj);

	}

	public void num(JTextField cant) {
		cant.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume();
				}
				if (c == '.' && txtCantidad.getText().contains(".")) {
					e.consume();
				}
			}
		});
	}
}
