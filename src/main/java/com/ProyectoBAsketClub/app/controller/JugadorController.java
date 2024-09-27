package com.ProyectoBAsketClub.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ProyectoBAsketClub.app.variables.Club;
import com.ProyectoBAsketClub.app.variables.Jugador;
import com.ProyectoBAsketClub.repository.ClubRepositorio;
import com.ProyectoBAsketClub.repository.PlayoffsRepositorio;
import com.ProyectoBAsketClub.repository.JugadorRepositorio;

@Controller
public class JugadorController {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;    

    @Autowired
    private ClubRepositorio clubRepositorio;

    @GetMapping("/verJugador")
    public String listarJugador(Model model) {
        List<Jugador> listaJugador = jugadorRepositorio.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "verJugador";
    }

    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());

        List<Club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);

        return "formJugador";
    }

    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/jugador/editar/{id}")
    public String modificarJugador(@PathVariable("id") Integer id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).get();
        model.addAttribute("jugador", jugador);

        List<Club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);

        return "formJugador";
    }

    @GetMapping("/jugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Integer id, Model model) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/verJugador";
    }
}
