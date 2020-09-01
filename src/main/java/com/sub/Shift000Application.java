package com.sub;

import com.sub.model.Occupancy;
import com.sub.model.Worker;
import com.sub.repository.OccupancyRepository;
import com.sub.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Shift000Application implements CommandLineRunner {

    @Autowired
    private WorkerRepository repository;

    @Autowired
    private OccupancyRepository repoO;

    public static void main(String[] args) {
        SpringApplication.run(Shift000Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Worker("Sebastian" ,  "Ubycha", "B0", "B", true)) ;
        repository.save(new Worker("Eryk" ,  "Ubh", "X0", "X", true)) ;
        repository.save(new Worker("Sebastian" ,  "Unh", "B00", "B", true)) ;

        repoO.save(new Occupancy("10", 0.33, "HPC1"));
        repoO.save(new Occupancy("46", 0.33, "HPC1"));


    }
}
