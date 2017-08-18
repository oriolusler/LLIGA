package PresentacioCLUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarClub {

	private JFrame frame;

	/**
	 * Launch the application.
	 * 
	 * @param controlBBDD
	 */

	public BuscarClub(ControlBBDD controlBBDD) {

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

		JButton butINSERIREQUIP = new JButton("INSERIR NOU EQUIP");
		butINSERIREQUIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AfegirEquip(controlBBDD);
			}
		});

		JButton butCONSULTAREQUI = new JButton("CONSULTAR EQUIP");
		butCONSULTAREQUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ConsultarEquip(controlBBDD);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(48).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(butINSERIREQUIP).addComponent(butCONSULTAREQUI))
						.addContainerGap(253, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(73).addComponent(butCONSULTAREQUI).addGap(31)
						.addComponent(butINSERIREQUIP).addContainerGap(111, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}

}
