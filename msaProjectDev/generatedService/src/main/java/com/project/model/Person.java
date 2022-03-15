package com.project.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name="processed_requests", schema = "public")
public class Person  {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "fullname")
    private String fullName;//Ф.И.О.

    @Column(name = "birthday")
    private LocalDate birthDay; //дата рождения

    @Column(name = "creditamount")
    private double creditAmount; //сумма кредита

    @Column(name = "termmonth")
    private int termMonth; // срок кредита

    @Column(name = "allowed")
    private boolean isAllowed; //ОДОБРЕН/НЕ ОДОБРЕН


}
