package com.example.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prova.dao.repositorio;
import com.example.prova.dao.repositorioDigito;
import com.example.prova.modal.digito;
import com.example.prova.modal.usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller Api
 * 
 * @author Lucas
 */

@RestController
@RequestMapping("/api/")
@Api(value = "Api Rest Usuarios/Codigo Unico")
@CrossOrigin(origins = "*")
public class controllerApi {
	@Autowired
	private repositorio Repositorio;
	@Autowired
	private repositorioDigito repositorioDigito;
	@Autowired
	private controller controle = new controller();

	// listar usuario
	@RequestMapping(value = "consultUser/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Consulta de usuarios por ID")
	public usuario consultUser(@PathVariable("id") int id, Model model) {
		return controle.consultarUser(id, model);
	}

	// Salvar usuario
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	@ApiOperation(value = "Salva usuarios")
	public String saveUser(@RequestBody usuario usuario, Model model) {
		Repositorio.save(usuario);
		return "salvo";
	}

	// Alterar usuario :: foi separado mas poderia ser feito no saveUser
	@ApiOperation(value = "Alterar Usuarios")
	@RequestMapping(value = "editUser", method = RequestMethod.POST)
	public String editUser(@RequestBody usuario usuario, Model model) {
		Repositorio.save(usuario);
		return "Alterado";
	}

	// Deletar usuario
	@ApiOperation(value = "Deletar Usuarios")
	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestBody usuario usuario, Model model) {
		Repositorio.delete(usuario);
		return "Usuario Apagado";
	}

	// Listar todos digitos de um Usurio
	@RequestMapping(value = "consultDig", method = RequestMethod.POST)
	public List<digito> consultDig(@RequestBody usuario usuario, Model model) {
		return repositorioDigito.findAllByIdUsuario(usuario);

	}

	// Calcular digito unico
	@RequestMapping(value = "criarDig", method = RequestMethod.POST)
	@ApiOperation(value = "Salvar/Calcular Digito Unico")
	public digito criarDig(@RequestBody digito digito, Model model) {
		digito.setDigitoUnico(digito.calDigUnico(digito.getParamN(), digito.getParamK()));
		repositorioDigito.save(digito);
		return digito;
	}
	


}
