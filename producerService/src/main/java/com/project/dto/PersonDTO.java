package com.project.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PersonDTO {
    private UUID id;
    //Ф.И.О.
    private String fullName;
    //дата рождения
    private LocalDate birthDay;
    //сумма кредита
    private double creditAmount;
    // срок кредита
    private int termMonth;

}
