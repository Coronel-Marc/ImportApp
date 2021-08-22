package ImportApp;

abstract class Item {
    private int id;
    private String nome;
    private float precoUnitario;
    private int unidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public Item(String nome, float precoUnitario, int unidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
    }

}
