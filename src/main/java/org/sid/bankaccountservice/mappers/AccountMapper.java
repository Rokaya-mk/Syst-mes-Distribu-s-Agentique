package org.sid.bankaccountservice.mappers;


import org.sid.bankaccountservice.dto.BankAccountRequesDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){

        BankAccountResponseDTO bankAccountResponseDtO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDtO);

        return bankAccountResponseDtO;
    }

    public BankAccount fromBankAccountRequestDTO(BankAccountRequesDTO bankAccountRequesDTO){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequesDTO,bankAccount);

        return bankAccount;
    }
}
