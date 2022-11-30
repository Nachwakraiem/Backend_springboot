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

import tn.iit.entity.Client;
import tn.iit.service.ClientService;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController {

	public final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@PostMapping("/save")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public String saveClient(@RequestBody Client client) {
		clientService.saveOrUpdate(client);
		return "redirect:/clients/all";
	}
	/*
	 * public String save(@RequestParam(name = "prenom") String
	 * prenom, @RequestParam(name = "nom") String nom,
	 * 
	 * @RequestParam(name = "adress") String adress) {
	 * 
	 * Client client = new Client(prenom, nom, adress);
	 * clientService.saveOrUpdate(client); return "redirect:/clients/all"; }
	 */

	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Client> getAll() {

		return clientService.findAll();
	}

	@PutMapping("/edit/{id}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public Client edit(@PathVariable(name = "id") int id, @RequestBody Client clientDetail) {

		Client client = clientService.findById(id);
		client.setNom(clientDetail.getNom());
		client.setPrenom(clientDetail.getPrenom());
		client.setAdress(clientDetail.getAdress());
		Client edit = clientService.saveOrUpdate(client);
		return clientService.saveOrUpdate(edit);

	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	public void delete(@PathVariable(name = "id") int id) {
		clientService.delete(id);

	}

}
