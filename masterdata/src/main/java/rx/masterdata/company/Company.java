package rx.masterdata.company;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	private String id;
	private CompanyIdType idType;
	private String name;
	private Country country;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CompanyIdType getIdType() {
		return idType;
	}
	public void setIdType(CompanyIdType idType) {
		this.idType = idType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
