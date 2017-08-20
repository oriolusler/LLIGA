package Presentacio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Aplicacio.ControlBBDD;
import Domini.Posicions;

import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Actualitzacio {

	private JFrame frame;
	private ControlBBDD controlBBDD;

	/**
	 * Launch the application.
	 * 
	 * /** Create the application.
	 */
	public Actualitzacio(ControlBBDD controlBBDD) {
		this.controlBBDD = controlBBDD;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelACTUAL = new JPanel();
		
		JLabel lblEquip = new JLabel("Equip");
		lblEquip.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox comboBoxEquips = new JComboBox();

		String[] clubs;
		try {
			clubs = controlBBDD.recuperarClubs();
			comboBoxEquips.setModel(new DefaultComboBoxModel(clubs));

			JLabel lblPosicio = new JLabel("Posicio");
			lblPosicio.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JComboBox comboBoxosicions = new JComboBox();
			comboBoxosicions.setModel(new DefaultComboBoxModel(new String[] { Posicions.POT.name(), Posicions.DF.name(),
					Posicions.MC.name(), Posicions.DL.name() }));

			comboBoxEquips.setSelectedIndex(-1);
			comboBoxosicions.setSelectedIndex(-1);

			JLabel lblJugador = new JLabel("Jugador");
			lblJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));

			JComboBox comboBoxJugador = new JComboBox();
			
			comboBoxJugador.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if (comboBoxEquips.getSelectedIndex() == -1 || comboBoxosicions.getSelectedIndex() == -1) {
						System.out.println("FUCK YOU");
					} else {
						try {
							String[] jugadors = controlBBDD.getJugadorsFromAcctualitzacio(
									comboBoxEquips.getSelectedItem().toString(),
									comboBoxosicions.getSelectedItem().toString());

							List<String> jugadorsAMostrat = new ArrayList<String>();

							for (int i = 0; i < jugadors.length; i++) {
								String[] parts = jugadors[i].split(",");
								String nomJugador = "";
								if (parts[2].equals("-"))
									nomJugador = parts[0] + " " + parts[1];
								else
									nomJugador = parts[0] + " " + parts[1] + " " + parts[2];
								jugadorsAMostrat.add(nomJugador);
							}

							comboBoxJugador.setModel(new DefaultComboBoxModel(jugadorsAMostrat.toArray()));

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});

			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout
					.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup().addGap(25)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblJugador).addComponent(lblPosicio).addComponent(lblEquip))
									.addGap(71)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(comboBoxJugador, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(comboBoxosicions, 0, GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)
											.addComponent(comboBoxEquips, 0, 160, Short.MAX_VALUE))
									.addContainerGap(191, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup().addContainerGap()
									.addComponent(panelACTUAL, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
									.addGap(25)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
					.createSequentialGroup().addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxEquips, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEquip))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPosicio).addComponent(
							comboBoxosicions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblJugador).addComponent(
							comboBoxJugador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelACTUAL, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE)));

			JButton btnPartitJugat = new JButton("PARTIT JUGAT");
			btnPartitJugat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String jugador = comboBoxJugador.getSelectedItem().toString();
					String[] parts = jugador.split(" ");

					try {
						controlBBDD.actulitzarPartitsJugats(parts[0], parts[1], parts[2]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

			JLabel lblActuliztar = new JLabel("Qu\u00E8 vols actulitzar?");
			lblActuliztar.setFont(new Font("Tahoma", Font.PLAIN, 16));

			JButton btnTGroga = new JButton("T. GROGA");
			btnTGroga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String jugador = comboBoxJugador.getSelectedItem().toString();
					String[] parts = jugador.split(" ");
					try {
						controlBBDD.actulitzarTgeogues(parts[0], parts[1], parts[2]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			JButton btnTvarmella = new JButton("T.VARMELLA");
			btnTvarmella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String jugador = comboBoxJugador.getSelectedItem().toString();
					String[] parts = jugador.split(" ");

					try {
						controlBBDD.actulitzarTvarmelles(parts[0], parts[1], parts[2]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			JButton btnGol = new JButton("GOL");
			btnGol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String jugador = comboBoxJugador.getSelectedItem().toString();
					String[] parts = jugador.split(" ");

					try {
						controlBBDD.actulitzarGols(parts[0], parts[1], parts[2]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			JLabel lblPerActulitzarSha = new JLabel(
					"Per actulitzar s'ha de fer click a sobre del boto que vulguis.\r\n\r\n");
			lblPerActulitzarSha.setFont(new Font("Tahoma", Font.PLAIN, 12));

			JLabel lblPerExempleUn = new JLabel(
					"Per exemple, un click a \"T. GROGA\", s'afagir\u00E0 un targeta a la base de dades.");
			lblPerExempleUn.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GroupLayout gl_panelACTUAL = new GroupLayout(panelACTUAL);
			gl_panelACTUAL.setHorizontalGroup(gl_panelACTUAL.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelACTUAL.createSequentialGroup().addGap(70)
							.addComponent(lblPerActulitzarSha, GroupLayout.PREFERRED_SIZE, 331,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(573, Short.MAX_VALUE))
					.addGroup(gl_panelACTUAL.createSequentialGroup().addGap(34).addGroup(gl_panelACTUAL
							.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelACTUAL.createSequentialGroup().addComponent(lblPerExempleUn)
									.addContainerGap())
							.addGroup(gl_panelACTUAL.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING,
											gl_panelACTUAL.createSequentialGroup().addComponent(lblActuliztar)
													.addGap(155))
									.addGroup(gl_panelACTUAL.createSequentialGroup().addComponent(btnPartitJugat)
											.addGap(18).addComponent(btnTGroga).addGap(18).addComponent(btnTvarmella)
											.addGap(18).addComponent(btnGol).addContainerGap(556, Short.MAX_VALUE))))));
			gl_panelACTUAL
					.setVerticalGroup(gl_panelACTUAL.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelACTUAL.createSequentialGroup().addContainerGap()
									.addComponent(lblActuliztar).addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPerActulitzarSha, GroupLayout.PREFERRED_SIZE, 32,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblPerExempleUn)
									.addGap(18)
									.addGroup(gl_panelACTUAL.createParallelGroup(Alignment.BASELINE)
											.addComponent(btnPartitJugat).addComponent(btnTGroga)
											.addComponent(btnTvarmella).addComponent(btnGol))
									.addContainerGap(43, Short.MAX_VALUE)));
			panelACTUAL.setLayout(gl_panelACTUAL);
			frame.getContentPane().setLayout(groupLayout);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
