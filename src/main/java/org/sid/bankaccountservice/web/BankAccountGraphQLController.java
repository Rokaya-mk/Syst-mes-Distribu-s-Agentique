package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.exceptions.BankAccountNotFoundException;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById( @Argument Long id) throws BankAccountNotFoundException {
        return bankAccountRepository.findById(String.valueOf(id)).orElseThrow( () -> new BankAccountNotFoundException("Bank account not found"));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequesDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument Long id,@Argument BankAccountRequesDTO bankAccount){
        return accountService.updateBankAccount(bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument Long id){
         accountService.deleteBankaccount(id);
    }


}
