package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.InterfaceTherad;
import rojie.poo.ifsc.P1.App;
import rojie.poo.ifsc.P1.AtestadoMatricula;
import rojie.poo.ifsc.P1.Materias;
import rojie.poo.ifsc.P1.TarefasEspera;

public class ControllerMainProfessor implements Initializable, InterfaceTherad{

    @FXML
    private TableView<Materias> tblMain;

    @FXML
    private TableColumn<Materias, String> colMatérias;

    @FXML
    private Button btnLista;

    @FXML
    private Button btnChamada;

    @FXML
    private Button btnSair;
    
    private String mensagemSistema = null;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colMatérias.setCellValueFactory(new PropertyValueFactory<>("nome"));

	
		
	}
    private ObservableList<Materias> listaMaterias(List<Materias> list) {
		return FXCollections.observableArrayList(list);
    }

    @FXML
    void Chamada(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("Chamada");
		controller.conectar("minhaLista@");
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage = (Stage) btnLista.getScene().getWindow();
		stage.close();
		stage.show();
		
    }

    @FXML
    void Lista(ActionEvent event) throws IOException {
    	
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("lista");
		controller.conectar("minhaLista@");
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnLista.getScene().getWindow();
		stage.close();
    	
    
    
    }

    @FXML
    void Sair(ActionEvent event) throws IOException {
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
		stage = (Stage) btnSair.getScene().getWindow();
		stage.close();
    
    }
	@Override
	public void setResposta(String resposta) {
		// TODO Auto-generated method stub
		if(resposta.split("@")[0].equals("errado")) {
			this.mensagemSistema = "Login incorreto";
			btnSair.fire();
			
		}else {
			String[] materiasFormatadas = resposta.split("@")[1].split("/");
			List<Materias> materias = new ArrayList<Materias>();
			for(String materia : materiasFormatadas) {
				materias.add(new Materias(materia));
			}
				tblMain.setItems(listaMaterias(materias));
			
		}
		
	}

	
}