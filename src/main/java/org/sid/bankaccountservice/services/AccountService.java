package org.sid.bankaccountservice.services;

import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface AccountService {

    BankAccountResponseDTO addAccount(BankAccountRequesDTO bankAccountDTO);
    List<BankAccountResponseDTO> bankAccountList();
    BankAccountResponseDTO getBankAccount(Long accountId) throws BankAccountNotFoundException;
    BankAccountResponseDTO updateBankAccount(BankAccountRequesDTO bankAccountRequesDTO);
    void deleteBankaccount(Long accountId);

}
