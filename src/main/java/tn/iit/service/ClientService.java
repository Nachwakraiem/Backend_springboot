package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.ClientDaoSpringData;
import tn.iit.entity.Client;

@Service
public class ClientService {

	private final ClientDaoSpringData clientDaoSpringData;

	@Autowired
	public ClientService(ClientDaoSpringData clientDaoSpringData) {
		super();
		this.clientDaoSpringData = clientDaoSpringData;

	}

	public Client saveOrUpdate(Client compte) {
		return clientDaoSpringData.saveAndFlush(compte);
	}

	public Client findById(int id) {
		Optional<Client> clientOptional = clientDaoSpringData.findById(id);
		if (clientOptional.isPresent()) {
			return clientOptional.get();
		} else {
			return null;
		}
	}

	public void delete(int id) {
		clientDaoSpringData.deleteById(id);
	}

	public List<Client> findAll() {
		return clientDaoSpringData.findAll();
	}
}
