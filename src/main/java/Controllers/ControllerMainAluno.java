package Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.InterfaceTherad;
import rojie.poo.ifsc.P1.App;
public class ControllerMainAluno implements Initializable, InterfaceTherad{

	    @FXML
	    private Button btnMinhasTurmas;

	    @FXML
	    private Button btnAMatricula;

	    @FXML
	    private Button btnMinhasTarefas;

	    @FXML
	    private Button btnMeusDados;
	    
	    @FXML
	    private Button btnManifestacoes;
	    
	    private String mensagemSistema = null;

	    @FXML
	    public void Atestado() throws IOException {
	   	 FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("atestado.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnAMatricula.getScene().getWindow();
			stage.close();
	    }

	    @FXML
	    public void MeusDados() throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnMeusDados.getScene().getWindow();
			stage.close();
	    }

	    @FXML
	    public void MinhasTarefas() throws IOException {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			AguardeController controller = (AguardeController)fxmlLoader.getController();
			controller.setProxTela("minhasTarefas");
			controller.conectar("minhasTarefas@");
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage = (Stage) btnMinhasTarefas.getScene().getWindow();
			stage.close();
			stage.show();
			
	    	
	    }

	    @FXML
	    public void MinhasTurmas() throws IOException {
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			AguardeController controller = (AguardeController)fxmlLoader.getController();
			controller.setProxTela("minhasTurmas");
			controller.conectar("minhasTurmas@");
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage = (Stage) btnMinhasTurmas.getScene().getWindow();
			stage.close();
			stage.show();
	
	    }
	    
	    public void Manifestacoes() throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("contato.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnManifestacoes.getScene().getWindow();
			stage.close();
	    }
	    
	    void Sair() throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			if(mensagemSistema!=null) {
	    		LoginAluno aluno = (LoginAluno) fxmlLoader.getController();
	    		aluno.setmensagemSistema(mensagemSistema);
	    	}
			stage.show();
			stage = (Stage) btnAMatricula.getScene().getWindow();
			stage.close();
	    
	    }

		@Override
		public void setResposta(String resposta) {
			// TODO Auto-generated method stub
			if(resposta.equals("errado")) {
				this.mensagemSistema = "Login incorreto";
				try {
					Sair();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
	  

}
