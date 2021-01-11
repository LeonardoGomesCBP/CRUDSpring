package com.leonardo.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leonardo.curso.boot.domain.Cargo;
import com.leonardo.curso.boot.domain.Departamento;
import com.leonardo.curso.boot.domain.Funcionario;
import com.leonardo.curso.boot.domain.UF;
import com.leonardo.curso.boot.service.CargoService;
import com.leonardo.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario Funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/funcionario/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário salvo com sucesso!");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
	
	
	
}
