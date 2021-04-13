package ejercicio1.modelo;

public class Auxiliar {


    public static boolean validarMatricula(String matricula) {

    return matricula.matches("[a-zA-Z]{3}[0-9]{4}");
    }


}
