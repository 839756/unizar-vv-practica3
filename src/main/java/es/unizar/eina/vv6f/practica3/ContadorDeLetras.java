package es.unizar.eina.vv6f.practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

/**
 * Clase para el análisis de la frecuencia de aparición de letras del alfabeto español en un
 * fichero de texto. Los objetos de esta clase se construyen utilizando como argumento un objeto de
 * la clase File que representa el fichero de texto que se quiere analizar. La primera invocación al
 * método frecuencias() analiza el contenido del fichero de texto y, si se ha podido procesar,
 * devuelve un vector de siempre 27 componentes de tipo entero. Las primeras 26 componentes
 * almacenan el número de apariciones de las 26 letras del alfabeto inglés. La última componente
 * almacena el número de apariciones de la letra Ñ.
 *
 * No se distingue entre mayúsculas y minúsculas. En español, la letra Ñ es una letra distinta a la
 * N. El resto de apariciones de letras voladas y caracteres con diacríticos (acentos agudos,
 * graves, diéresis, cedillas), se consideran como ocurrencias de la letra correspondiente sin
 * diacríticos.
 *
 */
public class ContadorDeLetras {
    private File fichero;
    private int[] frecuencias;

    /**
     * Construye un ContadorDeLetras para frecuencias la frecuencia en las que aparecen las letras
     * del fichero «fichero».
     * @param fichero
     *            fichero de texto cuyo contenido será analizado.
     */
    public ContadorDeLetras(File fichero) {
        this.fichero = fichero;
        this.frecuencias = null;
    }

    /**
     * Si no ha sido analizado ya, analiza el contenido del fichero de texto asociado a este
     * objeto en el constructor. Devuelve un vector de 27 componentes con las frecuencias
     * absolutas de aparición de cada letra del alfabeto español en el fichero.
     *
     * @return vector de 27 componentes de tipo entero. Las primeras 26 componentes almacenan el
     *         número de apariciones de las 26 letras del alfabeto inglés: la componente indexada
     *         por 0 almacena el número de apariciones de la letra A, la componente indexada por 1,
     *         el de la letra B y así sucesivamente. La última componente, almacena el número de
     *         apariciones de la letra Ñ.
     * @throws FileNotFoundException
     *             si el fichero de texto que se especificó al construir este objeto no existe o no
     *             puede abrirse.
     */
    public int[] frecuencias() throws FileNotFoundException {
        
        if (!this.fichero.exists() || !this.fichero.canRead()) {

            throw new FileNotFoundException();

        } else {
            
            if (this.frecuencias == null) {
                this.frecuencias = new int[27];

                try {
                    // Se crea un FileReader para leer el archivo
                    FileReader fileReader = new FileReader(fichero);

                    // Se crea un BufferedReader para leer líneas de texto
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    // Se lee el fichero caracter por caracter
                    int caracter;
                    while ((caracter = bufferedReader.read()) != -1) {

                        // Se pasa a minusculas
                        char c = Character.toLowerCase((char) caracter);    

                        if ( c == 'ñ' ) { // Se comprueban los casos de ñ, º y ª

                            this.frecuencias[26]++;

                        } else if ( c == 'º' ){

                            this.frecuencias[14]++;

                        } else if ( c == 'ª' ){

                            this.frecuencias[0]++;

                        } else {    // Se comprueban los demás casos eliminando diacríticos

                            c = Normalizer.normalize(Character.toString(c), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").charAt(0);

                            if ( c >= 'a' && c <= 'z'){

                                this.frecuencias[c - 'a'] ++;

                            }  
                            
                        }

                    }

                    // Se cierra el BufferedReader
                    bufferedReader.close();

                } catch (IOException e) {
                    System.err.println("Error al leer el fichero: " + e.getMessage());
                }


            }
            return this.frecuencias;
        }

       
    }
}
