package br.com.confidencecambio.calculadoraIMC.controller;

import br.com.confidencecambio.calculadoraIMC.model.Cliente;
import br.com.confidencecambio.calculadoraIMC.model.IPessoa;
import br.com.confidencecambio.calculadoraIMC.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.DecimalFormat;


@RestController
@RequestMapping("/imc")
public class ImcRS {
    private IPessoa pessoa;

    private ImcRS(IPessoa pessoa)
    {
        this.pessoa = pessoa;
    }



    @RequestMapping(value = "/calcular", method = RequestMethod.GET)
    public ResponseEntity<String> calcularIMC(@RequestBody final Pessoa body){

        try {
            pessoa.registraPessoa(body);
        }
        catch(IllegalArgumentException exc)
        {
            throw new ResponseStatusException(
                HttpStatus. NOT_ACCEPTABLE, null, exc);

        }

        final var imc = body.calcularIMC(body.getPeso(),body.getAltura());
        DecimalFormat df = new DecimalFormat("#.##");
        var retorno = "O IMC é: "+ df.format(imc);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
