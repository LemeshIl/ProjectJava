package com.project.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PersonDTO {
    private UUID id;
    private String fullName;
    private LocalDate birthday;
    private double creditAmount;
    private int termMonth;
}
