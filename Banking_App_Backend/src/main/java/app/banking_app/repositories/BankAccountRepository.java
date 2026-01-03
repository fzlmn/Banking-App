package app.banking_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.banking_app.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
