package GestionadorTextos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class GestionadorTextos {

    /**
     * Lee las lineas pares del texto
     *
     * @param rutaTexto
     * @return String
     */
    public String leerPrimerTexto(String rutaTexto) throws FileNotFoundException, IOException {
        File f = new File(rutaTexto);
        if (f.exists()) {
            String linea;
            String texto = "";
            FileReader fr = new FileReader(rutaTexto);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                br.readLine();
                texto = texto + linea + "\n";
            }
            return texto;
        }
        return "El texto está vacío";
    }

    /**
     * Lee el texto sin saltos de linea
     *
     * @param rutaTexto
     * @return String
     */
    public String leerSegundoTexto(String rutaTexto) throws FileNotFoundException, IOException {
        File f = new File(rutaTexto);
        if (f.exists()) {
            String linea;
            String texto = "";
            FileReader fr = new FileReader(rutaTexto);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                texto = texto + linea;
            }
            return texto;
        }
        return "El texto está vacío";
    }
}