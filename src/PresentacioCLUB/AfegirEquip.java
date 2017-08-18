package PresentacioCLUB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfegirEquip {

	private JFrame frame;
	private JTextField nomEquip;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param controlBBDD 
	 */
	public AfegirEquip(ControlBBDD controlBBDD) {
		initialize(controlBBDD);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ControlBBDD controlBBDD) {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel missatgefinal = new JLabel("");
		JLabel lblEnAquestaPantalla = new JLabel(
				"En aquesta pantalla tindr\u00E0s la opci\u00F3 d'afegir equips a la basew de dades.\r\n\n");
		lblEnAquestaPantalla.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNomDeLequip = new JLabel("Nom de l'equip:");
		lblNomDeLequip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton aafegirNouEquip = new JButton("Afegir nou equip");
		aafegirNouEquip.setVisible(false);
		nomEquip = new JTextField();
		nomEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlBBDD.afegirClub(nomEquip.getText());
					System.out.println(nomEquip.getText());
					missatgefinal.setText("Equip afegir correctament.");
					nomEquip.setEditable(false);
					aafegirNouEquip.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		nomEquip.setColumns(10);

		
		missatgefinal.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton butEnrerea = new JButton("Tornar pantalla anterior");
		butEnrerea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BuscarClub(controlBBDD);
			}
		});
		
		
		aafegirNouEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomEquip.setText("");
				nomEquip.setEditable(true);
				missatgefinal.setText("");
				aafegirNouEquip.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnAquestaPantalla, GroupLayout.PREFERRED_SIZE, 434, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNomDeLequip)
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(missatgefinal, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
								.addComponent(nomEquip, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
								.addComponent(butEnrerea)
								.addComponent(aafegirNouEquip))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblEnAquestaPantalla, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomDeLequip)
						.addComponent(nomEquip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(missatgefinal)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(aafegirNouEquip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(butEnrerea)
					.addGap(33))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
