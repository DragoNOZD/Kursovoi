package org.tr.swapp.company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);
    void deleteCompany(Long INN);
    Company getByINN(Long INN);
    List<Company> getAll();
}
