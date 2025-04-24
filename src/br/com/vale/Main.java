package br.com.vale;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
	}
}
