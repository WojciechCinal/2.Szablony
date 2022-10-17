package jsf.kalkulator;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class KalkulatorBB {
	private String kwota;
	private String oprocentowanie;
	private String czas;
	private Double rata;

	@Inject
	FacesContext ctx;
	

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(String oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public String getCzas() {
		return czas;
	}

	public void setCzas(String czas) {
		this.czas = czas;
	}

	public Double getRata() {
		return rata;
	}


	public String obliczRata() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double oprocentowanie = Double.parseDouble(this.oprocentowanie);
			double czas = Double.parseDouble(this.czas);
			double opr = (oprocentowanie/100);

			rata = ((kwota*opr)+kwota)/czas;
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return "showresult"; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Niepoprawne parametry!!!", null));
			return null; 
		}
				
	}

	public String info() {
		return "info"; 
	}
}
