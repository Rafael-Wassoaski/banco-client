package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.AlunoDAO;
import database.ProfessorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class UpdateController implements Initializable {
	@FXML
	private ComboBox<String> cmbveri;

	@FXML
	private TextField txtCpf;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCurso;

	@FXML
	private TextField txtNewLogin;

	@FXML
	private TextField txtNewSenha;

	@FXML
	private Button btnAtualizar;

	@FXML
	private Button btnCancelarr;

	private ListaController listController;
	private ListaController listControlle;

	public ObservableList<String> listCmbox = FXCollections.observableArrayList("Aluno", "Professor");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbveri.setItems(listCmbox);
	}

	@FXML
	private void update(ActionEvent e) throws IOException {
		String menssagem;
		if (cmbveri.getValue().equals("Aluno")) {
			
			menssagem = "updateAluno@" + txtCpf.getText().toString() + "-"  + txtCurso.getText().toString() + "-" + txtNewLogin.getText().toString()+"-"+
					txtNewSenha.getText().toString();
	
			
		} else {
			menssagem = "updateProfessor@" + txtCpf.getText().toString() + "-"  + txtCurso.getText().toString() + "-" + txtNewLogin.getText().toString()+"-"+
					txtNewSenha.getText().toString();
		}
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("lista");
		controller.conectar(menssagem);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnAtualizar.getScene().getWindow();
		stage.close();
	}	
	public void selectedProfessor(Professor professor, ListaController listaControlle) {
		txtCpf.setText(professor.getCpf());
		txtNome.setText(professor.getCpf());
		txtCurso.setText(professor.getCurso());
		txtNewLogin.setText(professor.getLogin());
		txtNewSenha.setText(professor.getSenha());
		this.listControlle = listaControlle;

	}

	public void selectedAluno(Aluno aluno, ListaController listController) {
		txtCpf.setText(aluno.getCpf());
		txtNome.setText(aluno.getCpf());
		txtCurso.setText(aluno.getCurso());
		txtNewLogin.setText(aluno.getLogin());
		txtNewSenha.setText(aluno.getSenha());
		this.listController = listController;
	}

	public void Cancelar() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("lista.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();

	}



}
