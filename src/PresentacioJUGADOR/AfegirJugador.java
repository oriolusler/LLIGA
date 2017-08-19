package PresentacioJUGADOR;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;
import Domini.Posicions;

import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AfegirJugador {

	private JFrame frame;
	private JTextField FNom;
	private JTextField FCONGNOM1;
	private JTextField FCONGNOM2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AfegirJugador(ControlBBDD controlBBDD) {
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
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox comboBoxEquips = new JComboBox();
		try {
			String[] clubs = controlBBDD.recuperarClubs();
			comboBoxEquips.setModel(new DefaultComboBoxModel(clubs));

			JComboBox comboBoxoscions = new JComboBox();

			JButton afegir = new JButton("Afegir Jugador");
			JLabel lblAfageixLesDades = new JLabel("Afageix les dades per afegir el jugador");
			lblAfageixLesDades.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblNom = new JLabel("Nom");
			lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel labelCog1 = new JLabel("1. Cognom");
			labelCog1.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblCognom = new JLabel("2. Cognom");
			lblCognom.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblClubActual = new JLabel("Club actual");
			lblClubActual.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JLabel lblPosicio = new JLabel("Posicio");
			lblPosicio.setFont(new Font("Tahoma", Font.PLAIN, 14));

			FNom = new JTextField();
			FNom.setColumns(10);

			FCONGNOM1 = new JTextField();
			FCONGNOM1.setColumns(10);

			FCONGNOM2 = new JTextField();
			FCONGNOM2.setColumns(10);

			JButton btnNewButton = new JButton("Torner pantalla anterior");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});

			afegir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						 controlBBDD.afegirJugador(FNom.getText(), FCONGNOM1.getText(),
						 FCONGNOM2.getText(),
						 comboBoxEquips.getSelectedItem().toString(),
						 comboBoxoscions.getSelectedItem().toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

			comboBoxoscions.setModel(new DefaultComboBoxModel(new String[] { Posicions.POT.name(), Posicions.DF.name(),
					Posicions.MC.name(), Posicions.DL.name() }));
			comboBoxoscions.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
					.createSequentialGroup().addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
							.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNom)
									.addComponent(labelCog1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblCognom, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblClubActual, GroupLayout.PREFERRED_SIZE, 86,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPosicio, GroupLayout.PREFERRED_SIZE, 86,
											GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(afegir)
									.addComponent(comboBoxoscions, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxEquips, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(FCONGNOM2).addComponent(FNom).addComponent(FCONGNOM1)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE))
							.addContainerGap(139, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup().addComponent(lblAfageixLesDades)
									.addContainerGap(170, Short.MAX_VALUE)))));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
					.createSequentialGroup().addContainerGap().addComponent(lblAfageixLesDades).addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNom).addComponent(
							FNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelCog1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(FCONGNOM1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCognom, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(FCONGNOM2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblClubActual, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBoxEquips, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPosicio, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBoxoscions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addComponent(afegir)
					.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton).addGap(18)));
			frame.getContentPane().setLayout(groupLayout);

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
}
