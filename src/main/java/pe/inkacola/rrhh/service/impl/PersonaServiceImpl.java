package pe.inkacola.rrhh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.inkacola.rrhh.domain.Persona;
import pe.inkacola.rrhh.repository.PersonaRepository;
import pe.inkacola.rrhh.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona registrar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public List<Persona> listarTodos() {
		return personaRepository.findAll();
	}

	@Override
	public Persona actualizar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void eliminar(Integer id) {
		 personaRepository.deleteById(id);
	}

	@Override
	public Persona findById(Integer id) {
		return personaRepository.findById(id).get();
	}

}
