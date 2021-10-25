package com.example.desafio.produto.presente;



import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PresenteService {

    @Autowired private PresenteRepository repository;
    
    @Autowired private ItemPresenteRepository itemRepository;
    
    
    
    @PostConstruct
    public void init(){ 
    	
    	Presente presente = new Presente();
    	
    	presente.setNome("Balas pct 1 un 10g - Doce Sonho");
    	presente.setPreco(2.50);
    	
    	repository.save(presente);
    	
    	
    	Presente presente2 = new Presente();
    	
    	presente2.setNome("Balas pct 1 un 20g - Doce Sonho");
    	presente2.setPreco(3.50);
    	
    	repository.save(presente2);
    }
    
    
    public Presente createPresente(Presente presenteNovo) {
    	if(presenteNovo != null) {
    			return repository.save(presenteNovo);
    	} else {
    		return new Presente();
    	}
    }
    
    public Presente updatePresente(Presente presenteUpdate, Long id) {
    	if(repository.existsById(id) && presenteUpdate != null) {
	    	Optional<Presente> presente = repository.findById(id);
	    	
	    	
	    	Presente presenteOld = presente.get();
	    	presenteOld.setNome(presenteUpdate.getNome());
	    	presenteOld.setPreco(presenteUpdate.getPreco());
	    	
	    	repository.save(presenteOld);
	    	
    		return presenteOld;
    	} else {
    		return null;
    	}
    }
    
    public ArrayList<Presente> listaPresentes() {
    	Iterable<Presente> iterablePresentes = repository.findAll();
    	
    	ArrayList<Presente> arrayPresentes = new ArrayList<>(); 
    	
    	iterablePresentes.iterator().forEachRemaining(arrayPresentes::add);
    	
    	if(arrayPresentes.size() > 0 && !arrayPresentes.isEmpty() && arrayPresentes != null)
    		return arrayPresentes;
    	else
    		return new ArrayList<>();
    }
    
    
    public Presente getById(Long id) {
    	if(id > 0L && repository.existsById(id)) {
    		Optional<Presente> presente = repository.findById(id);
    		return presente.get();
    	} else {
    		return null;
    	}
    }
    
    
    public void deleteById(Long id) {
    	if(id > 0L && repository.existsById(id)) {
    		repository.deleteById(id);
    	}
    }
    
    
    /*
    As alterações do Desafio 1 vão aqui...
     */
}
