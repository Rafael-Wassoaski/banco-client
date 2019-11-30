package database;

import javafx.application.Application;
import model.Aluno;
import model.Professor;
import rojie.poo.ifsc.P1.App;

public class Main {
	
	public static Professor professorLogin = new Professor();
	public static Aluno alunoLogin = new Aluno();

	public static void main(String[] args) {
		professorLogin.setLogin(null);
		alunoLogin.setLogin(null);
		Application.launch(App.class);

	}

}
