package DAO;

import Conexao.Conexao;
import Models.Pet;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PetDAO {

    public boolean salvar(Pet pet) {

        String sql = """
            INSERT INTO pet
            (nomePet, especiePet, racaPet, sexoPet, dataNascimento, idUsuario)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            stmt.setString(3, pet.getRaca());
            stmt.setString(4, pet.getSexo());

        if (pet.getDataNascimento() != null) {
            stmt.setDate(5, java.sql.Date.valueOf(pet.getDataNascimento()));
    }
        else {
            stmt.setDate(5, null);
    }

            stmt.setInt(6, pet.getUsuario().getIdUsuario());

            stmt.executeUpdate();

        return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }

    }
        public List<Pet> listarPorUsuario(int idUsuario) {

    List<Pet> listaPets = new ArrayList<>();

    String sql = "SELECT * FROM pet WHERE idUsuario = ?";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        stmt.setInt(1, idUsuario);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Pet pet = new Pet();

            pet.setIdPet(rs.getInt("idPet"));
            pet.setNome(rs.getString("nomePet"));
            pet.setEspecie(rs.getString("especiePet"));
            pet.setRaca(rs.getString("racaPet"));
            pet.setSexo(rs.getString("sexoPet"));

            if (rs.getDate("dataNascimento") != null) {
                pet.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
            }

            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario"));

            pet.setUsuario(usuario);

            listaPets.add(pet);

        }

    } catch (SQLException e) {

        e.printStackTrace();

    }

    return listaPets;

}
}