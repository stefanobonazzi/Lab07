package it.polito.tdp.poweroutages.model;

import java.util.Date;

public class PowerOutages {

	int id;
	int event_type_id;
	int tag_id;
	int area_id;
	int nerc_id;
	int responsible_id;
	int customers_affected;
	Date date_event_began;
	Date date_event_finished;
	int demand_loss;
	
	public PowerOutages(int id, int event_type_id, int tag_id, int area_id, int nerc_id, int responsible_id,
			int customers_affected, Date date_event_began, Date date_event_finished, int demand_loss) {
		this.id = id;
		this.event_type_id = event_type_id;
		this.tag_id = tag_id;
		this.area_id = area_id;
		this.nerc_id = nerc_id;
		this.responsible_id = responsible_id;
		this.customers_affected = customers_affected;
		this.date_event_began = date_event_began;
		this.date_event_finished = date_event_finished;
		this.demand_loss = demand_loss;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public int getNerc_id() {
		return nerc_id;
	}

	public void setNerc_id(int nerc_id) {
		this.nerc_id = nerc_id;
	}

	public int getResponsible_id() {
		return responsible_id;
	}

	public void setResponsible_id(int responsible_id) {
		this.responsible_id = responsible_id;
	}

	public int getCustomers_affected() {
		return customers_affected;
	}

	public void setCustomers_affected(int customers_affected) {
		this.customers_affected = customers_affected;
	}

	public Date getDate_event_began() {
		return date_event_began;
	}

	public void setDate_event_began(Date date_event_began) {
		this.date_event_began = date_event_began;
	}

	public Date getDate_event_finished() {
		return date_event_finished;
	}

	public void setDate_event_finished(Date date_event_finished) {
		this.date_event_finished = date_event_finished;
	}

	public int getDemand_loss() {
		return demand_loss;
	}

	public void setDemand_loss(int demand_loss) {
		this.demand_loss = demand_loss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutages other = (PowerOutages) obj;
		if (id != other.id)
			return false;
		return true;
	}

	//Da sistemare il per le date e la loro rappresentazione
	@Override
	public String toString() {
		return date_event_began+"\t"+date_event_finished+"\t"+demand_loss+"\t"+customers_affected+"\n";
	}
	
}
