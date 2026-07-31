package Telas;

import Models.Pet;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import DAO.PetDAO;
import Util.Sessao;

public class TelaCadastroPet extends JFrame {

    public TelaCadastroPet() {

        setTitle("PET PEDIA - Cadastro de Pet");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(210, 210, 210));
        painel.setBounds(275, 85, 450, 480);
        add(painel);

        JLabel titulo = new JLabel("CADASTRO DE PET");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(120, 20, 250, 35);
        painel.add(titulo);

        JLabel lblNome = new JLabel("NOME:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 18));
        lblNome.setBounds(35, 80, 90, 30);
        painel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(120, 75, 280, 42);
        txtNome.setBackground(new Color(255, 200, 0));
        txtNome.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtNome.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtNome);

        JLabel lblEspecie = new JLabel("ESPÉCIE:");
        lblEspecie.setFont(new Font("Arial", Font.BOLD, 18));
        lblEspecie.setBounds(18, 145, 100, 30);
        painel.add(lblEspecie);

        JTextField txtEspecie = new JTextField();
        txtEspecie.setBounds(120, 140, 280, 42);
        txtEspecie.setBackground(new Color(255, 200, 0));
        txtEspecie.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtEspecie.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtEspecie);

        JLabel lblRaca = new JLabel("RAÇA:");
        lblRaca.setFont(new Font("Arial", Font.BOLD, 18));
        lblRaca.setBounds(35, 210, 90, 30);
        painel.add(lblRaca);

        JTextField txtRaca = new JTextField();
        txtRaca.setBounds(120, 205, 280, 42);
        txtRaca.setBackground(new Color(255, 200, 0));
        txtRaca.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtRaca.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtRaca);

        JLabel lblNascimento = new JLabel("<html>DATA DE<br>NASCIMENTO:</html>");
        lblNascimento.setFont(new Font("Arial", Font.BOLD, 16));
        lblNascimento.setBounds(5, 265, 110, 55);
        painel.add(lblNascimento);

        JTextField txtNascimento = new JTextField();
        txtNascimento.setBounds(120, 270, 280, 42);
        txtNascimento.setBackground(new Color(255, 200, 0));
        txtNascimento.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtNascimento.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtNascimento);

        JLabel lblSexo = new JLabel("SEXO:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 18));
        lblSexo.setBounds(35, 335, 90, 30);
        painel.add(lblSexo);

        JTextField txtSexo = new JTextField();
        txtSexo.setBounds(120, 330, 280, 42);
        txtSexo.setBackground(new Color(255, 200, 0));
        txtSexo.setBorder(new LineBorder(Color.BLACK, 3, true));
        txtSexo.setFont(new Font("Arial", Font.PLAIN, 18));
        painel.add(txtSexo);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBounds(160, 405, 130, 42);
        btnCadastrar.setBackground(new Color(45, 200, 80));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnCadastrar);

      btnCadastrar.addActionListener(e -> {

    try {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNascimento = LocalDate.parse(txtNascimento.getText(), formato);

        Pet pet = new Pet();

        pet.setNome(txtNome.getText());
        pet.setEspecie(txtEspecie.getText());
        pet.setRaca(txtRaca.getText());
        pet.setSexo(txtSexo.getText());
        pet.setDataNascimento(dataNascimento);

        pet.setUsuario(Sessao.getUsuarioLogado());

        PetDAO petDAO = new PetDAO();

        if (petDAO.salvar(pet)) {

            JOptionPane.showMessageDialog(this,
                    "Pet cadastrado com sucesso!");

            new TelaPrincipal();
            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar o pet.");

        }

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(this,
                "Data inválida! Use o formato dd/MM/yyyy");

    }

    new TelaPrincipal();
    dispose();

});

        
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaCadastroPet();
        });

    }
}