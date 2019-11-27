package rojie.poo.ifsc.P1;

public class AtestadoMatricula {
	private String Codigo;
	private String Comp;
	private String Turma;
	private String Status;
	private String Horario;
	
	
	public AtestadoMatricula(String codigo, String comp, String turma, String status, String horario) {
		super();
		Codigo = codigo;
		Comp = comp;
		Turma = turma;
		Status = status;
		Horario = horario;
	}
	public synchronized String getCodigo() {
		return Codigo;
	}
	public synchronized void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public synchronized String getComp() {
		return Comp;
	}
	public synchronized void setComp(String comp) {
		Comp = comp;
	}
	public synchronized String getTurma() {
		return Turma;
	}
	public synchronized void setTurma(String turma) {
		Turma = turma;
	}
	public synchronized String getStatus() {
		return Status;
	}
	public synchronized void setStatus(String status) {
		Status = status;
	}
	public synchronized String getHorario() {
		return Horario;
	}
	public synchronized void setHorario(String horario) {
		Horario = horario;
	}
	
	
}
