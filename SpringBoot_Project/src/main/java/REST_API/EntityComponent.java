package REST_API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal")
public class EntityComponent 
{
	private Map<Long, Entity> e=new HashMap();
	
	@GetMapping
	public List<Entity> getAll()
	{
		return new ArrayList<Entity>(e.values());
	}
	
	@PostMapping
	public boolean createEntity(@RequestBody Entity ee)
	{
		e.put(ee.getId(), ee);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public Entity getById(@PathVariable Long myId)
	{
		return e.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public Entity deleteEntity(@PathVariable Long myId)
	{
		return e.remove(myId);
	}
	
	@PutMapping("id/{myId}")
	public Entity putEntry(@PathVariable Long myId, @RequestBody Entity ee)
	{
		return e.put(myId, ee);
	}
	
}
