package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutages> worstCaseAnalysis(Nerc nerc, int years, int hours) {
		List<PowerOutages> po = new ArrayList<>();
		po = this.podao.getNercPowerOutages(nerc.getId());
		
		return this.worstCaseAnalysis_ricorsiva(po, years, hours);
	}
	
	private List<PowerOutages> worstCaseAnalysis_ricorsiva(List<PowerOutages> po, int years, int hours) {
		return null;
	}
	
}
