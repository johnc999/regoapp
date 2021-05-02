package johnc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import johnc.form.RegistrationForm;


public class TestRegistration extends ApplicationTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testCreate() throws Exception {
	    RegistrationForm registration = new RegistrationForm();
	    registration.setNumberplate("TEST999");
	    registration.setInsurer("33");
	    registration.setVehicletype("Sedan");
	    registration.setColour("Black");
	    registration.setMake("Toyota");
	    registration.setModel("Avalon");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(registration);

	    mockMvc.perform(post("/rego/saveregistration").contentType("application/json")
	        .content(requestJson))
	        .andExpect(status().is(201));
	}

	@Test
	public void testLookup() throws Exception {
		mockMvc.perform(get("/rego/registrations")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.registrations[-1:].number_plate"). value("TEST999"));
	}
}
