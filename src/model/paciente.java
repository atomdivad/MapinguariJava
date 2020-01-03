package model;

public class paciente {
    private String cpf;
    private int rg;
    private String nome;
    private String data_nascimento;
    private String uf;
    private String cidade;
    private String rua;
    private String ap;
    private String lote;
    private int numero_consultas_realizadas;
    private String telefone;
    public paciente(){
        
    }
    public paciente(String cpf, int rg, String nome, String data_nascimento, String uf, String cidade, String rua, String ap, String lote, int numero_consultas_realizadas, String telefone) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.uf = uf;
        this.cidade = cidade;
        this.rua = rua;
        this.ap = ap;
        this.lote = lote;
        this.numero_consultas_realizadas = numero_consultas_realizadas;
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setNumero_consultas_realizadas(int numero_consultas_realizadas) {
        this.numero_consultas_realizadas = numero_consultas_realizadas;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getUf() {
        return uf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getAp() {
        return ap;
    }

    public String getLote() {
        return lote;
    }

    public int getNumero_consultas_realizadas() {
        return numero_consultas_realizadas;
    }

    public String getTelefone() {
        return telefone;
    }
}
