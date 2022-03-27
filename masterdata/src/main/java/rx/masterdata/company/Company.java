package rx.masterdata.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	private String id;
	private CompanyIdType idType;
	private String fullName;
	@Enumerated(EnumType.STRING)
	@Column(length=2)
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
	public void setIdType(String idTypeString) {
		System.out.println("DEBUG:::::::::::::::::::::::");
		this.idType = CompanyIdType.valueOf(idTypeString);
	}
	public String getName() {
		return fullName;
	}
	public void setName(String name) {
		this.fullName = name;
	}
	public String getCountry() {
		return country.toString();
	}
	public void setCountry(String countryName) {
		this.country = Country.valueOf(countryName);
	}
	
}
