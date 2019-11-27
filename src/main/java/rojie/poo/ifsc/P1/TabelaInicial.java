package rojie.poo.ifsc.P1;

public class TabelaInicial {
	private String comCurricular;
	private String Local;
	private String Horario;

	public TabelaInicial(String comCurricular, String local, String horario) {
		super();
		this.comCurricular = comCurricular;
		Local = local;
		Horario = horario;
	}
	public String getComCurricular() {
		return comCurricular;
	}
	public void setComCurricular(String comCurricular) {
		this.comCurricular = comCurricular;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	

}
