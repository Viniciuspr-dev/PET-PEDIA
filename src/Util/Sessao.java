package Util;

import Models.Pet;
import Models.Usuario;

public class Sessao {

    private static Usuario usuarioLogado;
    private static Pet petSelecionado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static Pet getPetSelecionado() {
        return petSelecionado;
    }

    public static void setPetSelecionado(Pet pet) {
        petSelecionado = pet;
    }

    public static void encerrarSessao() {
        usuarioLogado = null;
        petSelecionado = null;
    }

}