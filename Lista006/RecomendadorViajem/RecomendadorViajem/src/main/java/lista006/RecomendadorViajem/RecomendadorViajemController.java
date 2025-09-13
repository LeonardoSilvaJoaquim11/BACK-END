package lista006.RecomendadorViajem;
import org.springframework.web.bind.annotation.*;


@RestController
public class RecomendadorViajemController {


    @PostMapping("/recomendar")
    public Recomendar recomendado(@RequestBody Recomendar recomendar){

        if ("calor".equalsIgnoreCase(recomendar.getClima()) && "natureza".equalsIgnoreCase(recomendar.getEstilo())) {
            recomendar.setLocal("Rio de Janeiro");
        } else if ("calor".equalsIgnoreCase(recomendar.getClima()) && "praia".equalsIgnoreCase(recomendar.getEstilo())) {
            recomendar.setLocal("Salvador");
        } else if ("frio".equalsIgnoreCase(recomendar.getClima()) && "natureza".equalsIgnoreCase(recomendar.getEstilo())) {
            recomendar.setLocal("Bom Jardim da Serra");
        } else if ("calor".equalsIgnoreCase(recomendar.getClima()) && "cultura".equalsIgnoreCase(recomendar.getEstilo())) {
            recomendar.setLocal("São Paulo");
        }else{
        recomendar.setLocal("Sem destino cadastrado.");
        }

        return recomendar;
    }



}
