package ejercicio2.modelo;

import ejercicio2.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO implements InterfazPersonalDAO {

    Connection conexion = Conexion.getConexion();

    @Override
    public List<Personal> ListarTodoElPersonal() {
        List<Personal> personasLista = new ArrayList<>();
        String sql = "SELECT * FROM personal;";
        try (Statement sentecia = conexion.createStatement();
             ResultSet resultado = sentecia.executeQuery(sql)) {
            while (resultado.next()){
                personasLista.add(new Personal(resultado.getString(1), resultado.getString(2),
                        resultado.getInt(3), resultado.getDouble(4)));
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return personasLista;
    }

    @Override
    public boolean aumentarSueldoPorNombre(String nombrePersona) {
        String sql = "update personal set sueldo = ? where nombre = ?;";
        int resultado = 0;
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);) {

           // preparedStatement.setDouble(1, );
           // preparedStatement.setString(2,);

            resultado = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado == 1;
    }

    @Override
    public boolean borrarPersonalPorNombre(String nombrePersonal) {
        int resultado = 0;
        PreparedStatement sentencia = null;
        String sql = "DELETE FROM personal WHERE nombre = ?;";
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, nombrePersonal);
            resultado = sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado == 1;
    }

    @Override
    public boolean crearPersonal(Personal personal) {
        PreparedStatement sentencia = null;
        int resultado = 0;
        String sql = "INSERT INTO personal (id, nombre, edad , sueldo) VALUES (?, ?, ? , ?);";
        try {
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, personal.getId());
            sentencia.setString(2, personal.getNombre());
            sentencia.setInt(3, personal.getEdad());
            sentencia.setDouble(4, personal.getSueldo());

            resultado = sentencia.executeUpdate();
        } catch  (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado == 1;
    }


    public static void main(String[] args) {

        PersonalDAO personalDAO = new PersonalDAO() ;

        List<Personal> personasMain = new ArrayList<>();
        personalDAO.crearPersonal(new Personal("1111" ,"jose carlos" , 23 , 1233));

        personasMain =  personalDAO.ListarTodoElPersonal();
            System.out.println(personasMain);
        System.out.println( personalDAO.borrarPersonalPorNombre("jose carlos"));

        System.out.println(personasMain);



    }

}
