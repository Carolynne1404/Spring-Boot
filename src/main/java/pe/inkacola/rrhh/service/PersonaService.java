package pe.inkacola.rrhh.service;

import java.util.List;

import pe.inkacola.rrhh.domain.Persona;

public interface PersonaService {

	Persona registrar(Persona persona);
	List<Persona> listarTodos();
	Persona actualizar(Persona persona);
	void eliminar(Integer id);
	Persona findById(Integer id);
}
