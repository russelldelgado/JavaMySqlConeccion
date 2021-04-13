package ejercicio1.modelo;

import ejercicio1.excecpciones.CocheException;

import java.time.LocalDate;

public class TodoCamino extends Coche{

    private boolean cuatroPorCuatro ;

    public TodoCamino(String matricula, String modelo, String fabricante, LocalDate fecha_fabricacion, boolean cuatroPorCuatro) throws CocheException {
        super(matricula, modelo, fabricante, fecha_fabricacion);
        this.cuatroPorCuatro = cuatroPorCuatro;
    }


    public boolean isCuatroPorCuatro() {
        return cuatroPorCuatro;
    }

    public void setCuatroPorCuatro(boolean cuatroPorCuatro) {
        this.cuatroPorCuatro = cuatroPorCuatro;
    }


    @Override
    public String toString() {
        return String.format("%s - cuatro por cuatro :  %b " , super.toString() , cuatroPorCuatro) ;
    }
}
