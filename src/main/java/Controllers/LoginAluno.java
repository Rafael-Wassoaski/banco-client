package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.AlunoDAO;
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
	private Button btnCadastro;

	@FXML
	private ComboBox<String> cmbSelectDB;

	public ObservableList<String> listCbox = FXCollections.observableArrayList("Aluno", "Professor");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbSelectDB.setItems(listCbox);

	}

	@FXML
	public void Cadastro() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnCadastro.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void EntrarAluno(ActionEvent e) throws IOException {
		AlunoDAO aluno1 = new AlunoDAO();
		Aluno aluno = aluno1.getAluno(txtLogin.getText().toString());
		if (aluno != null)
			if (txtLogin.getText().toString().equals(aluno.getLogin())&& txtSenha.getText().toString().equals(aluno.getSenha())) {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainAluno.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			stage = (Stage) btnLogin.getScene().getWindow();
		}
	}

	@FXML
	public void EntrarProfessor(ActionEvent e) throws IOException {
		ProfessorDAO professor1 = new ProfessorDAO();
		Professor professor = professor1.getProfessor(txtLogin.getText().toString());
		if (professor != null) {
			if (txtLogin.getText().toString().equals(professor.getLogin())&& txtSenha.getText().toString().equals(professor.getSenha())) {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainProfessor.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnLogin.getScene().getWindow();
		stage.close();
			}
		}else System.out.println("é nulo");
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
