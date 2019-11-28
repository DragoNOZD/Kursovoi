package ru.mmo.database.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mmo.database.hibernate.OffsetBasedPageRequest;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addUser(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.saveAndFlush(account);
    }

    @Override
    public void editUser(Account account) {
        addUser(account);
    }

    @Override
    public void deleteUser(String login) {
        accountRepository.delete(login);
    }

    @Override
    public Account getByLogin(String login) {
        return accountRepository.findOne(login);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAllByCountry(Country country) {
        return accountRepository.getAllByCountry(country);
    }

    @Override
    public List<Account> getAllByName(String name) {
        return accountRepository.getAllByName(name);
    }

    @Override
    public Account getByEmail(String email) {
        return accountRepository.getByEmail(email);
    }

    @Override
    public List<Account> getAllLimited(int from, int count) {
        return accountRepository.findAll(new OffsetBasedPageRequest(count, from, "name")).getContent();
    }

    @Override
    public Long getEntitiesCount() {
        return accountRepository.count();
    }
}
