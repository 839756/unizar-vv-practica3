package es.unizar.eina.vv6f.practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Programa Java que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
 * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista de
 * las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
 * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
 * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
 * 
 * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto de
 * apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves, diéresis y
 * cedillas), se consideran como ocurrencias de la letra correspondiente sin diacríticos.
 */
public class Main {

    private static final String FORMATO_SALIDA_FRECUENCIAS = "%c: %7d%n";

    /**
     * Método que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
     * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista
     * de las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
     * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
     * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
     *
     * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto
     * de apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves,
     * diéresis y cedillas), se consideran como ocurrencias de la letra correspondiente sin
     * diacríticos.
     *
     * @param args
     *            no utilizado.
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Se solicita al usuario que escriba el path del fichero a leer
        System.out.print("Nombre de un fichero de texto: ");
        String pathFichero = scanner.nextLine();

        // Se cierra el Scanner al finalizar
        scanner.close();
        
        // Se crea el objeto contador asociado al fichero que se desea leer
        File fichero = new File(pathFichero);
        ContadorDeLetras contador = new ContadorDeLetras(fichero);

        //Se realiza la cuenta
        int[] arrayContador = contador.frecuencias();

        System.out.print("\n");

        char letra = 'A';

        // Se recorre el array de frecuencias e se imprime cada letra con su frecuencia
        for (int i = 0; i < arrayContador.length - 1; i++) {

            if(i == 14){

                System.out.print("Ñ:");
                System.out.printf("%8d\n", arrayContador[26]);

            }

            System.out.print(letra + ":");
            System.out.printf("%8d\n", arrayContador[i]);
            letra++;

            
        }

        System.out.print("\n");
    }
}
