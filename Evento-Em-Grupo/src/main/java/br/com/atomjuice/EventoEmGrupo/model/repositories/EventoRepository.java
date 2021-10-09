package br.com.atomjuice.EventoEmGrupo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.atomjuice.EventoEmGrupo.model.entities.Evento;

public interface EventoRepository extends CrudRepository<Evento, Integer>{

}
