package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import model.Curso;
import model.InterfaceTherad;
import model.Professor;
import rojie.poo.ifsc.P1.App;


public class CadastroController implements Initializable, InterfaceTherad{

	   @FXML
	    private ComboBox<String> cmbUserRegister;
	   
	   @FXML
	    private ComboBox<String> cmbUserCurso;
		
	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtCpf;

	    @FXML
	    private TextField txtCurso;

	    @FXML
	    private TextField txtNewLogin;

	    @FXML
	    private TextField txtNewSenha;

	    @FXML
	    private Button btnCadastro;

	    @FXML
	    private Button btnCancelarr;

	public ObservableList<String> listCbox = FXCollections.observableArrayList("Aluno", "Professor");
	public ObservableList<String> listCurs;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbUserRegister.setItems(listCbox);
		
	}
	
	public void setcmbUserCurso(List<String> listCursos) {
		listCurs = FXCollections.observableList(listCursos);
		cmbUserCurso.setItems(listCurs);
	}
    @FXML
    void Verificar(ActionEvent event) throws IOException {
    	if(cmbUserRegister.getValue().toString().equals("Aluno")) {
    		CadastroAluno(event);
    	}
    	else if(cmbUserRegister.getValue().toString().equals("Professor")) {
    		CadastroProfessor(event);
    	}
    }
    
	public void CadastroAluno(ActionEvent e) throws IOException {
		
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Aguarde.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		AguardeController controller = (AguardeController)fxmlLoader.getController();
		controller.setProxTela("cadastro");
		controller.conectar("novo-aluno@"+txtCpf.getText()+"-"+ txtNome.getText()+"-"+ cmbUserCurso.getSelectionModel().getSelectedItem().toString().split("-")[0]+"-"+
				txtNewLogin.getText()+"-"+ txtNewSenha.getText());
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage = (Stage) cmbUserCurso.getScene().getWindow();
		stage.close();
		stage.show();

	
		
	}
	public void CadastroProfessor(ActionEvent e) throws IOException {
		Professor professor = new Professor(txtCpf.getText(), txtNome.getText(), txtCurso.getText(),
				txtNewLogin.getText(), txtNewSenha.getText());
		System.out.println(txtCpf.getText());
		new ProfessorDAO().add(professor);
		Button btn = (Button) e.getSource();
		Scene scene = btn.getScene();
		Stage stage = (Stage) scene.getWindow();
		txtCpf.setText(null);
		txtNome.setText(null);
		txtCurso.setText(null);
		txtNewLogin.setText(null);
		txtNewSenha.setText(null);
	}
	public void Cancelar(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) btnCancelarr.getScene().getWindow();
		stage.close();
	}

	@Override
	public void setResposta(String resposta) {
		// TODO Auto-generated method stub
		String[] respostaForm = resposta.split("/");
		List<String> listCursos = new ArrayList<>();
		for(String cursoString : respostaForm) {
			String[] cursoFormatado = cursoString.split("-");
			listCursos.add(cursoFormatado[0]+"-"+cursoFormatado[2]);
		}
		setcmbUserCurso(listCursos);
	}
	
}