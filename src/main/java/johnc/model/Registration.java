package johnc.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "registration")
public class Registration {
	
	@Id
	@Column(name = "number_plate")
	private String number_plate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
    @JoinColumn(name = "insurer_id", referencedColumnName = "insurer_id")
    private Insurer insurer;
	
	public Registration() {
	}

	public Registration(String number_plate, Vehicle vehicle, Insurer insurer) {
		this.number_plate = number_plate;
		this.vehicle = vehicle;
		this.insurer = insurer;
	}

	public String getNumber_plate() {
		return number_plate;
	}

	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Insurer getInsurer() {
		return insurer;
	}

	public void setInsurer(Insurer insurer) {
		this.insurer = insurer;
	}

	@Override
	public String toString() {
		return "Registration [number_plate=" + number_plate + ", vehicle=" + vehicle + ", insurer="
				+ insurer + "]";
	}
}
