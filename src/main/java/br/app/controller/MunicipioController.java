package br.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.app.model.Municipio;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Municipios")

public class MunicipioController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Municipio municipio) {
		if (municipio.getPopulacao() == 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Populacao nao pode ser igual a 0 ");
		else if (municipio.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Porfavor escrever o nome");
		else if (municipio.getPopulacao() < 100)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valor de população abaixo de tente novamente");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Municipio criado com sucesso!");
		}

	@GetMapping
	public ResponseEntity listar() {

		List<Municipio> lista = new ArrayList<Municipio>();

		Municipio u = new Municipio();

		u.setNome("SP");
		u.setPopulacao(200000);
		lista.add(u);

		u.setNome("RJ");
		u.setPopulacao(300000);
		lista.add(u);

		u.setNome("SC");
		u.setPopulacao(400000);
		lista.add(u);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	
	
	

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Municipio u = new Municipio();
		u.setNome("Eduarda está dormindo");
		u.setPopulacao(80000);

		return ResponseEntity.status(HttpStatus.OK).body(u);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Municipio Municipio, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(Municipio);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
