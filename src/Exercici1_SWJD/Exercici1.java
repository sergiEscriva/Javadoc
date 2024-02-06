package Exercici1_SWJD;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.FlowLayout.CENTER;

public class Exercici1 extends JPanel {
	private final JTextField usuario;
	private final JTextField contrasenya;
	private final JButton enviar;
	private static final String usuCorrecte = "usu1";
	private static final String passwCorrecte = "usu1";
	private JButton cambiarColor;
	private static Color color1 = (new java.awt.Color(189, 236, 182));
	private static Color color2 = (new java.awt.Color(49, 126, 182));
	private static JFrame mainFrame;



	public Exercici1() {
		setLayout(new GridLayout(5, 1, 5, 5));
		setBackground(color1);

		JLabel label = new JLabel("Welcome");
		label.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
//////////////////////////////////////////////////////////////////////////////////
		JPanel usuarioPanel = new JPanel(new GridLayout(1, 1));

		usuario = new JTextField(15);
		JPanel usuPanel = new JPanel(new FlowLayout(CENTER));
		usuPanel.add(new JLabel("Usuari"));
		usuPanel.add(usuario);
		usuarioPanel.add(usuPanel);
		add(usuarioPanel);
//////////////////////////////////////////////////////////////////
		contrasenya = new JPasswordField(15);
		JPanel passwPanel = new JPanel(new FlowLayout(CENTER));
		passwPanel.add(new JLabel("Contrasenya"));
		passwPanel.add(contrasenya);
		passwPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		add(passwPanel);
/////////////////////////////////////////////////////////////////
		JPanel panelBoto = new JPanel(new FlowLayout(CENTER));
		enviar = new JButton("LOG IN");
		panelBoto.setSize(50, 50);
		panelBoto.add(enviar);
		enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuariIntroduit = usuario.getText();
				String contrasenyaIntroduida = contrasenya.getText();
				if (comprobarContrasenya(contrasenyaIntroduida) && comprobarUsuari(usuariIntroduit)) {
					abrirVentanaPrincipal();
				} else
					JOptionPane.showMessageDialog(enviar, usuariIntroduit + " acces denegat", "nononononononono", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(panelBoto);
////////////////////////////////////////////////////////////////
		JPanel panelBotonColor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cambiarColor = new JButton("Cambiar color");
		panelBotonColor.setSize(50,50);
		panelBotonColor.add(cambiarColor);
		cambiarColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isBackgroundSet(color1)){
					setBackground(color2);
				} else if (!isBackgroundSet(color1)){
					setBackground(color1);
				}
				repaint();
			}
		});
		add(cambiarColor);
	}

	private boolean isBackgroundSet(Color color) {
		return color.equals(color1) || color.equals(color2);
	}

	public static boolean comprobarContrasenya(String contrasenya) {
		return contrasenya.equals(passwCorrecte);
	}

	public static boolean comprobarUsuari(String usuari) {
		return usuari.equals(usuCorrecte);
	}
	private static void abrirVentanaPrincipal() {
		mainFrame = new JFrame("Esta dentro");

		JLabel bienvenida = new JLabel("You'are Login");
		mainFrame.add(bienvenida);
		JButton salir = new JButton(String.valueOf(JFrame.EXIT_ON_CLOSE));
		JFrame botonsalir = new JFrame();
		botonsalir.add(salir);
		botonsalir.setSize(100,100);
		mainFrame.add(botonsalir);
		mainFrame.setSize(400, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Inici de sesio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Exercici1());
		frame.setSize(300, 300);
		Image image = new ImageIcon(Exercici1.class.getResource("img/mono.png")).getImage();
		frame.setIconImage(image);
		frame.setVisible(true);
	}
}