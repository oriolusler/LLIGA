package Presentacio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;
import PresentacioCLUB.BuscarClub;
import PresentacioJUGADOR.BuscarJugador;
import PresentacioJUGADOR.ConsultarJugador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PANTALLA {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @param controlBBDD 
	 */
	public PANTALLA(ControlBBDD controlBBDD) {
		initialize(controlBBDD);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("");
		
		JButton butJUGADOR = new JButton("BUSCAR JUGADOR");
		butJUGADOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ConsultarJugador(controlBBDD);
			}
		});
		
		JButton butCLUB = new JButton("BUSCAR CLUB");
		
		butCLUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new BuscarClub(controlBBDD);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(butCLUB, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(butJUGADOR)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(butJUGADOR)
						.addComponent(butCLUB))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
