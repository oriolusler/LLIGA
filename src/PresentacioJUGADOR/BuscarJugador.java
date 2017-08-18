package PresentacioJUGADOR;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Aplicacio.ControlBBDD;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class BuscarJugador {

	private JFrame frame;
	private JTextField nomJugador;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @param controlBBDD 
	 */
	public BuscarJugador(ControlBBDD controlBBDD) {
		initialize(controlBBDD);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInsereixElNom = new JLabel("Insereix el nom del jugado que vols buscar");
		lblInsereixElNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		nomJugador = new JTextField();
		nomJugador.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(lblInsereixElNom, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(nomJugador)
					.addGap(43))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblInsereixElNom)
					.addGap(36)
					.addComponent(nomJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
