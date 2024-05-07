package es.unizar.eina.vv6f.practica3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class MainTest {

    static private InputStream in;
    static private PrintStream out;


    @BeforeAll
    static void guardarRefEntrdaYSalidaEstandar() {

        in = System.in;
        out = System.out;
    }

    @AfterAll
    static void restablecerEntradaYSalidaEstandar() throws IOException {

        System.setIn(in);
        System.setOut(out);

        File fichero_temp = File.createTempFile("src/test/java/es/unizar/eina/vv6f/practica3/salida_temporal",".tmp");
        fichero_temp.deleteOnExit();
        
    }


    @BeforeEach
    void redireccionarSalidaEstandar() throws FileNotFoundException {

        // Se redirige la salida estándar al archivo temporal
        PrintStream ficheroTemp = new PrintStream("src/test/java/es/unizar/eina/vv6f/practica3/salida_temporal.tmp");
        System.setOut(ficheroTemp);

    }


    @Test
    void testQuijote() throws IOException {
        testFichero("quijote");
    }

    @Test
    void testHamlet() throws IOException {
        testFichero("hamlet");
    }


    @Test
    void testRegenta() throws IOException {
        testFichero("hamlet");
    }
    private static void testFichero(String nombreFichero) throws IOException {
        // Se redirige la entrada estándar al fichero deseado
        String inputPath = "src/main/res/" + nombreFichero + ".txt";
        byte[] inputBytesPath = inputPath.getBytes();
        ByteArrayInputStream inputStreamPath = new ByteArrayInputStream(inputBytesPath);
        System.setIn(inputStreamPath);

        Main.main(null);

        //Se comparan los bytes de los ficheros para ver si son identicos
        Path path_fichero_resultado = Paths.get("src/test/java/es/unizar/eina/vv6f/practica3/salida_temporal.tmp");
        Path path_fichero_esperado = Paths.get("src/test/res/resultados_esperados/salida-" + nombreFichero + ".txt");

        byte[] fichero_resultado_bytes = Files.readAllBytes(path_fichero_resultado);
        byte[] fichero_esperado_bytes = Files.readAllBytes(path_fichero_esperado);

        assertArrayEquals(fichero_esperado_bytes, fichero_resultado_bytes);
    }
}