package pe.inkacola.rrhh.controller;

import java.util.List;

import javax.validation.Valid;

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

import pe.inkacola.rrhh.domain.Persona;
import pe.inkacola.rrhh.model.Response;
import pe.inkacola.rrhh.service.PersonaService;

@RestController
@RequestMapping("v1/people")
public class PersonaController {

	
	@Autowired
	private PersonaService personaService;
	
	
	@GetMapping
	public List<Persona> obtenerPersonas() {
		
		return personaService.listarTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Persona> obtenerPersona(@PathVariable Integer id) {
		return  new ResponseEntity<>(personaService.findById(id),HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Persona> registrar( @RequestBody @Valid Persona persona) {
		return new ResponseEntity<>(personaService.registrar(persona),HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Persona> actualizar(@PathVariable Integer id, @RequestBody @Valid Persona persona) {
		persona.setId(id);
		return new ResponseEntity<>(personaService.actualizar(persona),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response> eliminar(@PathVariable Integer id) {
		personaService.eliminar(id);
		return new ResponseEntity<>(new Response("SE ELIMINO CORRECTAMENTE"),HttpStatus.OK);
	}
}
