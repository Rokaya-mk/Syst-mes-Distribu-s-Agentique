package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDtO;
import org.sid.bankaccountservice.entities.BankAccount;

public interface AccountService {

    public BankAccountResponseDtO addAccount(BankAccountRequesDTO bankAccountDTO);
}
