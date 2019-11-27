package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import rojie.poo.ifsc.P1.App;
import rojie.poo.ifsc.P1.AtestadoMatricula;
import rojie.poo.ifsc.P1.MinhasTurmas;

public class ControllerMinhasTurmas implements Initializable {
	
	@FXML
	private TableView<MinhasTurmas> tblTurmas;
	
	@FXML
	private TableColumn<MinhasTurmas, String> colMaterias;

	@FXML
	private TableColumn<MinhasTurmas, String> colProfessor;

	@FXML
	private Button btnVoltar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colMaterias.setCellValueFactory(new PropertyValueFactory<>("materia"));
		colProfessor.setCellValueFactory(new PropertyValueFactory<>("professor"));

		tblTurmas.setItems(listaTurmas());
		
	}
	private ObservableList<MinhasTurmas> listaTurmas() {
		return FXCollections.observableArrayList(new MinhasTurmas( "ADMINISTRAÇÃO GERAL","Jeffersson Treml"),
				new MinhasTurmas( "GERÊNCIA DE PROJETOS", "Carlos"),
				new MinhasTurmas( "METODOLOGIA DA PESQUISA", "Lucas Bueno"),
				new MinhasTurmas( "PROGRAMAÇÃO ORIENTADA A OBJETOS II","Lucas Bueno"),
				new MinhasTurmas( "PROGRAMAÇÃO PARA INTERNET I","Alexandre"),
				new MinhasTurmas( "SISTEMAS OPERACIONAIS","Mauricio Begini"));
	
		
	}
	@FXML
	public void Voltar() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainAluno.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnVoltar.getScene().getWindow();
		stage.close();
	}

	

}
