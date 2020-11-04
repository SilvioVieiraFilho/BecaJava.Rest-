package br.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.app.model.Eleitor;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Eleitor")

public class EleitorController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Eleitor Eleitor) {
		
		if (Eleitor.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
		
		else if (Eleitor.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome nao informado");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Eleitor> lista = new ArrayList<Eleitor>();

		Eleitor u = new Eleitor();

		u.setNome("João");
		lista.add(u);

		u.setNome("Silvio");
		lista.add(u);

		u.setNome("Larissa");
		lista.add(u);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Eleitor u = new Eleitor();
		u.setNome("doido");

		return ResponseEntity.status(HttpStatus.OK).body(u);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Eleitor Eleitor, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(Eleitor);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
