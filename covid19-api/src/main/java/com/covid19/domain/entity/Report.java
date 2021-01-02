package com.covid19.domain.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item_entity")
public class Report {

    @Id
    public String stateDate;

    public int confirmNumber;

    public int getConfirmNumber(){
        return confirmNumber;
    }

    @Builder
    public Report(String stateDate, int confirmNumber){
        this.stateDate = stateDate;
        this.confirmNumber = confirmNumber;
    }

}
