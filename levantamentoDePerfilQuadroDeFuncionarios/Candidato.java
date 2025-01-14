
package levantamentoDePerfilQuadroDefuncionarios;


public class Candidato {
    
    private int idadeCandidato;
    private String areaDeAtuacao;
    private boolean temExperiencia;

    public Candidato(){
    
        this.idadeCandidato = 0;
        this.areaDeAtuacao = null;
        this.temExperiencia = false;
        
    }

    public int getIdadeCandidato() {
        return idadeCandidato;
    }

    public void setIdadeCandidato(int idadeCandidato) {
        this.idadeCandidato = idadeCandidato;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public boolean getTemExperiencia() {
        return temExperiencia;
    }

    public void setTemExperiencia(boolean temExperiencia) {
        this.temExperiencia = temExperiencia;
    }
    
    
    
    public void receberValores(int idadeCandidato, String areaDeAtuacao, boolean temExperiencia){
        
        setAreaDeAtuacao(areaDeAtuacao);
        setIdadeCandidato(idadeCandidato);
        setTemExperiencia(temExperiencia);
    
    }
    
}
