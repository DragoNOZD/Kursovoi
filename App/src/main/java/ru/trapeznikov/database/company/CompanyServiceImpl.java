package ru.trapeznikov.database.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepo companyRepo;

    @Autowired
    public CompanyServiceImpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public CompanyRepo getCompanyRepo() {
        return companyRepo;
    }

    public void setCompanyRepo(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    @Override
    public void addCompany(Company company) {
        companyRepo.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(Long INN) {
        companyRepo.delete(INN);
    }

    @Override
    public Company getByINN(Long INN) {
        return companyRepo.getOne(INN);
    }

    @Override
    public List<Company> getAll() {
        return companyRepo.findAll();
    }
}
