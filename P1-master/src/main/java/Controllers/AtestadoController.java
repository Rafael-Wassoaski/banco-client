package Controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import rojie.poo.ifsc.P1.App;
import rojie.poo.ifsc.P1.AtestadoMatricula;

public class AtestadoController {

    @FXML
    private ImageView imglogo;
    
    @FXML
    private ImageView imgDtic;

    @FXML
    private TableColumn<AtestadoMatricula, String> colCod;

    @FXML
    private TableColumn<AtestadoMatricula, String> colComp;

    @FXML
    private TableColumn<AtestadoMatricula, String> colTurma;

    @FXML
    private TableColumn<AtestadoMatricula, String> colStatus;

    @FXML
    private TableColumn<AtestadoMatricula, String> colHorario;
    
    @FXML
    private TableView<AtestadoMatricula> tblAtestado;
    
    @FXML
    private Button btnVoltar;

   
	@FXML
	public void initialize() {		
		
		colCod.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		colComp.setCellValueFactory(new PropertyValueFactory<>("Comp"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("Turma"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
		colHorario.setCellValueFactory(new PropertyValueFactory<>("Horario"));

		tblAtestado.setItems(listaAtestado());
		
	}
	
	private ObservableList<AtestadoMatricula> listaAtestado() {
		return FXCollections.observableArrayList(new AtestadoMatricula("EAG164104", "ADMINISTRAÇÃO GERAL", "01", "MATRICULADO" , "56N12 "),
				new AtestadoMatricula("EGP164104", "GERÊNCIA DE PROJETOS", "01","MATRICULADO","6N34"),
				new AtestadoMatricula("EMP164104", "METODOLOGIA DA PESQUISA", "01","MATRICULADO","4N34"),
				new AtestadoMatricula("EPO164104", "PROGRAMAÇÃO ORIENTADA A OBJETOS II", "01","MATRICULADO","34N12 "),
				new AtestadoMatricula("EGP164104", "PROGRAMAÇÃO PARA INTERNET I", "01","MATRICULADO","2N12 3N34 "),
				new AtestadoMatricula("ESO164104", "SISTEMAS OPERACIONAIS", "01","MATRICULADO","25N34"));
	
		
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
