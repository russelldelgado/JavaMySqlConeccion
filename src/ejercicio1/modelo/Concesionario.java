package ejercicio1.modelo;

import ejercicio1.excecpciones.CocheException;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Concesionario {
    private  String nombre;
    private List<Coche> cochesLeido = new ArrayList<>() ;


    public Concesionario(String nombre, List<Coche> listaDeCoches) {
        this.nombre = nombre;
        this.cochesLeido = listaDeCoches;
    }

    public Concesionario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCochesLeido() {
        return cochesLeido;
    }

    public void setCochesLeido(List<Coche> cochesLeido) {
        this.cochesLeido = cochesLeido;
    }



    public boolean ampliarConcesionario(Coche coche){
        return cochesLeido.add(coche);
    }


    public List<Coche>obtenerCochesSegunFecha(int annos){
        List<Coche> listaSegunFecha = new ArrayList<>();
        int annosDelCoche ;
        for ( Coche coche: cochesLeido) {
            annosDelCoche = obtenerAnnosEntreDosFechas(coche.getFecha_fabricacion() , LocalDate.now());

            if (annosDelCoche >= annos)
                System.out.println(coche);
                listaSegunFecha.add(coche);
        }

        return listaSegunFecha;
    }


    public  int obtenerAnnosEntreDosFechas(LocalDate fecha1, LocalDate fecha2){
        Period period = Period.between(fecha1, fecha2);
        return period.getYears();
    }



    public Map<String, Boolean> ListarCochesTodoCamino(){
        Map<String , Boolean> diccionarioCaminos = new HashMap<>();

        for (Coche cochetodocamino: cochesLeido) {
           // diccionarioCaminos.put(cochetodocamino.getMatricula() , )
        }
        return diccionarioCaminos ;
    }

    //LO PONEMOS ESTATICO PORQUE VAMOS A TRABAJAR CON EL EN EL METODO MAIN Y NOS DEVOLVERA UNA LISTA QUE ES LA QUE UTILIZAREMOS PARA CREAR LA CLASE CONCECIONARIO.


    public  List<Coche> leerDatos ( String ruta){

        List<Coche> cochesLeidos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(ruta))) {

            String lineaCabecera = sc.nextLine();

            while (sc.hasNextLine()) {
                String tokens[] = sc.nextLine().split("[,]");
              /*  System.out.println(tokens[0]);
                System.out.println(tokens[1]);
                System.out.println(tokens[2]);
                System.out.println(tokens[3]);
                System.out.println(tokens[4]);
*/

                String[] datosFecha1 = tokens[3].split("/");
                int dia = Integer.parseInt(datosFecha1[2]);
                int mes = Integer.parseInt(datosFecha1[1]);
                int anno = Integer.parseInt(datosFecha1[0]);
                LocalDate fechaMatriculacion = LocalDate.of(anno, mes, dia);

              /*  System.out.println(datosFecha1[0]);
                System.out.println(datosFecha1[1]);
                System.out.println(datosFecha1[2]);
*/
                try {
                    cochesLeidos.add(new Coche(tokens[0] , tokens[1] , tokens[2]  , fechaMatriculacion ));
                    if (tokens[4].matches("[0-9]")){
                        cochesLeidos.add(new CocheFamiliar(tokens[0] , tokens[1] , tokens[2]  , fechaMatriculacion , Integer.parseInt(tokens[4])));
                       // System.out.println("coche familiar creado");
                    }
                    else {
                        cochesLeidos.add(new TodoCamino(tokens[0] , tokens[1] , tokens[2]  , fechaMatriculacion , Boolean.parseBoolean(tokens[4])));
                       // System.out.println("COCHE TODO TERRENO CREADO");

                    }




                } catch (CocheException e) {
                    System.out.println(e.getMessage());
                }

            }

         //   for ( Coche cochesEntrada: cochesLeidos) {
            //                System.out.println(cochesEntrada);
            //            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cochesLeidos;

    }

//este metodo es de instancia ya que trabajaremos con los atributos de la clase

    public  void grabardatos(){
        String salida = "ficherossalida/coches" + LocalDate.now() + ".csv";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(salida)))) {

            for (Coche coches: cochesLeido) {
                out.write(coches.toString().trim() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    // public static void main(String[] args) {
    //        List<Coche> listaPrincipal = new ArrayList<>();
    //listaPrincipal = leerDatos("ficherosentrada/coches.csv");
    //
    //
    //        Concesionario concesionario = new Concesionario("jose" , listaPrincipal);
    //
    //
    //        concesionario.obtenerCochesSegunFecha(5);
    //
    //        concesionario.grabardatos();
    //
    //
    //    }








}
