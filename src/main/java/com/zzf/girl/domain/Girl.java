package com.zzf.girl.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Data
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String language;
    @Min(value = 18,message = "本公司不招童工")
    private Integer age;
    public Girl() {
    }
}
