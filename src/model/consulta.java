package model;
public class consulta {
    private funcionario medico;
    private funcionario secretaria;
    private paciente pac;
    private String descricao_consulta;
    private String prescricao_consulta;
    private int flag_finalizada;
    private String hora_consulta;
    private String data_consulta;
    
    public consulta() {
    }

    public consulta(funcionario medico, funcionario secretaria, paciente pac, String descricao_consulta, String prescricao_consulta, int flag_finalizada, String hora_consulta, String data_consulta) {
        this.medico = medico;
        this.secretaria = secretaria;
        this.pac = pac;
        this.descricao_consulta = descricao_consulta;
        this.prescricao_consulta = prescricao_consulta;
        this.flag_finalizada = flag_finalizada;
        this.hora_consulta = hora_consulta;
        this.data_consulta = data_consulta;
    }

    public funcionario getMedico() {
        return medico;
    }

    public funcionario getSecretaria() {
        return secretaria;
    }

    public paciente getPac() {
        return pac;
    }

    public String getDescricao_consulta() {
        return descricao_consulta;
    }

    public String getPrescricao_consulta() {
        return prescricao_consulta;
    }

    public int getFlag_finalizada() {
        return flag_finalizada;
    }

    public String getHora_consulta() {
        return hora_consulta;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setMedico(funcionario medico) {
        this.medico = medico;
    }

    public void setSecretaria(funcionario secretaria) {
        this.secretaria = secretaria;
    }

    public void setPac(paciente pac) {
        this.pac = pac;
    }

    public void setDescricao_consulta(String descricao_consulta) {
        this.descricao_consulta = descricao_consulta;
    }

    public void setPrescricao_consulta(String prescricao_consulta) {
        this.prescricao_consulta = prescricao_consulta;
    }

    public void setFlag_finalizada(int flag_finalizada) {
        this.flag_finalizada = flag_finalizada;
    }

    public void setHora_consulta(String hora_consulta) {
        this.hora_consulta = hora_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }
}
