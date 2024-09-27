package com.ProyectoBAsketClub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoBAsketClub.app.variables.*;
import com.ProyectoBAsketClub.repository.PlayoffsRepositorio;


		@Controller
		public class PlayoffsController {

		    @Autowired
		    private PlayoffsRepositorio playoffsRepositorio;

    @GetMapping("/verPlayoffs")
    public String listarPlayoffs(Model model) {
        List<Playoffs> listaPlayoffs = playoffsRepositorio.findAll();
        model.addAttribute("listaPlayoffs", listaPlayoffs);
        return "verPlayoffs";
    }

    @GetMapping("/verPlayoffs/formPlayoffs")
    public String mostrarFormulario(Model model) {
        model.addAttribute("playoffs", new Playoffs());
        return "formPlayoffs";
    }

    @PostMapping("/guardarPlayoffs")
    public String guardarPlayoffs(Playoffs playoffs) {
        playoffsRepositorio.save(playoffs);
        return "redirect:/verPlayoffs";
    }

    @GetMapping("/playoffs/editar/{id}")
    public String modificarPlayoffs(@PathVariable("id") Integer id, Model model) {
        Playoffs playoffs = playoffsRepositorio.findById(id).get();
        model.addAttribute("playoffs", playoffs);
        return "formPlayoffs";
    }

    @GetMapping("/playoffs/eliminar/{id}")
    public String eliminarPlayoffs(@PathVariable("id") Integer id, Model model) {
    	playoffsRepositorio.deleteById(id);
        return "redirect:/verPlayoffs";
    }
}
