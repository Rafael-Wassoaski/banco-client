package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import model.InterfaceTherad;
import rojie.poo.ifsc.P1.App;
import rojie.poo.ifsc.P1.AtestadoMatricula;
import rojie.poo.ifsc.P1.MinhasTurmas;

public class ControllerMinhasTurmas implements Initializable, InterfaceTherad {
	
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

		
		
	}
	private ObservableList<MinhasTurmas> listaTurmas(List<MinhasTurmas> list) {
		return FXCollections.observableArrayList(list);
	
		
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
	@Override
	public void setResposta(String resposta) {
		// TODO Auto-generated method stub
		String[] turmas = resposta.split("/");
		List<MinhasTurmas> minhasTurmas = new ArrayList<MinhasTurmas>();
		for(String turma : turmas) {
			minhasTurmas.add(new MinhasTurmas(turma.split("-")[0], turma.split("-")[1]));
		}		
		tblTurmas.setItems(listaTurmas(minhasTurmas));
	}

	

}
