package PresentacioCLUB;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Aplicacio.ControlBBDD;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pantallaClub {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @param string
	 */
	public pantallaClub(String string, ControlBBDD controlBBDD) {

		initialize(string, controlBBDD);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param string
	 * @param controlBBDD
	 */
	private void initialize(String string, ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] columnNames = { "Nom", "Cognom", "2n Cognom", "Equip", "Posicio", "T. Grogues", "T. Vermelles",
				"Partits jugats" };

		try {
			String[] jugadors = controlBBDD.getJugadorsDeEquip(string);
			Object[][] data = new Object[jugadors.length][columnNames.length];

			for (int i1 = 0; i1 < jugadors.length; i1++) {

				String[] parts = jugadors[i1].split(",");

				data[i1][0] = parts[0];
				data[i1][1] = parts[1];
				data[i1][2] = parts[2];
				data[i1][3] = parts[3];
				data[i1][4] = parts[4];
				data[i1][5] = parts[5];
				data[i1][6] = parts[6];
				data[i1][7] = parts[7];

			}

			final JTable table = new JTable(data, columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);

			JScrollPane scrollPane = new JScrollPane(table);

			JButton btnTornarPantallaAnterior = new JButton("Tornar pantalla anterior");
			btnTornarPantallaAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new ConsultarEquip(controlBBDD);
				}
			});
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout
					.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup().addGap(33)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 511,
											GroupLayout.PREFERRED_SIZE)
									.addContainerGap(34, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING,
									groupLayout.createSequentialGroup().addContainerGap(230, Short.MAX_VALUE)
											.addComponent(btnTornarPantallaAnterior).addGap(201)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(btnTornarPantallaAnterior).addContainerGap()));
			frame.getContentPane().setLayout(groupLayout);

			// Create the scroll pane and add the table to it.
			// JScrollPane scrollPane = new JScrollPane(table);

			// Add the scroll pane to this panel.
			// frame.setContentPane(scrollPane);
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
