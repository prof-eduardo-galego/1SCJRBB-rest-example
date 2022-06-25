package fiap.scjrbb.rest.controllers;

import fiap.scjrbb.rest.models.Correntista;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    static final List<Correntista> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Correntista("1", "Jonilson Veloso", "+551147487444"));
        DATABASE.add(new Correntista("2", "Dedé Barbosa", "+551247854545"));
        DATABASE.add(new Correntista("3", "Vilson Taddei", "+553045454554"));
    }

    // [C]reate: Cria um novo recurso correntista.
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Correntista correntista) {
        DATABASE.add(correntista);
    }

    // [R]etrieve: Lista um ou mais correntistas.
    // GET http://localhost:8080/correntistas
    @GetMapping
    public List<Correntista> getAll() {
        return DATABASE;
    }

    // GET http://localhost:8080/correntistas/1234
    @GetMapping("/{id}")
    public ResponseEntity<Correntista> getById(@PathVariable("id") final String id) {
        Correntista search = DATABASE.stream().filter(c -> {
            return c.getId().equals(id);
        }).findFirst().orElse(null);

        if (search == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(search);
    }

    // [U]pdate: Atualiza os dados de um correntista com base no ID.
//    @PutMapping
//    public Correntista update(final String id, final Correntista correntista) {
//    }

    // [D]elete: Exclui um correntista com base no ID.
//    @DeleteMapping
//    public void delete(final String id) {
//    }
}
