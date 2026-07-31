package Telas;

import Models.Pet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import DAO.PetDAO;
import java.util.List;
import Util.Sessao;

public class TelaAnimaisCadastrados extends JFrame {

    public TelaAnimaisCadastrados() {

        setTitle("PET PEDIA - Animais Cadastrados");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel painel = new JPanel(null);
        painel.setBackground(new Color(210,210,210));
        painel.setBounds(285,85,430,475);
        add(painel);

        JLabel titulo = new JLabel("<html><center>ANIMAIS<br>CADASTRADOS</center></html>");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial",Font.BOLD,22));
        titulo.setBounds(90,20,250,60);
        painel.add(titulo);

       PetDAO petDAO = new PetDAO();

List<Pet> pets = petDAO.listarPorUsuario(
        Sessao.getUsuarioLogado().getIdUsuario());

        int y = 110;
        int quantidade = 0;

        for (Pet pet : pets) {

            JPanel card = new JPanel(null);
            card.setBackground(new Color(128,160,35));
            card.setBorder(new LineBorder(Color.BLACK,3,true));
            card.setBounds(25,y,380,55);

            JLabel foto = new JLabel("FOTO",SwingConstants.CENTER);
            foto.setOpaque(true);
            foto.setBackground(Color.ORANGE);
            foto.setBorder(new LineBorder(Color.BLACK,2,true));
            foto.setBounds(10,8,40,40);
            card.add(foto);

            JLabel info = new JLabel(
                    pet.getNome()
                    + " - "
                    + pet.getEspecie());

            info.setFont(new Font("Arial",Font.BOLD,16));
            info.setBounds(70,15,290,25);
            card.add(info);

            card.addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent e){

                    Sessao.setPetSelecionado(pet);

                    new TelaInformacoesPet();

                    dispose();

                }

            });

            painel.add(card);

            y += 80;
            quantidade++;

            if(quantidade == 3){
                break;
            }

        }

        if(quantidade == 0){

            JLabel vazio = new JLabel("Nenhum pet cadastrado.");
            vazio.setFont(new Font("Arial",Font.BOLD,18));
            vazio.setBounds(95,180,250,30);
            painel.add(vazio);

        }

        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.setBounds(145,390,140,42);
        btnVoltar.setBackground(new Color(45,200,80));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(new Font("Arial",Font.BOLD,18));
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorder(new LineBorder(Color.BLACK,3,true));

        btnVoltar.addActionListener(e->{

            new TelaPrincipal();

            dispose();

        });

        painel.add(btnVoltar);

        setVisible(true);

    }

}