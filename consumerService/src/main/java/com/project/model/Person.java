package com.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "processed_requests", schema = "public")
public class Person implements Serializable {
    @Id
    private UUID id;
    //Ф.И.О.
    private String fullName;
    //дата рождения
    private LocalDate birthday;
    //сумма кредита
    private double creditAmount;
    // срок кредита
    private int termMonth;
    //ОДОБРЕН/НЕ ОДОБРЕН
    private boolean allowed;
}
