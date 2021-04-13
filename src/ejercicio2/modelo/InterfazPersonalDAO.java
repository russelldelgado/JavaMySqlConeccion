package ejercicio2.modelo;

import java.util.List;

public interface InterfazPersonalDAO {
    //CRUD: Create, Read, Update, Delete


    List<Personal> ListarTodoElPersonal();
    boolean aumentarSueldoPorNombre(String nombrePersona);
    boolean borrarPersonalPorNombre(String nombrePersonal);
    boolean crearPersonal(Personal personal);
}
