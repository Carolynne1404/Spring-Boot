package pe.inkacola.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.inkacola.rrhh.domain.Persona;


public interface PersonaRepository extends JpaRepository<Persona,Integer> {

}
