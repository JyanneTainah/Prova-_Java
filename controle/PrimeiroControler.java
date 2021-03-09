/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jyanne
 */
@Controller
public class PrimeiroControler {
    
    @RequestMapping(value = "/index.htm",
            method = RequestMethod.GET)
    public String chamarIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/preparaCadastrarPessoa.htm",
            method = RequestMethod.GET)
    public String preparaCadastrarPessoa(
            @ModelAttribute("pessoa") Pessoa pessoa){
        return "cadastroPessoa";
    }
    
    @RequestMapping(value = "/cadastrarPessoa.htm",
            method = RequestMethod.POST)
    public String cadastrarPessoa(
    @ModelAttribute("pessoa") Pessoa pessoa){
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getCPF());
        System.out.println(pessoa.getNascimento());
        System.out.println(pessoa.getSexo());
        System.out.println(pessoa.getCivil());
        System.out.println(pessoa.getEmail());
        return "index";
    }
    
}
