package rx.masterdata.company;

import javax.inject.Inject;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class CompanyService {
	@Inject
	private CompanyRepository repo;
	public List<Company> listAll() {
		return repo.all();
	}
	public void create(Company company, String apikey) {
		repo.save(company);
	}
	
}
