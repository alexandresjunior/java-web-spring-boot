package com.treina.recife.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TreinaRecifeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinaRecifeApiApplication.class, args);
	}

	@GetMapping("/")
	public String dizerOla() {
		return "Olá, mundo!";
	}

	@GetMapping("/fulano")
	public String dizerOlaFulano(
			@RequestParam(name = "nome", required = false, defaultValue = "Pessoa") String nome) {
		return "Olá, " + nome + "!";
	}

	@GetMapping("/fulano/v2/{nome}")
	public String dizerOlaFulano2(@PathVariable("nome") String nome) {
		return "Olá, " + nome + "!";
	}

	@GetMapping("/aluno/{idAluno}/{nome}/{email}/{senha}")
	public Aluno obterAluno(
		@PathVariable("idAluno") long id,
		@PathVariable("nome") String nome,
		@PathVariable("email") String email,
		@PathVariable("senha") String senha
	) {

		Aluno aluno = new Aluno();

		aluno.setIdAluno(id);
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setSenha(senha);

		return aluno;
	}

}
