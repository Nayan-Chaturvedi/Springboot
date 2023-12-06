package Springboot_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ControllerClass 
{
	@Autowired
	EmployeeRepository er;
	
	@PostMapping("/employee")
	public String createNewEmp(@RequestBody EntityClass emp)
	{
		er.save(emp);
		return "Save in database";
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EntityClass>> getAll()
	{
		List<EntityClass> al=new ArrayList<>();
		er.findAll().forEach(al::add);
		return new ResponseEntity<List<EntityClass>>(al, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EntityClass> getById(@PathVariable Long empId)
	{
		Optional<EntityClass> o=er.findById(empId);
		if(o.isPresent())
		{
			return new ResponseEntity<EntityClass>(o.get(), HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<EntityClass>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long empId, @RequestBody EntityClass updatedEmployee) {
	    Optional<EntityClass> optionalEmployee = er.findById(empId);

	    if (optionalEmployee.isPresent()) {
	        EntityClass existingEmployee = optionalEmployee.get();
	        
	        // Update fields with the values from the request body
	        existingEmployee.setName((updatedEmployee).getName());
	        existingEmployee.setCity(updatedEmployee.getCity());
	        
	        // Save the updated entity
	        er.save(existingEmployee);
	        
	        return new ResponseEntity<>("Data updated for ID: " + empId, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Employee with ID " + empId + " not found", HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteById(@PathVariable Long empId)
	{
		Optional<EntityClass> o=er.findById(empId);
		if(o.isPresent())
		{
			er.deleteById(empId);
			return "Delete SuccessFully";
		}
		else
		{
			return empId+" Not found";
		}
	}
	
	@DeleteMapping("/employee")
	public String deleteAll()
	{
		er.deleteAll();
		return "All record Delete Successfully";
	}
}
