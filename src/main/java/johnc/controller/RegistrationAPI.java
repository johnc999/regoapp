package johnc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http. ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import johnc.form.InsurerForm;
import johnc.form.RegistrationForm;
import johnc.model.Insurer;
import johnc.model.Registration;
import johnc.model.Registrations;
import johnc.model.Vehicle;
import johnc.repository.InsurerRepository;
import johnc.repository.RegistrationRepository;
import johnc.repository.VehicleRepository;

@RestController
@RequestMapping("/rego")
public class RegistrationAPI {
	
	@Autowired
	RegistrationRepository registrationsRepository;
	
	@Autowired
	InsurerRepository insurerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/registrations")
	public ResponseEntity<Registrations> getAllRegistrations() {
		try {
			List<Registration> regs = registrationsRepository.findAll();

			if (regs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(new Registrations(regs), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/insurers")
	public ResponseEntity<List<Insurer>> getAllInsurers() {
		try {
			List<Insurer> ins = insurerRepository.findAll();

			if (ins.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		try {
			List<Vehicle> vehicles = vehicleRepository.findAll();

			if (vehicles.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(vehicles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/saveregistration")
	public ResponseEntity<Registration> saveregistration(@RequestBody RegistrationForm registrationForm) {
		try {
			Insurer insurer = this.insurerRepository.findInsurerByCode(registrationForm.getInsurer());
			Vehicle vehicle = new Vehicle(registrationForm.getVehicletype(), registrationForm.getMake(), registrationForm.getModel(), registrationForm.getColour());
			Registration registration = new Registration(registrationForm.getNumberplate(), vehicle, insurer);
			registrationsRepository.save(registration);
			return new ResponseEntity<>(registration, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/saveinsurer")
	public ResponseEntity<Insurer> saveinsurer(@RequestBody InsurerForm insurerForm) {
		try {
			Insurer insurer = new Insurer(insurerForm.getName(), insurerForm.getCode(), null);
			insurerRepository.save(insurer);
			return new ResponseEntity<>(insurer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
