package tn.iit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.entity.Compte;

@Repository
public interface CompteDaoSpringData extends JpaRepository<Compte, Long> {

	List<Compte> findByClientId(String id);

}
