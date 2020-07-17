package com.example.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.prova.dao.repositorio;
import com.example.prova.dao.repositorioDigito;
import com.example.prova.modal.digito;
import com.example.prova.modal.usuario;

/**
 * Controller
 * 
 * @author Lucas
 */

@Controller
public class controller {
	@Autowired
	private repositorio Repositorio;
	@Autowired
	private repositorioDigito repositorioDigito;

	@RequestMapping("/")
	public ModelAndView get(Model model, usuario usuario) {
		ModelAndView index = new ModelAndView("index");
		model.addAttribute("usuario", new usuario());
		model.addAttribute("usuarios", Repositorio.findAll());
		return index;
	}

	@PostMapping("saveUsuario")
	public String saveUsuario(usuario usuario, Model model) {
		Repositorio.save(usuario);
		return "redirect:/";
	}

	@RequestMapping(value = "deletarUsuario/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id, Model model) {
		usuario usuario = Repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Id invalido:" + id));
		Repositorio.delete(usuario);
		model.addAttribute("usuario", new usuario());
		model.addAttribute("usuarios", Repositorio.findAll());
		return "redirect:/";
	}

	@RequestMapping(value = "consultarUsuario/{id}", method = RequestMethod.GET)
	@ResponseBody
	public usuario consultarUser(@PathVariable int id, Model model) {
		usuario usuario = Repositorio.findById(id).get();
		return usuario;
	}
	

	@RequestMapping(value = "digitoUnico", method = RequestMethod.POST, params = { "cal_Digito" })
	@Cacheable("digNum" + "digNu")
	public String calcularDigUnico(@RequestParam(value = "digNum") String digNum, @RequestParam(value = "digNumVezes") int digNumVezes , @RequestParam(value = "userIdDigito") int userIdDigito,Model model) {
		usuario usuario = Repositorio.findById(userIdDigito).orElseThrow(() -> new IllegalArgumentException("Id invalido:" + userIdDigito));
		digito digito = new digito();
		digito.setParamN(digNum);
		digito.setParamK(digNumVezes);
		digito.setDigitoUnico(digito.calDigUnico(digNum, digNumVezes));
		digito.setIdUsuario(usuario);
		repositorioDigito.save(digito);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "consultarDigito/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<digito> consultarDigito(@PathVariable int id, Model model) {
		usuario usuario = Repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Id invalido:" + id));
		List<digito> listaDigito = repositorioDigito.findAllByIdUsuario(usuario);
		return listaDigito;
	}
	
}
