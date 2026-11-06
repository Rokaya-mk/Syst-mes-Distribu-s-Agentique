package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDtO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountResponseDtO addAccount(BankAccountRequesDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDtO bankAccountResponseDtO = BankAccountResponseDtO.builder()
                .id(savedBankAccount.getId())
                .balance(savedBankAccount.getBalance())
                .createdAt(savedBankAccount.getCreatedAt())
                .type(savedBankAccount.getType())
                .currency((savedBankAccount.getCurrency()))
                .build();
        return bankAccountResponseDtO;
    }
}
