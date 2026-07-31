package Telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

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
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(145, 35, 180, 35);
        painel.add(titulo);
     
        JButton btnCadastrarPet = new JButton("CADASTRAR SEU PET");
        btnCadastrarPet.setBounds(50, 135, 330, 90);
        btnCadastrarPet.setBackground(new Color(255, 200, 0));
        btnCadastrarPet.setForeground(Color.BLACK);
        btnCadastrarPet.setFont(new Font("Arial", Font.BOLD, 24));
        btnCadastrarPet.setFocusPainted(false);
        btnCadastrarPet.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnCadastrarPet);
        
        btnCadastrarPet.addActionListener(e -> {

    new TelaCadastroPet();
    dispose();

});

        
        JButton btnAnimais = new JButton("ANIMAIS CADASTRADOS");
        btnAnimais.setBounds(50, 265, 330, 90);
        btnAnimais.setBackground(new Color(255, 200, 0));
        btnAnimais.setForeground(Color.BLACK);
        btnAnimais.setFont(new Font("Arial", Font.BOLD, 22));
        btnAnimais.setFocusPainted(false);
        btnAnimais.setBorder(new LineBorder(Color.BLACK, 3, true));
        painel.add(btnAnimais);

        btnAnimais.addActionListener(e -> {

    new TelaAnimaisCadastrados();
    dispose();

});
        
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal();
        });

    }
}