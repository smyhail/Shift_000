package com.sub.repository;

import com.sub.model.Worker;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository <Worker, Long> {

    @Query("select w from Worker w order by w.workerSurname")
        //1.it's work
    List<Worker> getAllPerWorkerSurname(PageRequest of);


}
