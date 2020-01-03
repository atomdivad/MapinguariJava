package model;

public class login {
    private String cpf;
    private String senha;

    public login(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
