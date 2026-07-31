package Telas;

import Models.Pet;
import Util.Sessao;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.time.format.DateTimeFormatter;

public class TelaInformacoesPet extends JFrame {

    public TelaInformacoesPet() {

        setTitle("PET PEDIA - Informações do Pet");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(173, 206, 58));
        painel.setBounds(270, 100, 430, 450);
        add(painel);


        JPanel painelNome = new JPanel(new BorderLayout());
        painelNome.setBackground(new Color(132, 158, 43));
        painelNome.setBounds(120, 10, 210, 50);
        painel.add(painelNome);

        JLabel lblNome = new JLabel("", SwingConstants.CENTER);
        lblNome.setFont(new Font("Arial", Font.BOLD, 22));
        painelNome.add(lblNome);

        

        JPanel painelInfo = new JPanel();
        painelInfo.setLayout(null);
        painelInfo.setBackground(new Color(132, 158, 43));
        painelInfo.setBounds(10, 70, 410, 225);
        painel.add(painelInfo);

        JLabel lblEspecie = new JLabel();
        lblEspecie.setFont(new Font("Arial", Font.BOLD, 18));
        lblEspecie.setBounds(10, 10, 380, 30);
        painelInfo.add(lblEspecie);

        JLabel lblRaca = new JLabel();
        lblRaca.setFont(new Font("Arial", Font.BOLD, 18));
        lblRaca.setBounds(10, 55, 380, 30);
        painelInfo.add(lblRaca);

        JLabel lblSexo = new JLabel();
        lblSexo.setFont(new Font("Arial", Font.BOLD, 18));
        lblSexo.setBounds(10, 100, 380, 30);
        painelInfo.add(lblSexo);

        JLabel lblNascimento = new JLabel();
        lblNascimento.setFont(new Font("Arial", Font.BOLD, 18));
        lblNascimento.setBounds(10, 190, 380, 30);
        painelInfo.add(lblNascimento);

        

        Pet pet = Sessao.getPetSelecionado();

        if (pet != null) {

            lblNome.setText(pet.getNome());

            lblEspecie.setText("Espécie: " + pet.getEspecie());

            lblRaca.setText("Raça: " + pet.getRaca());

            lblSexo.setText("Sexo: " + pet.getSexo());

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

if (pet.getDataNascimento() != null) {

    lblNascimento.setText(
        "Nascimento: " +
        pet.getDataNascimento().format(formato)
    );

} else {

    lblNascimento.setText("Nascimento: Não informado");

}

        }


        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.setBounds(145, 380, 140, 40);
        btnVoltar.setBackground(new Color(50, 200, 90));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorder(new LineBorder(Color.BLACK, 3, true));

        btnVoltar.addActionListener(e -> {

            new TelaAnimaisCadastrados();
            dispose();

        });

        painel.add(btnVoltar);

        setVisible(true);

    }

}