package com.sub.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Occupancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idO;
    public String machine;
    public double  occupancy;
    public String area;

    public Occupancy(String machine, double occupancy, String area) {
        this.machine = machine;
        this.occupancy = occupancy;
        this.area = area;
    }
}
