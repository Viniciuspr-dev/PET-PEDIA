package Models;

import java.time.LocalDate;

public class Pet {

    private int idPet;
    private String nomePet;
    private LocalDate dataNascimentoPet;
    private String racaPet;
    private String especiePet;
    private String sexoPet;

    private Usuario usuario;

    public Pet() {
    }


    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNome() {
        return nomePet;
    }

    public void setNome(String nome) {
        this.nomePet = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimentoPet;
    }

    public void setDataNascimento(LocalDate dataNascimentoPet) {
        this.dataNascimentoPet = dataNascimentoPet;
    }

    public String getRaca() {
        return racaPet;
    }

    public void setRaca(String raca) {
        this.racaPet = raca;
    }

    public String getEspecie() {
        return especiePet;
    }

    public void setEspecie(String especie) {
        this.especiePet = especie;
    }

    public String getSexo() {
        return sexoPet;
    }

    public void setSexo(String sexo) {
        this.sexoPet = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}