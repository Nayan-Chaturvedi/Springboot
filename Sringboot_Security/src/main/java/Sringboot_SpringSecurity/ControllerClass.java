package Sringboot_SpringSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ControllerClass
{
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser()
	{
		return ResponseEntity.ok("Yes...I'm Normal");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser()
	{
		return ResponseEntity.ok("Yes...I'm Admin");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser()
	{
		return ResponseEntity.ok("Yes...I'm Public");
	}	
	
}
