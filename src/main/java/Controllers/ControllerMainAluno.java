package Controllers;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rojie.poo.ifsc.P1.App;
public class ControllerMainAluno {

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
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("minhasTarefas.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnMinhasTurmas.getScene().getWindow();
			stage.close();
	    }

	    @FXML
	    public void MinhasTurmas() throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("minhasTurmas.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnMinhasTurmas.getScene().getWindow();
			stage.close();
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
	  

}
