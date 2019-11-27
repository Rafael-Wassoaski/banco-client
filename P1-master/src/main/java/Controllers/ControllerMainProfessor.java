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
import rojie.poo.ifsc.P1.AtestadoMatricula;
import rojie.poo.ifsc.P1.Materias;

public class ControllerMainProfessor implements Initializable{

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
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	colMatérias.setCellValueFactory(new PropertyValueFactory<>("nome"));

		tblMain.setItems(listaMaterias());
		
	}
    private ObservableList<Materias> listaMaterias() {
		return FXCollections.observableArrayList(new Materias("Analise de Sistemas"),
				new Materias("Programação Orientada a Objetos"),
				new Materias("Gerenciamento de Softwtare"),
				new Materias("Sistemas Operacionais"),
				new Materias("Programação Web"));
    }

    @FXML
    void Chamada(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Chamada.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Lista(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("lista.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    
    }

    @FXML
    void Sair(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage = (Stage) btnSair.getScene().getWindow();
		stage.close();
    
    }

	
}