package Telas;

import DAO.UsuarioDAO;
import Models.Usuario;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {

        setTitle("PET PEDIA - Cadastro");
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

        JLabel titulo = new JLabel("CRIE SUA CONTA");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(115, 30, 250, 35);
        painel.add(titulo);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        lblUsuario.setBounds(45, 90, 100, 25);
        painel.add(lblUsuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(45, 115, 330, 42);
        txtUsuario.setBackground(new Color(255, 200, 0));
        txtUsuario.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtUsuario);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
        lblEmail.setBounds(45, 175, 100, 25);
        painel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(45, 200, 330, 42);
        txtEmail.setBackground(new Color(255, 200, 0));
        txtEmail.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtEmail);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
        lblSenha.setBounds(45, 260, 100, 25);
        painel.add(lblSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(45, 285, 330, 42);
        txtSenha.setBackground(new Color(255, 200, 0));
        txtSenha.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtSenha);

        JButton btnCadastrar = new JButton("ENTRAR");
        btnCadastrar.setBounds(135, 380, 140, 42);
        btnCadastrar.setBackground(new Color(45, 200, 80));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnCadastrar);
        
        btnCadastrar.addActionListener(e -> {

    Usuario usuario = new Usuario();

    usuario.setNome(txtUsuario.getText());
    usuario.setEmail(txtEmail.getText());
    usuario.setSenha(new String(txtSenha.getPassword()));

    UsuarioDAO usuarioDAO = new UsuarioDAO();

if (usuarioDAO.salvar(usuario)) {

    JOptionPane.showMessageDialog(this,
            "Usuário cadastrado com sucesso!");

    new TelaLogin();
    dispose();

} else {

    JOptionPane.showMessageDialog(this,
            "Erro ao cadastrar usuário.");

}

    new TelaLogin();
    dispose();

});

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaCadastro();
        });

    }
}