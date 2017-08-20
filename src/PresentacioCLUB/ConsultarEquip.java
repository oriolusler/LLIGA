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
import javax.swing.SwingConstants;

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
		frame.setBounds(100, 100, 507, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblError = new JLabel("");
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
				if (list.getSelectedValue() == null) {
					lblError.setText("Escull un equip per continuar!");
					lblError.setForeground(Color.RED);
				} else {
					frame.dispose();
					new pantallaClub(list.getSelectedValue().toString(), controlBBDD);
				}
			}
		});

		JButton btnTornarPantallaAnterior = new JButton("Tornar pantalla anterior");
		btnTornarPantallaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BuscarClub(controlBBDD);
			}
		});

		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(46).addComponent(lblEscullUnEquip)
						.addContainerGap(21, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(106, Short.MAX_VALUE)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE).addGap(73))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(184, Short.MAX_VALUE)
						.addComponent(btnTornarPantallaAnterior).addGap(160))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(215, Short.MAX_VALUE)
						.addComponent(btnNewButton).addGap(197))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblError, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(lblEscullUnEquip).addGap(18)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblError)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton).addGap(18).addComponent(btnTornarPantallaAnterior).addGap(21)));
		frame.getContentPane().setLayout(groupLayout);
	}

}
