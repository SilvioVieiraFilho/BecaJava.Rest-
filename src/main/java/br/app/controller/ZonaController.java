package br.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.app.model.Zona;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Zona")

public class ZonaController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Zona Zona) {

		if (Zona.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona não informado.");
       else
			return ResponseEntity.status(HttpStatus.CREATED).body("Zona criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Zona> lista = new ArrayList<Zona>();

		Zona u = new Zona();
		Zona v = new Zona();
		Zona a = new Zona();

		u.setNome("290");
		lista.add(u);

		v.setNome("400");
		lista.add(v);

		a.setNome("500");
		lista.add(a);

		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}
	

	@GetMapping(path = "/{id}")

	public ResponseEntity byId(@PathVariable Long id) {

		Zona u = new Zona();
		u.setNome("Vamo que vamo");

		return ResponseEntity.status(HttpStatus.OK).body(u);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Zona Zona, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(Zona);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
