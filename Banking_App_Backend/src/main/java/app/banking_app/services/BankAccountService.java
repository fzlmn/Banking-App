package app.banking_app.services;

import java.util.List;

import app.banking_app.dtos.AccountHistoryDTO;
import app.banking_app.dtos.AccountOperationDTO;
import app.banking_app.dtos.BankAccountDTO;
import app.banking_app.dtos.CurrentBankAccountDTO;
import app.banking_app.dtos.CustomerDTO;
import app.banking_app.dtos.SavingBankAccountDTO;
import app.banking_app.exceptions.BalanceNotSufficientException;
import app.banking_app.exceptions.BankAccountNotFoundException;
import app.banking_app.exceptions.CustomerNotFoundException;
public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
