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
import rojie.poo.ifsc.P1.TarefasEspera;
import rojie.poo.ifsc.P1.TarefasRealizadas;

public class ControllerMinhasTarefas implements Initializable, InterfaceTherad{

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


		
	}
	private ObservableList<TarefasEspera> listaEspera(List<TarefasEspera> list) {
		return FXCollections.observableArrayList(list);
	}
	private ObservableList<TarefasRealizadas> listaReal(List<TarefasRealizadas> list) {
		return FXCollections.observableArrayList(list);
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
	@Override
	public void setResposta(String resposta) {
		// TODO Auto-generated method stub
		String[] tarefas = resposta.split("@");
		String[] tarefasReal = tarefas[0].split("/");
		String[] tarefasEspera = tarefas[1].split("/");
		
		List<TarefasRealizadas> listReal = new ArrayList<TarefasRealizadas>();
		for(String tarefa : tarefasReal){
			listReal.add(new TarefasRealizadas(tarefa.split("-")[0], tarefa.split("-")[1]));
		}
		tblTarefasReal.setItems(listaReal(listReal));
		
		List<TarefasEspera> listEspe = new ArrayList<TarefasEspera>();
		for(String tarefa : tarefasEspera){
			listEspe.add(new TarefasEspera(tarefa.split("-")[0], tarefa.split("-")[1]));
		}
		tblTarefasEsper.setItems(listaEspera(listEspe));
		
	}
}
