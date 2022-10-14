package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped

public class KalkulatorBB {//BB - Backend Bean
	private String kwota;
	private String oprocentowanie;
	private String czas;
	private Double wynik;

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

	public Double getWynik() {
		return wynik;
	}


	public boolean doTheCalc() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double oprocentowanie = Double.parseDouble(this.oprocentowanie);
			double czas = Double.parseDouble(this.czas);
			double opr = (oprocentowanie/100);

			wynik = ((kwota*opr)+kwota)/czas;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	public String calc() {
		if (doTheCalc()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesięczna rata: " + wynik, null));

		}
		return null;
	}

	public String info() {
		return "info";
	}
}
