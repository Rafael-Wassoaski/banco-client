package Controllers;

import java.io.IOException;
import java.net.URL;
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
import rojie.poo.ifsc.P1.App;
import rojie.poo.ifsc.P1.TarefasEspera;
import rojie.poo.ifsc.P1.TarefasRealizadas;

public class ControllerMinhasTarefas implements Initializable{

	@FXML
    private TableView<TarefasEspera> tblTarefasEsper;

    @FXML
    private TableColumn<TarefasEspera, String> colAssuntoEspera;

    @FXML
    private TableColumn<TarefasEspera, String> colMateriaEspera;

    @FXML
    private TableView<TarefasRealizadas> tblTarefasReal;

    @FXML
    private TableColumn<TarefasRealizadas, String> colAssuntoReal;

    @FXML
    private TableColumn<TarefasRealizadas, String> colMateriaReal;


    @FXML
    private Button btnVoltar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colAssuntoEspera.setCellValueFactory(new PropertyValueFactory<>("assuntoE"));
		colMateriaEspera.setCellValueFactory(new PropertyValueFactory<>("materiaE"));
		colAssuntoReal.setCellValueFactory(new PropertyValueFactory<>("assuntoR"));
		colMateriaReal.setCellValueFactory(new PropertyValueFactory<>("materiaR"));

		tblTarefasEsper.setItems(listaEspera());
		tblTarefasReal.setItems(listaReal());
		
	}
	private ObservableList<TarefasEspera> listaEspera() {
		return FXCollections.observableArrayList(new TarefasEspera("Desenvolver Telas no JAVAFX", "Programação Orientada a Objetos"),
				new TarefasEspera("Documentação de um Projeto",  "Gerencia de Projetos"),
				new TarefasEspera("Desenvolver um Escalonador", "Sistemas Operacionais"));
	}
	private ObservableList<TarefasRealizadas> listaReal() {
		return FXCollections.observableArrayList(new TarefasRealizadas("Criar Banco de Dados no Sqlite", "Programação Orientada a Objetos"),
				new TarefasRealizadas("Fluxograma",  "Gerencia de Projetos"),
				new TarefasRealizadas("Desenvolver Relógio/Cronômetro/Alarme", "Sistemas Operacionais"));
	}
	
    @FXML
    void Voltar(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainAluno.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage = (Stage) btnVoltar.getScene().getWindow();
		stage.close();
		
    
    }
}
