package johnc.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	@SequenceGenerator(name="hibernate_vehicle_sequence",sequenceName="hibernate_vehicle_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hibernate_vehicle_sequence")
	private long vehicle_id;

	@Column(name = "type")
	private String type;

	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "colour")
	private String colour;
	
	public Vehicle() {
	}
	
	public Vehicle(String type, String make, String model, String colour) {
		this.type = type;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}

	public Vehicle(long vehicle_id, String type, String make, String model, String colour) {
		this.vehicle_id = vehicle_id;
		this.type = type;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}
	
	@JsonIgnore
	public long getVehicle_id() {
		return vehicle_id;
	}

	@JsonSetter
	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", type=" + type + ", make=" + make + ", model=" + model + ", colour=" + colour
				+ "]";
	}
}
