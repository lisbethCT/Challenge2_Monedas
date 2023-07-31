package conversor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.sound.sampled.Line;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.InlineView;

public class ConversorGrafico extends JFrame{

	private JComboBox cbMostrar;
	private String [] opciones={"Conversor de Monedas",
			"Conversor de Temperatura","Salir"};
	
	private JPanel panel;
	private JPanel pContenedor;
	private JButton btnSeleccionar;

	public ConversorGrafico() {
		setSize(500,300);
		setTitle("Conversor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		IniciarPanelPrincipal();
		
	}

	public void IniciarPanelPrincipal() {
		panel=new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(null);
		
		pContenedor=new JPanel();
		pContenedor.setBounds(10,40,460,210);
		pContenedor.setLayout(null);
		panel.setLayout(null);
		
		btnSeleccionar=new JButton("Seleccionar");
		btnSeleccionar.setBounds(270, 10, 150, 20);

		cbMostrar = new JComboBox(opciones);
		cbMostrar.setBounds(20,10,200,20);
		
		btnSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int caso=cbMostrar.getSelectedIndex();
				switch(caso) {
				case 0:
					MonedasView monedasView=new MonedasView();
					iniciarPaenlMonedas(monedasView);
					break;
				case 1:
					TemperaturaView temperaturaView=new TemperaturaView();
					iniciarPaenlMonedas(temperaturaView);
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "Saliendo del programa");
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Seleccione una opcion valida");
					break;
				}
				
			}
		});
		
		this.getContentPane().add(panel);
		
		panel.add(cbMostrar);
		panel.add(btnSeleccionar);
		panel.add(pContenedor);
	}
	
	public void iniciarPaenlMonedas(JPanel p) {
		p.setSize(460,210);
		p.setLocation(0,0);
		
		pContenedor.removeAll();
		pContenedor.add(p,BorderLayout.CENTER);
		pContenedor.revalidate();
		pContenedor.repaint();
	}
	/*
    public void itemStateChanged(ItemEvent e) {

        String texto = "Color seleccionado:  ";

        if (e.getSource() == cbMostrar) {
            String seleccionado=(String)cbMostrar.getSelectedItem();
            texto += seleccionado;
            respuesta.setText(texto);
        }

    }
*/
	public static void main(String[] args) {
		ConversorGrafico cg = new ConversorGrafico();
		cg.setVisible(true);
		
	}

}
