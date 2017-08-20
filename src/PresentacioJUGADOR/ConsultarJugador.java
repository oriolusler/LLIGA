package PresentacioJUGADOR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import Aplicacio.ControlBBDD;
import Presentacio.PANTALLA;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarJugador {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ConsultarJugador(ControlBBDD controlBBDD) {
		initialize(controlBBDD);
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param controlBBDD
	 */
	private void initialize(ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton nuscarjugador = new JButton("Buscar jugador");
		nuscarjugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BuscarJugador(controlBBDD);
			}
		});

		JButton btnNewButton_1 = new JButton("Afegir Jugador");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AfegirJugador(controlBBDD);
			}
		});

		JButton btnTornarPantallaAnterior = new JButton("Tornar pantalla anterior");
		btnTornarPantallaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PANTALLA(controlBBDD);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(56)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnTornarPantallaAnterior)
						.addComponent(btnNewButton_1).addComponent(nuscarjugador))
				.addContainerGap(273, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(82).addComponent(nuscarjugador).addGap(18)
						.addComponent(btnNewButton_1).addGap(27).addComponent(btnTornarPantallaAnterior)
						.addContainerGap(65, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}

}
