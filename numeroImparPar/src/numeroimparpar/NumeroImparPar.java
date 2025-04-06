/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numeroimparpar;

import javax.swing.JOptionPane;

/**
 *
 * @author Dohms
 */
public class NumeroImparPar {

    public static void main(String[] args) {      
        mostrarResultado(verificaPar(solicitaNumero()));  
    }
    
    public static int solicitaNumero(){
       int numero = 0;
       numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um valor: "));
       return numero;
    }
    
    public static boolean verificaPar(int numero){
        if(numero%2==0){return true;}
        else{return false;}
    }

    public static void mostrarResultado(boolean verificaPar){
        if(verificaPar){JOptionPane.showMessageDialog(null,"O valor é par");}
        else{JOptionPane.showMessageDialog(null,"O valor é impar.");}
    }
}     


