package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import database.AlunoDAO;
import database.ProfessorDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aluno;
import model.InterfaceTherad;
import model.Professor;
import rojie.poo.ifsc.P1.App;


public class ListaController implements Initializable, InterfaceTherad{
	
	@FXML
    private ListView<Professor> listProfessor;

    @FXML
    private ListView<Aluno> listAluno;

    @FXML
    private Button btnApagarProf;

    @FXML
    private Button btnAtualizarProf;

    @FXML
    private Button btnApagarAlu;

    @FXML
    private Button btnAtualizarAlu;

    @FXML
    private Button btnSair;
 
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	//updateListProfessor();
    	//updateListAluno();
    	
		
	}
    public void updateListProfessor() {	
 		ProfessorDAO die = new ProfessorDAO();
 		listProfessor.setItems(null);
 		listProfessor.setItems((ObservableList<Professor>) die.getAll());
 		
 	}
     
    public void updateListAluno() {
 		AlunoDAO dao = new AlunoDAO();	
 		listAluno.setItems(null);
 		listAluno.setItems((ObservableList<Aluno>) dao.getAll());
 		
 	}
  

    @FXML
    void ApagarAluno(ActionEvent event) throws IOException {
    	String menssagem = "apagarAluno@" + listAluno.getSelectionModel().getSelectedItem().getCpf().toString();
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("lista");
		controller.conectar(menssagem);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnApagarAlu.getScene().getWindow();
		stage.close();
    }
    @FXML
    void ApagarProfessor() throws IOException {
    
    	
    	String menssagem = "apagarProfessor@" + listAluno.getSelectionModel().getSelectedItem().getCpf().toString();
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("lista");
		controller.conectar(menssagem);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnApagarAlu.getScene().getWindow();
		stage.close();
    	new ProfessorDAO().delete((Professor) listProfessor.getSelectionModel().getSelectedItem());
    }

    @FXML
    void AtualizarAluno(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("update.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

		UpdateController controller = (UpdateController) fxmlLoader.getController();
		controller.selectedAluno(listAluno.getSelectionModel().getSelectedItem(), this);
	}
    @FXML
    void AtualizarProfessor(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("update.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

		UpdateController controller = (UpdateController) fxmlLoader.getController();
		controller.selectedProfessor(listProfessor.getSelectionModel().getSelectedItem(), this);
	}
    

    @FXML
    void Sair(ActionEvent event) {
    	Platform.exit();
    }
    @FXML
    void Voltar(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.close();
    
    }
	@Override
	public void setResposta(String resposta) {
		// TODO Auto-generated method stub
		
		List<Professor> professoresList = new ArrayList<>();
		List<Aluno> alunosList = new ArrayList<>();
		String[] professoresAlunos = resposta.split("@");
		String[] professores = professoresAlunos[0].split("/");
		String[] alunos =  professoresAlunos[1].split("/");
		for(String professor : professores) {
			String[] professorFormatado = professor.split("-");
			Professor professor2 = new Professor(professorFormatado[0], professorFormatado[1], professorFormatado[2], professorFormatado[3], professorFormatado[4]);
			professoresList.add(professor2);
			
		}
		
		ObservableList<Professor> listProf = FXCollections.observableList(professoresList);
		listProfessor.setItems(null);
 		listProfessor.setItems((ObservableList<Professor>) listProf);
		for(String aluno : alunos) {
			String[] alunorFormatado = aluno.split("-");
			Aluno aluno2 = new Aluno(alunorFormatado[0], alunorFormatado[1], alunorFormatado[2], alunorFormatado[3], alunorFormatado[4]);
			alunosList.add(aluno2);
			
		}
		ObservableList<Aluno> listAlun = FXCollections.observableList(alunosList);
		listAluno.setItems(null);
 		listAluno.setItems((ObservableList<Aluno>) listAlun);
		
	}
    

	
	

}