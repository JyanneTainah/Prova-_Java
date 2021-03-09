/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PessoaDao;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import modelo.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author DesenvolvedorJava
 */
@Controller("/primeiro")
public class PrimeiroControle {
    
    @RequestMapping(value="/index.htm", method = RequestMethod.GET)
    public String chamarIndex()
    {
        return "index";
    }
    
    @RequestMapping(value="/preparaCadastrarPessoa.htm", method = RequestMethod.GET)
    public String preparaCadastrarPessoa(@ModelAttribute("pessoa") Pessoa pessoa)
    {
        return "cadastroPessoa";
    }
    
    @RequestMapping(value="/cadastrarPessoa.htm", method = RequestMethod.POST)
    public String cadastrarPessoa(@ModelAttribute("pessoa") Pessoa pessoa)
    {
        PessoaDao dao = new PessoaDao();
        dao.cadastrarPessoa(pessoa);
        
        return "index";
    }
    @RequestMapping(value="/listarPessoas.htm", method = RequestMethod.GET)
    public String listarPessoas(HttpServletRequest req){
        PessoaDao dao = new PessoaDao();
        req.setAttribute("lista", dao.listarPessoas());
        return "ListaPessoas";
    }
    
}
