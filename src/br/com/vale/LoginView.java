package br.com.vale;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnAcessar, btnCancelar;

	public LoginView() {
		setTitle("Tela de Login");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// Definindo icone da janela
		// ImageIcon(getClass().getResource("/br/com/vale/assets/icon2.png")).getImage());

		// Criando painel principal com padding
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Rótulo Usuário
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Usuário:"), gbc);

		// Campo de entrada do Usuário
		gbc.gridx = 1;
		txtUsuario = new JTextField(15);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(txtUsuario, gbc);

		// Rótulo Senha
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Senha:"), gbc);

		// Campo de entrada da Senha
		gbc.gridx = 1;
		txtSenha = new JPasswordField(15);
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(txtSenha, gbc);

		// Painel de Botões
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		btnAcessar = new JButton("Acessar");
		btnAcessar.setBackground(new Color(0, 102, 204));
		btnAcessar.setForeground(Color.WHITE);
		btnAcessar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAcessar.setFocusPainted(false);
		btnAcessar.setPreferredSize(new Dimension(120, 35));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.GRAY);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setPreferredSize(new Dimension(120, 35));

		buttonPanel.add(btnAcessar);
		buttonPanel.add(btnCancelar);

		// Adicionando os botões na tela
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(buttonPanel, gbc);

		// Adicionando ações aos botões
		btnAcessar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				autenticarUsuario();
			}
		});

		btnCancelar.addActionListener(e -> System.exit(0));

		add(panel);
	}

	private void autenticarUsuario() {
		String usuario = txtUsuario.getText();
		String senha = new String(txtSenha.getPassword());

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean autenticado = usuarioDAO.verificarLogin(usuario, senha);

		if (autenticado) {
			// JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso",
			// JOptionPane.INFORMATION_MESSAGE);

			// Abrir tela principal e fechar login
			new PrincipalView().setVisible(true);
			dispose(); // Fecha a tela de login

		} else {
			JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
