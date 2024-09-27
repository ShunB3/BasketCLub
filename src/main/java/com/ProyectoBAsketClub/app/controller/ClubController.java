package com.ProyectoBAsketClub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoBAsketClub.app.variables.Asociacion;
import com.ProyectoBAsketClub.app.variables.Club;
import com.ProyectoBAsketClub.app.variables.Playoffs;
import com.ProyectoBAsketClub.app.variables.Entrenador;
import com.ProyectoBAsketClub.repository.AsociacionRepositorio;
import com.ProyectoBAsketClub.repository.ClubRepositorio;
import com.ProyectoBAsketClub.repository.PlayoffsRepositorio;
import com.ProyectoBAsketClub.repository.EntrenadorRepositorio;

@Controller
public class ClubController {
	
	@Autowired
	private ClubRepositorio clubRepositorio;
	
	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;
	
	@Autowired
	private AsociacionRepositorio asociacionRepositorio;
	
	@Autowired
	private PlayoffsRepositorio competicionRepositorio;
	
	@GetMapping({"/verClub","/clubes","/dana"})  
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "verClub";
	}
	
	@GetMapping("/verClub/formClub")
	public String mostrarFormulario (Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Playoffs> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@PostMapping("/guardarClub")
	public String guardarClub (Club club) {
		clubRepositorio.save(club);
		return "redirect:/verClub";
	}
	
	@GetMapping("/club/editar/{id}")
	public String modificarClub (@PathVariable("id") Integer id, Model model) {
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Playoffs> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id, Model model) {
		clubRepositorio.deleteById(id);
		return "redirect:/verClub";
	}
	
}