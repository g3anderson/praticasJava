
package levantamentoDePerfilQuadroDefuncionarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class levantamentoDePerfilQuadroDefuncionarios {


    public static void main(String[] args) {
        
        ArrayList<Candidato> listaCandidatos = new ArrayList<>();
        boolean encerrar = false;
            
                while(true){
                
                    Candidato novoCandidato = new Candidato();
                    
                    novoCandidato.receberValores(solicitarIdade(), solicitarAreaAtuacao(), solicitarExperiencia());
                    
                    listaCandidatos.add(novoCandidato);
                    
                     encerrar = encerrarEtapa();
                    
                        if(encerrar == true){
                        break;
                    
                        }  
                
                }
                            
        mostrarResultados(listaCandidatos);
        
    }
  
    
    
    public static int solicitarIdade(){
    
    int idade = 0;
     
        while(true){
        
            try {             
                idade = Integer.parseInt(JOptionPane.showInputDialog("Por favor, informe a idade do candidato: "));
                break;
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Valor inválido, por favor, digite somente valores inteiros: ");
                
            }
            
        }
        
        return idade;
        
    }
    
   
    
    
    public static boolean solicitarExperiencia(){  
        int experiencia = JOptionPane.showConfirmDialog(null,"O candidato possue alguma experiência? ","Experiência candidato", JOptionPane.YES_NO_OPTION);
        
        if(experiencia == 0){
        return true;
                
        }
        
        else return false;
    }
    
    
    
    
    public static String solicitarAreaAtuacao(){
     
        String areaAtuacao;
        
            while(true){
                
                areaAtuacao = JOptionPane.showInputDialog("Qual seria a área de atuação do candidato? \n" +
                                                  "Digite 'I' para Indústria \n" +
                                                  "Digite 'C' para Comércio \n" +
                                                  "Digite 'S' para Serviços:").toLowerCase();
                
                if(areaAtuacao.equals("i") || areaAtuacao.equals("c")|| areaAtuacao.equals("s")){
                    break;
                }
                
                else JOptionPane.showInputDialog("Opção inválida, por favor, digite somente as letras informadas.");
                
            }
 
        return areaAtuacao;
    }
    
    
    
    
    public static boolean encerrarEtapa(){
    
        int novaConsulta = JOptionPane.showConfirmDialog(null,"Você gostaria de adicionar um novo candidato, ou passamos para a próxima etapa?","Adicionar mais candidatos?",JOptionPane.YES_NO_OPTION);
        
            if(novaConsulta == 1){
            return false;
        
            }
        
        else return true;
    
    }
    
    
    public static int cadidatosComExperiencia(ArrayList<Candidato> listaCandidatos){
    
        int candidatosComExperiencia = 0;
            
            for(Candidato proximoDaFila : listaCandidatos ){
            
                if(proximoDaFila.getTemExperiencia() == true){
                    candidatosComExperiencia += 1;
                    
                }
    
            }
            
        return candidatosComExperiencia;
       
    }
    
    public static float mediaIdadesCadidatosIndustriaExperiencia(ArrayList<Candidato> listaCandidatos){
    
        float candidatosIndustriaComExp = 0;
        float somaIdades = 0;
        
            for(Candidato proximoDaFila : listaCandidatos){
            
                if(proximoDaFila.getTemExperiencia() == true && proximoDaFila.getAreaDeAtuacao().equals("i")){
                    somaIdades += proximoDaFila.getIdadeCandidato();
                    candidatosIndustriaComExp += 1;
                    
                }
            
            }
        
            if(listaCandidatos.isEmpty() || candidatosIndustriaComExp == 0){
            
                return 0;
            }
            
            else return (somaIdades/candidatosIndustriaComExp);
    
    }
    
    
    
    public static int menorIdadeCadidatoServicoSemExperiencia(ArrayList<Candidato> listaCandidatos){
    
        int menorIdadeCandidatosServicosSemExp = 999;
        
            for(Candidato proximoDaFila : listaCandidatos){
            
                if(proximoDaFila.getTemExperiencia() == false && proximoDaFila.getAreaDeAtuacao().equals("s") && proximoDaFila.getIdadeCandidato() < menorIdadeCandidatosServicosSemExp){
                
                    menorIdadeCandidatosServicosSemExp = proximoDaFila.getIdadeCandidato();
                    
                }
            
            }
        
            if(menorIdadeCandidatosServicosSemExp == 999){
         
                menorIdadeCandidatosServicosSemExp = 0;
            }
         return menorIdadeCandidatosServicosSemExp;
    
    }
    
    public static String areaComMaisCandidatos(ArrayList<Candidato> listaCandidatos){
    
        int industria = 0, servicos = 0, comercio = 0;
        String maisBucada;
            
            for(Candidato cadidato : listaCandidatos){
            
                switch(cadidato.getAreaDeAtuacao()){
                    
                    case "i":
                        
                        industria += 1;
                        break;
                        
                    case "s":
                        
                        servicos += 1;
                        break;
                        
                    case "c":
                        
                        comercio += 1;
                        break;
                
                }
                
            }
            
            if(industria>servicos && industria> comercio){
            
                return maisBucada = "Industria";
                
            }
            
            else if(servicos > industria && servicos> comercio) {return maisBucada = "servicos";}
                
            else if(comercio > industria && comercio > servicos){return maisBucada = "comércio";}
            
            else return maisBucada = "Nenhuma área foi a mais buscada.";
    
    }
            
    
    public static void mostrarResultados(ArrayList <Candidato> listaCandidatos){
    
        JOptionPane.showMessageDialog(null,"Resultados finais da pesquisa: \n\n"+
                                           "Candidatos com experiência: "+cadidatosComExperiencia(listaCandidatos)+"\n"+
                                           "Idade média de candidatos com experiência que querem atuar na indústria: "+mediaIdadesCadidatosIndustriaExperiencia(listaCandidatos)+"\n"+
                                           "Menor idade dos candidatos sem experiência que querem atuar em serviços: "+menorIdadeCadidatoServicoSemExperiencia(listaCandidatos)+"\n"+
                                           "Área de atuação mais buscada: "+areaComMaisCandidatos(listaCandidatos));
    
    }
    
    
}
    


