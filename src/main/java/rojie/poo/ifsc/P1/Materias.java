package rojie.poo.ifsc.P1;

public class Materias {
	private String nome;

	public Materias(String nome) {
		super();
		this.nome = nome;
	}

	public synchronized String getNome() {
		return nome;
	}

	public synchronized void setNome(String nome) {
		this.nome = nome;
	}
	
}
