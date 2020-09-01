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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long idW;
    public String workerFirstName;
    public String workerSurname;
    public String stamp;
    public String shiftName;
    //public Date employmentDate;
    public Boolean statusWorker;

    public Worker(String workerFirstName, String workerSurname, String stamp, String shiftName, Boolean statusWorker) {
        this.workerFirstName = workerFirstName;
        this.workerSurname = workerSurname;
        this.stamp = stamp;
        this.shiftName = shiftName;
        this.statusWorker = statusWorker;
    }
}
