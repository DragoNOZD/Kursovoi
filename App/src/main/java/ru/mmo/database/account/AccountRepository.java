package ru.mmo.database.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("select a from Account a where  a.country = :country")
	List<Account> getAllByCountry(@Param("country") Country country);

	@Query("select a from Account a where a.email = :email")
	Account getByEmail(@Param("email") String email);

	@Query("select a from Account a where a.name = :name")
	List<Account> getAllByName(@Param("name") String name);

	//@Query("select a from Account limit :to offset :fromL ")
	//List<Account> getAllLimited(@Param("fromL") int from, @Param("to") int to);
}
