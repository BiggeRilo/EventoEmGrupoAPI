package br.com.atomjuice.EventoEmGrupo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.atomjuice.EventoEmGrupo.model.entities.Evento;
import br.com.atomjuice.EventoEmGrupo.model.repositories.EventoRepository;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Evento publicarEvento(@Valid Evento evento) {
		evento.setPublicado(true);
		evento.setExcluido(false);
		evento.setDuracao(evento.getInicio(), evento.getTermino());
		eventoRepository.save(evento);
		return evento;
	} 
	
	@PostMapping(path = "/rascunho")
	public Evento criarRascunho(Evento evento) {
		evento.setPublicado(false);
		eventoRepository.save(evento);
		return evento;
	}
	
	@GetMapping(path = "/consultar/todos")
	public Iterable<Evento> obterEventos(){
		return eventoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Evento> obterEventoPorId(@PathVariable int id) {
		return eventoRepository.findById(id);
	}
	
	@DeleteMapping(path = "{id}")
	public void excluirEventoPorId(Evento evento){
		evento.setExcluido(true);
		eventoRepository.save(evento);
	}
	
	
}
