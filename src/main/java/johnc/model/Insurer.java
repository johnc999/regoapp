package johnc.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "insurer")
public class Insurer {

	@Id
	@SequenceGenerator(name="hibernate_insurer_sequence",sequenceName="hibernate_insurer_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hibernate_insurer_sequence")
	private long insurer_id;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "insurer")
	@JsonBackReference
    private List<Registration> registrations;
	
	public Insurer() {
	}
	
	public Insurer(String name, String code, List<Registration> registrations) {
		this.name = name;
		this.code = code;
		this.registrations = registrations;
	}

	public Insurer(long insurer_id, String name, String code, List<Registration> registrations) {
		this.insurer_id = insurer_id;
		this.name = name;
		this.code = code;
		this.registrations = registrations;
	}

	@JsonIgnore
	public long getInsurerId() {
		return insurer_id;
	}

	@JsonSetter
	public void setInsurerId(long insurer_id) {
		this.insurer_id = insurer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Insurer [insurer_id=" + insurer_id + ", name=" + name + ", code=" + code + ", registrations="
				+ registrations + "]";
	}
}
