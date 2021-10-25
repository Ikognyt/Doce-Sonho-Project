package com.example.desafio.produto.presente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.produto.ProdutoService;

@RestController
@RequestMapping("/presentes")
public class PresenteResource {

    @Autowired private PresenteService presenteService;

    //CRUD
    @GetMapping("/presente/{id}")
    public Presente getPresente(@PathVariable("id") Long id) {
    	return presenteService.getById(id);
    }
    
    @GetMapping("/listaPresentes")
    public List<Presente> getPresentes() {
    	return presenteService.listaPresentes();
    }
    
    @PostMapping("/presente/criaPresente")
    public Presente criaPresente(@RequestBody Presente presenteNovo) {
    	return presenteService.createPresente(presenteNovo);
    }
    
	
	@PutMapping("/presente/atualizaPresente/{id}") 
	public Presente updatePresente(@RequestBody Presente presenteNovo, @PathVariable("id") Long id) {
		return presenteService.updatePresente(presenteNovo, id);
	  
	}
	 
    
    @DeleteMapping("/presente/deletePresente/{id}")
    public void deletePresente(@PathVariable("id") Long id) {
    	presenteService.deleteById(id);
    }
    
    
    /*
    As alterações do Desafio 1 vão aqui...
     */
}
