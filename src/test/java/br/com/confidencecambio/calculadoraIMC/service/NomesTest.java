package br.com.confidencecambio.calculadoraIMC.service;


import br.com.confidencecambio.calculadoraIMC.model.Cliente;
import br.com.confidencecambio.calculadoraIMC.model.EntidadeComNome;
import br.com.confidencecambio.calculadoraIMC.model.Gerente;
import br.com.confidencecambio.calculadoraIMC.model.Robo;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NomesTest {

@Test(expected = NullPointerException.class)
    public void quandoCrioUmaComNomeIncorretoTest(){

    var entidadeNomeada = mock(EntidadeComNome.class);
    entidadeNomeada.validaNome("");


    }
    @Test
    public void quandoCrioUmRoboComNomeCorretoTest(){

        var robo = new Robo("Ivo Sputnik");


        var entidadeNomeada = mock(EntidadeComNome.class);
        when(entidadeNomeada.getNome()).thenReturn("Ivo Sputnik");
        Assert.assertEquals(robo.getNome(), entidadeNomeada.getNome());

    }

    @Test
    public void abreviacaoTest(){

        var cliente = new Cliente("Monkey D??? Luffy");

        Assert.assertEquals("Monkey D. Luffy", cliente.abreviarNome());

    }

    @Test
    public void pegarPrimeiroNomeTest(){

        var robo = new Robo("Monkey D. Dragon");

        Assert.assertEquals("Monkey", robo.pegarPrimeiroNome());

    }

    @Test
    public void pegarUltimoNomeTest(){

        var gerente = new Gerente("Monkey D. Garp");

        Assert.assertEquals("Garp", gerente.pegarUltimoNome());

    }

    @Test
    public void pegarUltimoNomeCorreto(){
        var robo = new Robo("Monkey D. Garp");

        Assert.assertEquals("Garp", robo.pegarUltimoNome());
    }

    public void nomeComLetrasMaiusculasTest()
    {
        var jojo = new Gerente("Joseph Joestar");
        Assert.assertEquals("JOSEPH JOESTAR", jojo.nomeEmLetrasMaiusculas());
    }

}