package com.treina.recife.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/aluno")
	public Aluno obterAlunoPeloCorpo(@RequestBody Aluno corpoRequisicao) {
		Aluno aluno = new Aluno();

		aluno.setIdAluno(corpoRequisicao.getIdAluno());
		aluno.setNome(corpoRequisicao.getNome());
		aluno.setEmail(corpoRequisicao.getEmail());
		aluno.setSenha(corpoRequisicao.getSenha());

		return aluno;
	}

	// Ex1: Criar uma rota que me retorna uma lista com dois alunos
	@GetMapping("/alunos")
	public List<Aluno> obterListaDeAlunos() {
		List<Aluno> alunos = new ArrayList<>();

		Aluno aluno1 = new Aluno();

		aluno1.setIdAluno(1);
		aluno1.setNome("Augusto Damasceno");
		aluno1.setEmail("augusto@dev.com");
		aluno1.setIdade(25);
		aluno1.setSenha("augusto123");

		alunos.add(aluno1);

		Aluno aluno2 = new Aluno();

		aluno2.setIdAluno(2);
		aluno2.setNome("Daniel Valença");
		aluno2.setEmail("daniel@dev.com");
		aluno2.setIdade(28);
		aluno2.setSenha("daniel123");

		alunos.add(aluno2);

		return alunos;
	}

	// Ex2: Criar uma rota que obtém uma lista de alunos e me retorne a soma de suas idades.
	@PostMapping("/alunos")
	public String obterSomaDasIdades(@RequestBody List<Aluno> alunos) {
		int soma = 0;

		// Enhanced For
		for (Aluno aluno : alunos) {
			soma += aluno.getIdade();
		}

		return String.format("A soma das idades é: %d", soma);
	}

}
