package kodlamaio.Kodlama.io.Devs.entities.concretes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oto artan
	@Column(name = "language_id")
	private int id;

	@Column(name = "name")
	private String name;
	
	 @OneToMany(mappedBy="language",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    List<Technology> technologies;

}
