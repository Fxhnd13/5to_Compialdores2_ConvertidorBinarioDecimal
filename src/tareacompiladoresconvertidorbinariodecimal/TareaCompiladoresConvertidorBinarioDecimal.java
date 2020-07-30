/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareacompiladoresconvertidorbinariodecimal;

import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose_
 */
public class TareaCompiladoresConvertidorBinarioDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese un valor binario fraccionario: ");
            String cadena = sc.nextLine();
            Lexer lexer = new Lexer(new StringReader(cadena));
            parser parserr = new parser(lexer);
            Double respuesta = (Double) parserr.parse().value;
            System.out.println("La respuesta de la conversion es: "+respuesta);
        } catch (Exception ex) {
            Logger.getLogger(TareaCompiladoresConvertidorBinarioDecimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
