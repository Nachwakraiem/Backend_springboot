package tn.iit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import tn.iit.dto.CompteDTO;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/comptes")

public class CompteController {

	public final CompteService compteService;
	public final ClientService clientService;

	@Autowired
	public CompteController(CompteService compteService, ClientService clientService) {
		super();
		this.compteService = compteService;
		this.clientService = clientService;
	}

	@PostMapping("/save")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public Compte saveCompte(@RequestBody CompteDTO compteDto) {
		Client client = clientService.findById(compteDto.getId());
		Compte compte = new Compte(compteDto.getRib(), compteDto.getSolde(), client);
		return compteService.saveOrUpdate(compte);

	}

	@GetMapping(path = "/all")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Compte> getAll() {

		return compteService.findAll();
	}

	@PutMapping("/edit/{rib}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public Compte edit(@PathVariable(name = "rib") Long rib, @RequestBody Compte compteDetail) {

		Compte compte = compteService.findById(rib);

		compte.setSolde(compteDetail.getSolde());
		Compte edit = compteService.saveOrUpdate(compte);
		return compteService.saveOrUpdate(edit);

	}

	@DeleteMapping("/delete/{rib}")
	@CrossOrigin(origins = "http://localhost:3000")
	public String delete(@PathVariable(name = "rib") Long rib) {
		compteService.delete(rib);
		return "redirect:/comptes/all";
	}

}
