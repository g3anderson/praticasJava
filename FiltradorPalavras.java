
package filtadorpalavras;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Um programa básico que processa palavras fornecidas pelo usuário. Ele:
 * - Identifica a menor palavra.
 * - Calcula a média do tamanho das palavras que começam com "X".
 * - Encontra a maior palavra que termina com "R".
 */

public class FiltradorPalavras {

    public static void main(String[] args) {
        
        boolean palavraValida =  false;
        ArrayList<String> listaPalavras = new ArrayList<>();
        ArrayList<String> palavrasX = new ArrayList<>();
        ArrayList<String> palavraR = new ArrayList<>();
        String menorPalavraDigitada = null;
        String palavraMaiorR = null;
        float mediaTamanhoPalavrasX = 0;
        
        
        
        while (true){
        
        String palavraAAdicionar = JOptionPane.showInputDialog("Por favor, informe uma palavra: ");
        
            while(true){
     
                validacaoPalavras(palavraAAdicionar);
               
                if(palavraValida == true){  
                    break;
                    
                }
                
                else{
                    palavraAAdicionar = JOptionPane.showInputDialog("Palavra em branco, por favor, informe uma palavra: ");
                }
                
            }
            
            
            listaPalavras.add(palavraAAdicionar);
            
            menorPalavraDigitada = definidorMenorPalavraDigitada(menorPalavraDigitada, palavraAAdicionar);
                
            
            int continuar = JOptionPane.showConfirmDialog(null,"Você deseja adicionar um novo valor?","Continuar?",JOptionPane.YES_NO_OPTION);
            
                if(continuar == JOptionPane.NO_OPTION){        
                    break;
                    
                }
                
        }
        
        for(String palavra : listaPalavras ){
         
            if(palavra.toLowerCase().charAt(0) == 'x'){
                palavrasX.add(palavra);
                
            }
            
        mediaTamanhoPalavrasX = calcularMediaDePalavrasComX(quantidadeTotalPalavrasComX(palavrasX),quantidadeTotalDeLetrasDasPalavrasX(palavrasX));
        
        }
        
        for(String palavra : listaPalavras) {
        
           int ultimaLetra = palavra.length() - 1;
           
                if(palavra.charAt(ultimaLetra) == 'r'){
                    
                    palavraMaiorR = maiorPalavraDigitadaComFimR(palavra, palavraMaiorR);
                    
                    palavraR.add(palavra);
                
                }
          
        }
        
        
        mostrarResultados(menorPalavraDigitada, palavraMaiorR, mediaTamanhoPalavrasX);
        
        
    }
    
    public static int quantidadeTotalPalavrasComX (ArrayList<String> palavrasX){
    
          int numeroDePalavras =  palavrasX.size();
          
          return numeroDePalavras;
          
    }
    
    public static int quantidadeTotalDeLetrasDasPalavrasX(ArrayList<String> palavrasX){
    
        int numeroLetras = 0;
        
            for(String palavraDaPosicao : palavrasX){
            
               numeroLetras =  numeroLetras + palavraDaPosicao.length();
            
            }
            
        return numeroLetras;
    
    }
    
    public static float calcularMediaDePalavrasComX(int quantidadeTotalPalavras, int totalLetrasDasPalavas){
    
        float floatquantidadeTotalPalavras = (float) quantidadeTotalPalavras;
        float floatTotalLetrasDasPaalavras = (float) totalLetrasDasPalavas;
        
        if(quantidadeTotalPalavras == 0){
            return 0;
        }
        
            return (float) (floatTotalLetrasDasPaalavras/floatquantidadeTotalPalavras);
        
    }
    
    
    
    public static String definidorMenorPalavraDigitada(String menorPalavraDigitada, String palavraAAdicionar){
    
        if (menorPalavraDigitada == null  || menorPalavraDigitada.length() > palavraAAdicionar.length()) {
            
           return palavraAAdicionar;
        }
        
        else return menorPalavraDigitada;
    }
    
    
    
    public static  String maiorPalavraDigitadaComFimR (String palavra, String palavraMaiorR){
    
        if(palavraMaiorR == null || palavra.length() >  palavraMaiorR.length()){
            return palavra;
            
        }
        
        else return palavraMaiorR;
        
    }
    
    public static void mostrarResultados(String menorPalavraDigitada, String palavraMaiorR, float mediaTamanhoPalavrasX){
    
        JOptionPane.showMessageDialog(null, "Menor palavra que foi adicionada: "+menorPalavraDigitada+"\n"+"Media de letras das palavras que começam com X: "+mediaTamanhoPalavrasX+"\n"+"Maior palavra das que terminam com R: "+palavraMaiorR, "Resultados da distribuição de palavras:", 0);
    
    }
    
    public static boolean validacaoPalavras (String palavraAAdicionar){
    
        if(palavraAAdicionar != null){
        
            return true;
        }
        
        else return false;
        
    }
    
 
}
    

