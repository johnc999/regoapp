package johnc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import johnc.form.RegistrationForm;
import johnc.model.Insurer;
import johnc.model.Registration;
import johnc.model.Vehicle;
import johnc.repository.InsurerRepository;
import johnc.repository.RegistrationRepository;
import johnc.repository.VehicleRepository;

@Controller
public class RegistrationApp {
	
	@Autowired
	RegistrationRepository registrationsRepository;
	
	@Autowired
	InsurerRepository insurerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/addRegistration")
    public String addRegistration() {
        return "addRegistration";
    }
    
    @RequestMapping(value = { "/addRegistration" }, method = RequestMethod.POST)
    public String addPersonSave(Model model, @ModelAttribute("personForm") RegistrationForm registrationForm) {
    	
    	try {
    		Optional<Registration> regOpt = this.registrationsRepository.findById(registrationForm.getNumberplate());
    		if (regOpt.isPresent()) {
    			model.addAttribute("message", "Error: A registration for " + registrationForm.getNumberplate() + " already exists.");
    		} else {
    			Insurer insurer = this.insurerRepository.findInsurerByCode(registrationForm.getInsurer());
    			Vehicle vehicle = new Vehicle(registrationForm.getVehicletype(), registrationForm.getMake(), registrationForm.getModel(), registrationForm.getColour());
    			Registration registration = new Registration(registrationForm.getNumberplate(), vehicle, insurer);
    			this.registrationsRepository.save(registration);
    	    	model.addAttribute("message", "Registration Saved");
    		}
    	} catch (Exception e) {
    		model.addAttribute("message", "Error: " + e.getMessage());
    	}
        return "addRegistration";
    }
	
    @RequestMapping(value = { "/listRegistrations" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
    	List<RegistrationForm> registrations = new ArrayList<>();
    	List<Registration> records = this.registrationsRepository.findAll();
    	for (Registration rec : records) {
    		RegistrationForm regForm = new RegistrationForm();
    		regForm.setNumberplate(rec.getNumber_plate());
    		regForm.setInsurer(rec.getInsurer().getName());
    		regForm.setVehicletype(rec.getVehicle().getType());
    		regForm.setColour(rec.getVehicle().getColour());
    		regForm.setMake(rec.getVehicle().getMake());
    		regForm.setModel(rec.getVehicle().getModel());
    		registrations.add(regForm);
    	}
        model.addAttribute("registrations", registrations);
        return "listRegistrations";
    }
    
    @GetMapping("/jsonRegistrations")
    public String jsonRegistrations() {
        return "jsonRegistrations";
    }
    
    @GetMapping("/jsonVehicles")
    public String jsonVehicles() {
        return "jsonVehicles";
    }
    
    @GetMapping("/jsonInsurers")
    public String jsonInsurers() {
        return "jsonInsurers";
    }
}
