package com.Entities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



import java.util.Optional;

@org.springframework.stereotype.Controller

@RequestMapping(path="/VehiculeTest")
public class Controleur {

	@Autowired
	private VehiculeCRUD V;
	
	@PostMapping(path="/ajouter")
	public @ResponseBody String AjouterVoiture (@RequestParam String codeInterne, @RequestParam String immatriculation) {
		Vehicule n = new Vehicule();
		n.setCodeInterne(codeInterne);
		n.setImmatricule(immatriculation);
		V.save(n);
		return "Ajout à la BD avec succes ";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Vehicule trouverParID (@PathVariable Integer id) {
		Vehicule n = new Vehicule();
		Optional<Vehicule> v = V.findById(id);
		if(v.isPresent()) {
			n = v.get();
		}
		return n;
	}
	
	@RequestMapping(path="/supprimer/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String SupprimerVoiture (@PathVariable Integer id) {
		
		V.deleteById(id);
		return "Suppression de la BD avec succes ";
	}

	@GetMapping(path="/tous")
	public @ResponseBody Iterable<Vehicule> affichertous() {
		// This returns a JSON or XML with the users
		return V.findAll();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Vehicule TrouverParID(@PathVariable Integer id) {
		
		Vehicule vehicule = new Vehicule();
		Optional<Vehicule> v = V.findById(id);
		
		if(v.isPresent()) {
			  vehicule = v.get();
		}
		return vehicule;
		
	}
	
	
	@RequestMapping(value = "/supprimer/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String SupprimerParID(@PathVariable Integer id) {
		
		V.deleteById(id);
		
		return "Suppression de la base de données avec succes";
		
	}
	
	
	
	@GetMapping(path="/chercher")
	public @ResponseBody Vehicule recherche(@RequestParam String codeInterne, @RequestParam String immatricule) {
		
		Vehicule v = V.chercher(codeInterne,immatricule);
	
		return v;
	}
	
}
