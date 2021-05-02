package johnc.model;

import java.util.List;

public class Registrations {
	
	private List<Registration> registrations;
	
	public Registrations() {
	}

	public Registrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Registrations [registrations=" + registrations + "]";
	}
}
