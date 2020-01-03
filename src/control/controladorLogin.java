package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.funcionario;
import model.funcionarioDAO;
import model.login;
import model.loginDAO;
import view.LoginFrame;
public class controladorLogin {
    private LoginFrame lf;
    public String cpf_static;
    public controladorLogin() {
        lf = new LoginFrame(new TrataEventosFrameLogin());
    }
    private class TrataEventosFrameLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            switch(comando){
                case "Entrar":
                    login dados = new login(lf.getUsuario(),lf.getSenha());
                    loginDAO loginCheca = new loginDAO();
                    funcionarioDAO fd = new funcionarioDAO();
                    funcionario f = fd.buscaFuncionario(lf.getUsuario());
                    int verifica = loginCheca.valida(dados);
                    if(verifica == 0){
                        lf.setVisible(false);
                        //MedicoFrame mf = new MedicoFrame();
                        switch(f.getCargo_nome())
                        {
                            case "Médico":
                                controladorFrameMedico fm = new controladorFrameMedico(f);
                                break;
                            case "Secretária":
                                controladorFrameSecretaria sf = new controladorFrameSecretaria(f);
                                break;
                        }
                        
                        
                    }else{
                       JOptionPane.showMessageDialog(null,"Dados incorretos");
                    }
                    
                    break;
                case "Limpar":
                    lf.setjTextFieldSenha("");
                    lf.setjTextFieldUsuario("");
                    break;
            }
        }
        
    }
    public String getSecretaria(){
        return lf.getUsuario();
    }
    
}
