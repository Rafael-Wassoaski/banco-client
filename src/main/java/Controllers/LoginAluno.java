package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.AlunoDAO;
import database.Main;
import database.ProfessorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;
import model.Professor;
import rojie.poo.ifsc.P1.App;

public class LoginAluno implements Initializable {
	

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtSenha;

	@FXML
	private Button btnLogin;
	
	@FXML
	private Label mensagemSistema;

	@FXML
	private Button btnCadastro;

	@FXML
	private ComboBox<String> cmbSelectDB;

	public ObservableList<String> listCbox = FXCollections.observableArrayList("Aluno", "Professor");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbSelectDB.setItems(listCbox);

	}
	
	public void setmensagemSistema(String newmensagemSistema) {
		mensagemSistema.setText(newmensagemSistema);
	}

	@FXML
	public void Cadastro() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("cadastro");
		controller.conectar("Cursos");
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnCadastro.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void EntrarAluno(ActionEvent e) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("mainAluno");
		controller.conectar("Login-Aluno@"+txtLogin.getText().toString()+"-"+txtSenha.getText().toString());
		Main.alunoLogin.setLogin(txtLogin.getText().toString());
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnLogin.getScene().getWindow();
		stage.close();
		
	}

	@FXML
	public void EntrarProfessor(ActionEvent e) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("mainProfessor");
		controller.conectar("Login-Professor@"+txtLogin.getText().toString()+"-"+txtSenha.getText().toString());
		Main.professorLogin.setLogin(txtLogin.getText().toString());
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnLogin.getScene().getWindow();
		stage.close();
		

	}

	@FXML
	public void SelectDB(ActionEvent event) throws IOException {

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (cmbSelectDB.getValue().contentEquals("Aluno")) {
					try {
						EntrarAluno(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (cmbSelectDB.getValue().contentEquals("Professor")) {
					try {
						EntrarProfessor(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
	}

}
