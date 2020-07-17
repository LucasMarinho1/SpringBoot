package com.example.prova.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.prova.modal.digito;
import com.example.prova.modal.usuario;

public interface repositorioDigito extends CrudRepository<digito, Integer>{

	
		public List<digito> findAllByIdUsuario(usuario id);

}
