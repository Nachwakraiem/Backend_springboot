package tn.iit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "t_client")
public class Client implements Serializable /* Spec JEE */ {
	private static final long serialVersionUID = 1L;

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Include
	private int id;
	private String prenom;
	private String nom;
	private String adress;
	// bidirectionnelle
	@JsonIgnore // cassé la boucle json
	@ToString.Exclude // cassé la boucle ToString
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE) // mappedBy obligatoire, pour ne pas générer une
																	// colonne de jointure dans client
	private List<Compte> comptes;

	public Client(String prenom, String nom, String adress) {
		super();

		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
	}

}
