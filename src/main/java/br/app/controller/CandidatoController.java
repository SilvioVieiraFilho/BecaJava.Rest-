package br.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.app.model.Candidato;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Candidato")

public class CandidatoController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Candidato Candidato) {
		
		
		if (Candidato.getNumero() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este numero nao pode ser informado");
		else if (Candidato.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Porfavor escrever o nome.");
		else if (Candidato.getTipo() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo vazio");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Candidato> lista = new ArrayList<Candidato>();

		Candidato u = new Candidato();
		Candidato v = new Candidato();
		Candidato a = new Candidato();
		
		
		u.setNome("Zezinho da chuleta");
		u.setNumero(200);
		u.setTipo("vereador");
		lista.add(u);

		v.setNome("Lobao");
		v.setNumero(40666);
		v.setTipo("prefeito");
		lista.add(v);

		a.setNome("BinLaden");
		a.setNumero(400);
		a.setTipo("prefeito");
		lista.add(a);

		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}

	@GetMapping(path = "/{id}")

	public ResponseEntity byId(@PathVariable Long id) {

		Candidato u = new Candidato();
		u.setNome("Candidato Ralo");

		return ResponseEntity.status(HttpStatus.OK).body(u);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato Candidato, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(Candidato);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
