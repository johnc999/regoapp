package johnc.form;

public class RegistrationForm {
	private String numberplate;
	private String insurer;
	private String vehicletype;
	private String colour;
	private String make;
	private String model;
	
	public RegistrationForm() {	
	}
	
	public RegistrationForm(String numberplate, String insurer, String vehicletype, String colour, String make,
			String model) {
		this.numberplate = numberplate;
		this.insurer = insurer;
		this.vehicletype = vehicletype;
		this.colour = colour;
		this.make = make;
		this.model = model;
	}

	public String getNumberplate() {
		return numberplate;
	}

	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
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
}
