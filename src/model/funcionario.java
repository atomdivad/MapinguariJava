package model;

public class funcionario{
    private String cpf;
    private String nome;
    private String data_nascimento;
    private String telefone;
    private int flag_ativo;
    private String uf;
    private String cidade;
    private String rua;
    private String ap;
    private String lote;
    private String cargo_nome;
    private String senha;

    public funcionario(){
    }    
    public funcionario(String cpf, String nome, String data_nascimento, String telefone, int flag_ativo, String uf, String cidade, String rua, String ap, String lote, String cargo_nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.flag_ativo = flag_ativo;
        this.uf = uf;
        this.cidade = cidade;
        this.rua = rua;
        this.ap = ap;
        this.lote = lote;
        this.cargo_nome = cargo_nome;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getFlag_ativo() {
        return flag_ativo;
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

    public String getCargo_nome() {
        return cargo_nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFlag_ativo(int flag_ativo) {
        this.flag_ativo = flag_ativo;
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

    public void setCargo_nome(String cargo_nome) {
        this.cargo_nome = cargo_nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        return (funcionario)super.clone();
//    }
}
