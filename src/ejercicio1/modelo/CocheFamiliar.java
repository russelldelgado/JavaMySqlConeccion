package ejercicio1.modelo;

import ejercicio1.excecpciones.CocheException;

import java.time.LocalDate;

public class CocheFamiliar extends Coche {
        private  int numeroDeAsientos ;


    public CocheFamiliar(String matricula, String modelo, String fabricante, LocalDate fecha_fabricacion, int numeroDeAsientos) throws CocheException {
        super(matricula, modelo, fabricante, fecha_fabricacion);
        this.numeroDeAsientos = numeroDeAsientos;
    }


    public int getNumeroDeAsientos() {
        return numeroDeAsientos;
    }

    public void setNumeroDeAsientos(int numeroDeAsientos) {
        this.numeroDeAsientos = numeroDeAsientos;
    }


    @Override
    public String toString() {
        return String.format(" %s - numero de asientos : %d" , super.toString() , numeroDeAsientos  );
    }
}
