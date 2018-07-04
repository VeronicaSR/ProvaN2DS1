/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n2;

import dao.PessoaDAO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.Pessoa;
import modelo.Telefone;

/**
 *
 * @author Verônica Santana
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception {
        // TODO code application logic here
        
        
        //Letra A
        
        System.out.println("########### Letra A ###########");
        
        Telefone tel = new Telefone();
        tel.setNumero("999106776");
        tel.setMarca("Motorola");
        
        List<Telefone> telefones = new ArrayList();
        telefones.add(tel);
        
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Pessoa p = new Pessoa();
        
        p.setNome("Pessoa A");
        p.setNascimento(df.parse("15/08/1991"));
                
        
        p.setTelefones(telefones);
        tel.setPessoa(p);

        PessoaDAO dao = new PessoaDAO();
        p = dao.salvar(p);
        
        p = dao.atualizar(p);
        p = dao.consultaPorId(p.getId());
        
        System.out.println("Gravação efetuada da Pessoa: "+ p.getNome());
        
        System.out.println("Telefone ID:"+p.getTelefones().toString());
        
        //Letra B
        
        System.out.println("########### Letra B ###########");
        
        Telefone tel2 = new Telefone();
        tel2.setNumero("999106776");
        tel2.setMarca("Samsung");
        
        List<Telefone> telefones2 = new ArrayList();
        telefones2.add(tel2);
        
        
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        
        Pessoa p2 = new Pessoa();
        
        p2.setNome("Pessoa B");
        p2.setNascimento(df2.parse("15/09/1980"));
                
        
        p2.setTelefones(telefones2);
        tel2.setPessoa(p2);

        PessoaDAO dao2 = new PessoaDAO();
        p2 = dao2.salvar(p2);
        
        p2 = dao2.atualizar(p2);
        p2 = dao2.consultaPorId(p2.getId());
        
        System.out.println("Gravação efetuada da Pessoa: "+ p2.getNome());
        
        System.out.println("Telefone ID:"+p2.getTelefones().toString());
        
        
        //Letra C
        
        System.out.println("########### Letra C ###########");
        
        System.out.println("Gravação efetuada da Pessoa A: "+ p.getNome() + "\n Telefone: "+p.getTelefones());
        
        
        //Letra D
        
        System.out.println("########### Letra D ###########");
        
                        
        p2.setNascimento(df2.parse("10/03/1984"));
        p2 = dao.atualizar(p2);
        
        System.out.println(p2);        
        
        //Letra E
        
        System.out.println("########### Letra E ###########");
        
        System.out.println(dao.excluir(p.getId()));

        
    }
    
}
