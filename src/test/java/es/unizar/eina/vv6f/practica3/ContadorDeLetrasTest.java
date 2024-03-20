package es.unizar.eina.vv6f.practica3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class ContadorDeLetrasTest {

    @Test
    void comprobarFicheroVacio(){

        File fichero = new File("src/test/res/prueba.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        //Se crea un vector de ceros de la misma longitud para comprobar
        int[] arrayEsperado = new int[27];

        try {
            assertArrayEquals(arrayEsperado, contador.frecuencias());
        } catch (Exception e) {
            fail("Excepción encontrada: " + e.getMessage());
        }
    }


    @Test
    void comprobarFrecuenciaInicialNoNull(){

        File fichero = new File("src/test/res/prueba.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        //Se crea un vector de ceros de la misma longitud para comprobar
        int[] arrayEsperado1 = new int[27];

        try {
            int[] arrayEsperado2 = contador.frecuencias();
            assertArrayEquals(arrayEsperado1, contador.frecuencias());  //se comprueba que el vector son ceros
            assertArrayEquals(arrayEsperado2, contador.frecuencias());  //se comprueba que el vector es igual primero hayado
        } catch (Exception e) {
            fail("Excepción encontrada: " + e.getMessage());
        }
    }


    @Test
    void comprobarFicheroNoExiste(){

        File fichero = new File("noExiste.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        assertThrows(FileNotFoundException.class, contador::frecuencias);

    }
}