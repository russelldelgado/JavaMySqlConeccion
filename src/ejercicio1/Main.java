package ejercicio1;

import ejercicio1.excecpciones.CocheException;
import ejercicio1.modelo.Coche;
import ejercicio1.modelo.CocheFamiliar;
import ejercicio1.modelo.Concesionario;
import ejercicio1.modelo.TodoCamino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();

        List<Coche> coches = new ArrayList<>();
     coches =    concesionario.leerDatos("ficherosentrada/coches.csv");

        Concesionario concesionarioDeJaen = new Concesionario("JAEN" , coches);

        concesionarioDeJaen.obtenerCochesSegunFecha(5);

        try {
            concesionarioDeJaen.ampliarConcesionario(new TodoCamino("KVC1234" ,"Ranger Rover Velar" , "Land Rover" ,
                    LocalDate.of(2020 , 06 , 01) , true));

            concesionarioDeJaen.ampliarConcesionario(new CocheFamiliar("KVC1235" ,"Mini cabrio" , "BMW" ,
                    LocalDate.of(2020 , 06 , 02) , 4));

            System.out.println("coches introducidos correctamente");
        } catch (CocheException e) {
            e.printStackTrace();
        }

        concesionarioDeJaen.grabardatos();


    }


}
