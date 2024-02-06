package exercici3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Exercici3 extends JPanel {

	private final JTextField nomTextField;
	private final JSpinner edatSpinner;
	private final JComboBox<String> provinciaComboBox;
	private final JRadioButton masculiRadioButton;
	private final JRadioButton femeniRadioButton;
	private final JRadioButton altreRadioButton;
	private final JCheckBox acceptaPublicitatCheckBox;
	private final JButton enviarButton;
	private final ButtonGroup grupSexe;

	/**
	 * Asi tenim un formulari que es mostra per pantalla
	 */
	public Exercici3() {
		setLayout(new GridLayout(7, 1, 5, 5));

		JLabel label = new JLabel("Formulari d'inscripció");
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		JPanel nomEdatPanel = new JPanel(new GridLayout(1, 2, 5, 5));

		nomTextField = new JTextField(20);
		JPanel nomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nomPanel.add(new JLabel("Nom: "));
		nomPanel.add(nomTextField);
		nomEdatPanel.add(nomPanel);

		SpinnerModel edatModel = new SpinnerNumberModel(18, 18, 99, 1);
		edatSpinner = new JSpinner(edatModel);
		JPanel edatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		edatPanel.add(new JLabel("Edat: "));
		edatPanel.add(edatSpinner);
		nomEdatPanel.add(edatPanel);

		add(nomEdatPanel);

		String[] provincies = {"Alacant", "València", "Castelló"};
		provinciaComboBox = new JComboBox<>(provincies);
		JPanel provinciaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		provinciaPanel.add(new JLabel("Província: "));
		provinciaPanel.add(provinciaComboBox);
		add(provinciaPanel);

		grupSexe = new ButtonGroup();
		JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sexePanel.add(new JLabel("Sexe: "));
		masculiRadioButton = new JRadioButton("Masculí");
		femeniRadioButton = new JRadioButton("Femení");
		altreRadioButton = new JRadioButton("Altres");
		grupSexe.add(masculiRadioButton);
		grupSexe.add(femeniRadioButton);
		grupSexe.add(altreRadioButton);
		sexePanel.add(masculiRadioButton);
		sexePanel.add(femeniRadioButton);
		sexePanel.add(altreRadioButton);
		add(sexePanel);

		// CheckBox per a acceptar la publicitat
		acceptaPublicitatCheckBox = new JCheckBox("Accepta la publicitat");
		JPanel publicitatPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		publicitatPanel.add(acceptaPublicitatCheckBox);
		add(publicitatPanel);

		// Botó d'enviar
		enviarButton = new JButton("Enviar");
		enviarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (acceptaPublicitatCheckBox.isSelected()) {
					int resposta = mostrarDialogoConfirmacio();
					if (resposta == JOptionPane.YES_OPTION) {
						mostrarDialogoInformacio("Has acceptat les dades del formulari");
						reiniciarValorsPerDefecte();
					} else if (resposta == JOptionPane.NO_OPTION) {
						System.exit(0);
					} else if (resposta == JOptionPane.CANCEL_OPTION) {
						// No fer res, mostrarà novament el formulari
					}
				} else {
					JOptionPane.showMessageDialog(Exercici3.this,
							"Per a enviar les dades, heu d'acceptar la publicitat.",
							"Advertència", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		enviarButton.setEnabled(false);
		add(enviarButton);


		acceptaPublicitatCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				enviarButton.setEnabled(acceptaPublicitatCheckBox.isSelected());
			}
		});

	}

	private int mostrarDialogoConfirmacio() {
		return JOptionPane.showConfirmDialog(Exercici3.this,
				"Vols acceptar les dades del formulari?",
				"Confirmació", JOptionPane.YES_NO_CANCEL_OPTION);
	}

	private void mostrarDialogoInformacio(String missatge) {
		JOptionPane.showMessageDialog(Exercici3.this, missatge, "Informació", JOptionPane.INFORMATION_MESSAGE);
	}

	private void reiniciarValorsPerDefecte() {
		nomTextField.setText("");
		edatSpinner.setValue(18);
		provinciaComboBox.setSelectedIndex(0);
		grupSexe.clearSelection();
		acceptaPublicitatCheckBox.setSelected(false);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Prova del Formulari d'Inscripció");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		URL iconURL = Exercici3.class.getResource("Imagenes/");
		Image icon = new ImageIcon(iconURL).getImage();
		frame.setIconImage(icon);
		Exercici3 panel = new Exercici3();

		frame.getContentPane().add(panel);
		panel.setBackground(Color.green);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}