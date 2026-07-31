package Telas;

import Util.Sessao;
import Models.Usuario;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import DAO.UsuarioDAO;


public class TelaLogin extends JFrame {

    public TelaLogin() {

        setTitle("PET PEDIA");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(210, 210, 210));
        painel.setBounds(285, 85, 430, 475);
        add(painel);

        JLabel titulo = new JLabel("PET PEDIA");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(145, 35, 180, 40);
        painel.add(titulo);

        JLabel lblEmail = new JLabel("E-mail ou Usuário:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
        lblEmail.setBounds(50, 110, 180, 25);
        painel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(50, 140, 330, 55);
        txtEmail.setBackground(new Color(255, 200, 0));
        txtEmail.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
        lblSenha.setBounds(50, 215, 100, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(50, 245, 330, 55);
        txtSenha.setBackground(new Color(255, 200, 0));
        txtSenha.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtSenha);

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(135, 320, 140, 42);
        btnEntrar.setBackground(new Color(45, 200, 80));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEntrar.setFocusPainted(false);
        btnEntrar.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnEntrar);
        
        btnEntrar.addActionListener(e -> {

    String email = txtEmail.getText();
String senha = new String(txtSenha.getPassword());

UsuarioDAO usuarioDAO = new UsuarioDAO();

Usuario usuario = usuarioDAO.fazerLogin(email, senha);

if (usuario != null) {

    Sessao.setUsuarioLogado(usuario);

    JOptionPane.showMessageDialog(this,
            "Bem-vindo " + usuario.getNome());

    new TelaPrincipal();
    dispose();

} else {

    JOptionPane.showMessageDialog(this,
            "E-mail ou senha incorretos!");

}
});

        JButton btnCadastro = new JButton("CADASTRO");
        btnCadastro.setBounds(135, 380, 140, 42);
        btnCadastro.setBackground(new Color(45, 200, 80));
        btnCadastro.setForeground(Color.WHITE);
        btnCadastro.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastro.setFocusPainted(false);
        btnCadastro.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnCadastro);

        btnCadastro.addActionListener(e -> {

    new TelaCadastro();
    dispose();

});
        
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaLogin();
        });

    }
}