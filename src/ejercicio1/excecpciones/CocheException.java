package ejercicio1.excecpciones;

public class CocheException extends Exception {
    @Override
    public String getMessage() {
        return "LA MATRÍCULA DEL COCHE NO ES CORRECTA" ;
    }
}

//TENEMOS QUE CREAR UN METODO QUE VERIFIQUE QUE LA MATRÍCULA DEL COCHE ES CORRECTA Y LANZARLA EN EL CONTRUCTOR JUNTO CON ESTA EXCEPTION
//XXX1111 <---- TIENE QUE CUMPLIR ESTA CONDICIÓN TRES LETRAS MAS 4 NUMEROS