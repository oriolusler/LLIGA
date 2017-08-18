package PresentacioCLUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConsultarEquip {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ConsultarEquip(ControlBBDD controlBBDD) {
		initialize(controlBBDD);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize(ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		try {
			list.setModel(new AbstractListModel() {
				String[] values = controlBBDD.recuperarClubs();

				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblEscullUnEquip = new JLabel("ESCULL UN EQUIP PER CONSULTAR ESTADISTIQUES I/O JUGADORS");
		lblEscullUnEquip.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new pantallaClub(list.getSelectedValue().toString());
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblEscullUnEquip)
					.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(215, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(197))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblEscullUnEquip)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
