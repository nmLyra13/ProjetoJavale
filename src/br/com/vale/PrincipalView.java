package br.com.vale;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalView extends JFrame {
	private static final long serialVersionUID = 1L;

	public PrincipalView() {
		setTitle("Sistema de Controle de Adiantamentos");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Criando menu principal
		JMenuBar menuBar = new JMenuBar();

		// Menu Cadastro
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenuItem itemUsuario = new JMenuItem("Usuário");
		JMenuItem itemSolicitante = new JMenuItem("Solicitante");
		menuCadastro.add(itemUsuario);
		menuCadastro.add(itemSolicitante);

		// Menu Relatórios
		JMenu menuRelatorios = new JMenu("Relatórios");
		JMenuItem itemRelSinteticoAbertos = new JMenuItem("Relatório Sintético - Abertos");
		JMenuItem itemRelSinteticoBaixados = new JMenuItem("Relatório Sintético - Baixados");
		menuRelatorios.add(itemRelSinteticoAbertos);
		menuRelatorios.add(itemRelSinteticoBaixados);

		// Adicionando menus à barra de menus
		menuBar.add(menuCadastro);
		menuBar.add(menuRelatorios);

		// **Correção: Forçar a abertura do menu ao clique**
		menuCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menuCadastro.doClick();
			}
		});

		menuRelatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menuRelatorios.doClick();
			}
		});

		// Definir a barra de menus no JFrame
		setJMenuBar(menuBar);
	}
}
