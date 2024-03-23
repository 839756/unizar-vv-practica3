package es.unizar.eina.vv6f.practica3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class ContadorDeLetrasTest {

    @Test
    void testFicheroVacio() throws FileNotFoundException {

        File fichero = new File("src/test/res/prueba.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];

        assertArrayEquals(arrayEsperado, contador.frecuencias());

    }


    @Test
    void testFrecuenciaInicialNoNull() throws FileNotFoundException {

        File fichero = new File("src/test/res/prueba.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado1 = new int[27];

        int[] arrayEsperado2 = contador.frecuencias();
        assertArrayEquals(arrayEsperado1, contador.frecuencias());  //se comprueba que el vector son ceros
        assertArrayEquals(arrayEsperado2, contador.frecuencias());  //se comprueba que el vector es igual primero hayado

    }


    @Test
    void testFicheroNoExiste(){

        File fichero = new File("noExiste.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        assertThrows(FileNotFoundException.class, contador::frecuencias);

    }

    @Test
    void testFicheroNull(){

        File fichero = null;
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        assertThrows(NullPointerException.class, contador::frecuencias);

    }

    @Test
    void testMinusculas() throws FileNotFoundException {

        File fichero = new File("src/test/res/minusculas.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        Arrays.fill(arrayEsperado,1);
        arrayEsperado[26] = 0;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testMayusculas() throws FileNotFoundException {

        File fichero = new File("src/test/res/mayusculas.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        Arrays.fill(arrayEsperado,1);
        arrayEsperado[26] = 0;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testEgneMin() throws FileNotFoundException {

        File fichero = new File("src/test/res/egne_minuscula.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[26] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testEgneMay() throws FileNotFoundException {

        File fichero = new File("src/test/res/egne_mayuscula.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[26] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }


    @Test
    void testVoladaO() throws FileNotFoundException {

        File fichero = new File("src/test/res/volada_o.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[14] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }


    @Test
    void testVoladaA() throws FileNotFoundException {

        File fichero = new File("src/test/res/volada_a.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }


    @Test
    void testAgudosMinuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/agudos_min.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testAgudosMayuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/agudos_mayu.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }
    
    @Test
    void testGravesMinuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/graves_min.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testGravesMayuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/graves_mayu.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testCircunflejosMinuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/circunflejos_min.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testCircunflejosMayuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/circunflejos_mayu.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testDieresisMinuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/dieresis_min.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }
    
    @Test
    void testDieresisMayuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/dieresis_mayu.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[0] = 1;
        arrayEsperado[4] = 1;
        arrayEsperado[8] = 1;
        arrayEsperado[14] = 1;
        arrayEsperado[20] = 1;


        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testCedillaMinuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/cedilla_min.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];  
        arrayEsperado[2] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testCedillaMayuscula() throws FileNotFoundException {

        File fichero = new File("src/test/res/cedilla_mayu.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];
        arrayEsperado[2] = 1;

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testNumeros() throws FileNotFoundException {

        File fichero = new File("src/test/res/numeros.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testSimbolos() throws FileNotFoundException {

        File fichero = new File("src/test/res/simbolos.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = new int[27];

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }


    @Test
    void testQuijote() throws FileNotFoundException {

        File fichero = new File("src/main/res/quijote.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = { 200495, 24147, 59436, 87237, 229189, 7581, 17225, 19920, 90075, 10530,
            0, 89141, 44658, 108441, 162514, 35465, 32483, 100954, 125727,
            61749, 79559, 17855, 2, 377, 25115, 6491, 4241 };

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }

    @Test
    void testHamlet() throws FileNotFoundException {

        File fichero = new File("src/main/res/hamlet.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = { 9912, 1816, 2612, 5044, 14986, 2682, 2418, 8681, 8488, 111, 1268, 5828,
            4253, 8306, 11193, 2013, 218, 7741, 8326, 11770, 4322, 1225,
            3129, 175, 3196, 72, 0 };

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }
    
    @Test
    void testRegenta() throws FileNotFoundException {

        File fichero = new File("src/main/res/regenta.txt");
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        int[] arrayEsperado = { 195175, 26862, 53217, 68273, 178917, 8620, 15404, 13913, 87589, 6505,
            61, 84711, 37053, 88950, 129829, 34482, 17977, 90627, 102937,
            54752, 58427, 15717, 19, 1240, 13826, 5632, 3534 };

        assertArrayEquals(arrayEsperado, contador.frecuencias());
    }


}