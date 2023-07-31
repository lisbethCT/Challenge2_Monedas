package conversor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MonedasView extends JPanel {
	private JTextField txtRespuesta;
	private JLabel txtRespuestaComplemento;
	private JComboBox cbMostrar;
	private JButton btnSeleccionar;
	private JTextField txtCantidad;
	private String[] opciones = { "Seleccione una opción", 
			"1-Convertir de Quetzal a Dólar",
			"2-Convertir de Quetzal a Euros", 
			"3-Convertir de Quetzal a Libras Esterlinas",
			"4-Convertir de Quetzal a Yen Japonés", 
			"5-Convertir de Quetzal a Won sur-coreano",
			"6-Convertir de Dólar a Quetzal", 
			"7-Convertir de Euros a Quetzal",
			"8-Convertir de Libras Esterlinas a Quetzal", 
			"9-Convertir de Yen Japonés a Quetzal",
			"10-Convertir de Won sur-coreano a Quetzal" };

	private double dolar = 1 / 7.85;
	private double euro = 1 / 8.57;
	private double librasEsterlinas = 1 / 9.97;
	private double yen = 1 / 0.054;
	private double won = 1 / 0.0060;

	public MonedasView() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setBounds(10, 40, 460, 210);
		inciarComponentes();
	}

	void inciarComponentes() {
		JLabel lbInstrucciones = new JLabel("Acontinuación, ingrese la cantidad a convertir");
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

	public void calcularrBoton() {

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
						Conversores.ConvertirMoneda(dolar, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 2:
						Conversores.ConvertirMoneda(euro, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 3:
						Conversores.ConvertirMoneda(librasEsterlinas, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 4:
						Conversores.ConvertirMoneda(yen, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 5:
						Conversores.ConvertirMoneda(won, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 6:
						Conversores.ConvertirMoneda(dolar * 1, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 7:
						Conversores.ConvertirMoneda(euro * 1, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 8:
						Conversores.ConvertirMoneda(librasEsterlinas * 1, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 9:
						Conversores.ConvertirMoneda(yen * 1, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
						break;
					case 10:
						Conversores.ConvertirMoneda(won * 1, txtCantidad, txtRespuesta);
						txtRespuestaComplemento.setText(cbMostrar.getSelectedItem().toString());
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
