package dao;

import conexion.Conexion;
import vo.PersonaVo;

import java.sql.*;
import java.util.ArrayList;

public class PersonaDao {
    Conexion miConexion = new Conexion();
    private Connection conexion;

    public PersonaDao() {
        this.conexion = miConexion.getConnection();
    }

    public void registrarPersona(PersonaVo persona) {
        String sql = "INSERT INTO persona (documento, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, persona.getDocumento());
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getDireccion());
            stmt.setString(4, persona.getTelefono());
            stmt.executeUpdate();
            System.out.println("Persona registrada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar persona: " + e.getMessage());
        }
    }

    public void eliminarPersona(String documento) {
        String sql = "DELETE FROM persona WHERE documento = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, documento);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Persona eliminada exitosamente.");
            } else {
                System.out.println("No se encontró persona con documento: " + documento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar persona: " + e.getMessage());
        }
    }

    public void actualizarPersona(PersonaVo persona) {
        String sql = "UPDATE persona SET nombre = ?, direccion = ?, telefono = ? WHERE documento = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getDireccion());
            stmt.setString(3, persona.getTelefono());
            stmt.setString(4, persona.getDocumento());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Persona actualizada exitosamente.");
            } else {
                System.out.println("No se encontró persona con documento: " + persona.getDocumento());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar persona: " + e.getMessage());
        }
    }

    public ArrayList<PersonaVo> obtenerListaPersonas() {
        ArrayList<PersonaVo> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PersonaVo persona = new PersonaVo();
                persona.setDocumento(rs.getString("documento"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setTelefono(rs.getString("telefono"));
                lista.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener lista de personas: " + e.getMessage());
        }

        return lista;
    }

}
