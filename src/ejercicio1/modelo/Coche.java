package ejercicio1.modelo;

import ejercicio1.excecpciones.CocheException;

import java.time.LocalDate;

public class Coche {

    private String matricula;
    private String modelo ;
    private String fabricante ;
    private LocalDate fecha_fabricacion;


    public Coche(String matricula, String modelo, String fabricante, LocalDate fecha_fabricacion) throws CocheException {
        if (!Auxiliar.validarMatricula(matricula))
            throw new CocheException();

        this.matricula = matricula;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.fecha_fabricacion = fecha_fabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getFecha_fabricacion() {
        return fecha_fabricacion;
    }

    public void setFecha_fabricacion(LocalDate fecha_fabricacion) {
        this.fecha_fabricacion = fecha_fabricacion;
    }


    @Override
    public String toString() {
        return String.format("MATRÍCULA : %s - MODELO : %s - FABRICANTE : %s - FECHA DE FABRICACIÓN %d/%d/%d" ,matricula , modelo , fabricante ,
                fecha_fabricacion.getDayOfMonth() , fecha_fabricacion.getMonthValue() , fecha_fabricacion.getYear() );
    }
}
