package lista006.Estudantes;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/estudantes")
public class EstudantesController {

    private List<Estudante> listaEstudantes = new ArrayList<>();

    // POST - Cadastrar estudante
    @PostMapping
    public String cadastrarEstudante(@RequestBody Estudante estudante) {
        listaEstudantes.add(estudante);
        return "Estudante cadastrado com sucesso!";
    }

    // GET - Retornar todos
    @GetMapping
    public List<Estudante> listarEstudantes() {
        return listaEstudantes;
    }

    // GET - Buscar por código
    @GetMapping("/{codigo}")
    public Estudante buscarPorCodigo(@PathVariable int codigo) {
        for (Estudante e : listaEstudantes) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        throw new RuntimeException("Estudante não encontrado com código: " + codigo);
    }
}
