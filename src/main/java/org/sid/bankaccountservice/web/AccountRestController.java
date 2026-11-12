package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.exceptions.BankAccountNotFoundException;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.sid.bankaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository,AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts(){
        return accountService.bankAccountList();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO bankAccounts(@PathVariable String id) throws BankAccountNotFoundException {
        return accountService.getBankAccount(id);
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequesDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id,@RequestBody BankAccountRequesDTO bankAccount){
//        BankAccount account = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
//        if(bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
//        if(bankAccount.getCreatedAt() != null) account.setCreatedAt(new Date());
//        if(bankAccount.getType() != null) account.setType(bankAccount.getType());
//        if(bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());

        return accountService.updateBankAccount(bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
         accountService.deleteBankaccount(id);
    }
}
