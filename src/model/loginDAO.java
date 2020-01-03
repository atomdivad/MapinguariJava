package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class loginDAO {
     login l;
     public loginDAO(){   
     }
     public int valida(login l){
         this.l = l;
         Connection c = FabricaConexoes.getConnection();
         String sql = "select cpf,senha from funcionario where cpf=? and senha=?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, l.getCpf());
            stmt.setString(2, l.getSenha());
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next() != true){
                            System.out.println("Usuario nao encontrado");
                            return 1;
            }
            

            
            return 0;
         }catch(SQLException e){
             return 1;
         }

     }
     
//     public funcionario logar(){
//         Connection c;
//         c = FabricaConexoes.getConnection();
//     }
       
    
}
