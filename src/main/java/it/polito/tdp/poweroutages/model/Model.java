package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	private List<PowerOutages> po = new ArrayList<>();
	private List<PowerOutages> best;
	private int tot_clienti_best;
	private int tot_hours_best;
	private int max_years = 0;
	private int max_hours = 0;
	private int size;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutages> worstCaseAnalysis(Nerc nerc, int years, int hours) {
		this.po = this.podao.getNercPowerOutages(nerc.getId());
		this.max_years = years;
		this.max_hours = hours;
		this.size = this.po.size();
		List<PowerOutages> parziale = new ArrayList<PowerOutages>();
		
		worstCaseAnalysis_ricorsiva(parziale, 0);
		
		return this.best;
	}
	
	private void worstCaseAnalysis_ricorsiva(List<PowerOutages> parziale, int lvl) {
		
		if(lvl == this.size) {
			int i = this.tot_clienti(parziale);
			
			if(i > this.tot_clienti_best) {
				best = new ArrayList<>(parziale);
				this.tot_clienti_best = i;
				this.tot_hours_best = this.tot_hours(parziale);
			}
			return;
		} else {
			for(int i=lvl; i<this.size; i++) {
				parziale.add(this.po.get(i));
				
				if(this.tot_hours(parziale) <= this.max_hours && this.tot_anni(parziale) <= this.max_years) {
					this.worstCaseAnalysis_ricorsiva(parziale, i+1);
				}
				
				parziale.remove(this.po.get(i));
			}
		}
		
		return;
	}
	
	private int tot_hours(List<PowerOutages> l) {
		int tot = 0;
		
		if(!l.isEmpty())
			for(PowerOutages po: l) {
				int days = po.getDate_event_finished().getDayOfYear() - po.getDate_event_began().getDayOfYear();
				if(days == 0)
					tot = tot + (po.getDate_event_finished().getHour()-po.getDate_event_began().getHour());
				else
					tot = tot + (po.getDate_event_finished().getHour()-po.getDate_event_began().getHour()) + 24*days;
			}
		
		return tot;
	}
	
	private int tot_anni(List<PowerOutages> l) {
		int tot = 0;
		
		if(!l.isEmpty())
			tot = l.get(0).getDate_event_began().getYear() - l.get(l.size()-1).getDate_event_finished().getYear();
		
		return tot;
	}
	
	private int tot_clienti(List<PowerOutages> l) {
		int tot = 0;
		
		for(PowerOutages po: l)
			tot = tot + po.getCustomers_affected();
		
		return tot;
	}

	public int getTot_clienti_best() {
		return tot_clienti_best;
	}

	public int getTot_hours_best() {
		return tot_hours_best;
	}
	
}
