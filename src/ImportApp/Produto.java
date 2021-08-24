package ImportApp;

public class Produto {
    private int id;
    private String nome;
    private float precoUnitario;
    private int unidade;




    public String getNome(){    return nome;    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public float getPrecoUnitario(){    return precoUnitario;   }
    public void setPrecoUnitario(float precoUnitario){
        this.precoUnitario = precoUnitario;
    }

    public int getUnidade(){    return unidade;  }
    public void setUnidade(int unidade){
        this.unidade = unidade;
    }

    public int getId(){      return id;    }
    public void setId(int id){
        this.id = id;
    }

    //Construtor padrão
    public Produto() {  }

    //Construtor do produto
    public Produto(String nome, float precoUnitario, int unidade, int id){
        nome = this.nome;
        precoUnitario = this.precoUnitario;
        unidade = this.unidade;
        id = this.id;

    }

    @Override
    public String toString(){
        return "NOME: " + nome + "\n"
                +"PREÇO UNITÁRIO: R$" + precoUnitario + "\n"
                +"QUANTIDADE EM ESTOQUE: " + unidade + "\n";
    }




}
