package rx.jpaentity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	private String companyCode;
	private String name;
	@Enumerated(EnumType.STRING)
	private Region headquarter;
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region getHeadquarter() {
		return headquarter;
	}
	public void setHeadquarter(Region headquarter) {
		this.headquarter = headquarter;
	}	
}
