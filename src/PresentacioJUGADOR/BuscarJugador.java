package PresentacioJUGADOR;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Aplicacio.ControlBBDD;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BuscarJugador {

	private JFrame frame;
	private JTextField nomJugador;
	private JLabel lblNom;
	private JLabel lblNewLabel;
	private JTextField cognomJugador;
	private JButton btnBuscar;
	private JButton btnNewButton;
	private JLabel lblERROR;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
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

		lblERROR = new JLabel(" ");
		lblERROR.setHorizontalAlignment(SwingConstants.CENTER);
		lblERROR.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblInsereixElNom = new JLabel("Insereix el nom del jugado que vols buscar");
		lblInsereixElNom.setFont(new Font("Tahoma", Font.PLAIN, 14));

		nomJugador = new JTextField();
		nomJugador.setColumns(10);

		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel = new JLabel("Cognom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cognomJugador = new JTextField();
		cognomJugador.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// frame.dispose();
				if ((nomJugador.getText().equals("")) && (cognomJugador.getText().equals(""))) {
					lblERROR.setText("Introdueix com a minim un nom i/o un congnom per realitzar la cerca");
					lblERROR.setForeground(Color.RED);
				} else {
					frame.dispose();
					new ResultatBuscarJugador(controlBBDD, nomJugador.getText(), cognomJugador.getText());
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnNewButton = new JButton("Tronar pantalla anterior");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ConsultarJugador(controlBBDD);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(80)
												.addComponent(lblInsereixElNom, GroupLayout.DEFAULT_SIZE, 274,
														Short.MAX_VALUE)
												.addGap(46))
										.addGroup(
												groupLayout.createSequentialGroup().addGap(22)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNewLabel).addComponent(lblNom))
														.addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(nomJugador, GroupLayout.PREFERRED_SIZE,
																		307, GroupLayout.PREFERRED_SIZE)
																.addComponent(cognomJugador, 307, 307, 307))))
								.addGap(34))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(152, Short.MAX_VALUE)
								.addComponent(btnNewButton).addGap(135))
						.addGroup(groupLayout.createSequentialGroup().addGap(184).addComponent(btnBuscar).addGap(185))
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblERROR, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26).addComponent(lblInsereixElNom).addGap(39)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNom).addComponent(
						nomJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						cognomJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblERROR).addGap(5).addComponent(btnBuscar)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton)
				.addContainerGap(31, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}

}
