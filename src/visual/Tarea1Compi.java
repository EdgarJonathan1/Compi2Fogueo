/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.io.BufferedReader;
import java.io.FileReader;

import Logica.Ejecutor;
import Logica.Nodo;
import Analisis.ALexico;
import Analisis.ASintactico;

/**
 *
 * @author jonathan
 */
public class Tarea1Compi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        interpretarDatos("/home/jonathan/IdeaProjects/CompiFogueo/ArchivoPrueba/Entrada.txt");
    }

    private static void interpretarDatos(String path) {
        ASintactico sintactico;
        Nodo raiz;
        try {

            ALexico lexico = new ALexico(new BufferedReader(new FileReader(path)));
            sintactico = new ASintactico(lexico);

//            System.out.println("------------Inicio Analisis----------");
            sintactico.parse();
            raiz = sintactico.raiz;
//            System.out.println("------------Fin Analisis--------");
            System.out.println("Analisis realizado con exito");

            if (raiz != null) {
                Ejecutor exe = new Ejecutor();
                exe.Ejecutar(raiz);

            } else {
                System.out.println("Existio un error a la hora de leer el archivo");
            }

//            TablaError tabla = TablaError.getInstance();
//            tabla.imprimir();
//            tabla.escribirReporte();
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: " + ex.getCause());
        }
    }

}
