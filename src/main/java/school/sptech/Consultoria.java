package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack (DesenvolvedorWeb desenvolvedorWeb){
        if (desenvolvedorWeb.isFullstack()){
            desenvolvedores.add(desenvolvedorWeb);
        }
    }

    public Double getTotalSalarios(){
        Double tmp = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            tmp += desenvolvedor.calcularSalario();
        }
        return tmp;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int tmp = 0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                tmp++;
            }
        }
        return tmp;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> tmp = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                tmp.add(desenvolvedor);
            }
        }
        return tmp;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor tmp = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() < tmp.calcularSalario()){
                tmp = desenvolvedor;
            }
        }
        return tmp;
    }
    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> tmp = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)
                ){
                    tmp.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia)
                ){
                    tmp.add(desenvolvedor);
                }

            }
        }
        return tmp;
    }
    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double tmp = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)
                ){
                    tmp += desenvolvedor.calcularSalario();
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia)
                ){
                    tmp += desenvolvedor.calcularSalario();
                }

            }
        }
        return tmp;

    }
}