package PresentacioCLUB;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Aplicacio.ControlBBDD;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 434, Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGap(0, 261, Short.MAX_VALUE));
		frame.getContentPane().setLayout(groupLayout);

		String[] columnNames = { "Nom", "Cognom", "2n Cognom", "Equip", "Posicio", "T. Grogues", "T. Vermelles",
				"Partits jugats" };

		try {
			String[] jugadors = controlBBDD.getJugadorsDeEquip(string);
			for (int i = 0; i < jugadors.length; i++) {
				System.out.println(jugadors[i]);
			}
			int i = jugadors.length;

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
			// Create the scroll pane and add the table to it.
			JScrollPane scrollPane = new JScrollPane(table);

			// Add the scroll pane to this panel.
			frame.setContentPane(scrollPane);
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
