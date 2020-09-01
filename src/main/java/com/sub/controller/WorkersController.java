package com.sub.controller;

import com.sub.model.Worker;
import com.sub.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class WorkersController {
    @Autowired
    private WorkerRepository repo;

    @GetMapping(value = "workers")
    public String showWorkers(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("dateTime", LocalDateTime.now());
        model.addAttribute("data", repo.findAll(PageRequest.of(page, 12)));
       // model.addAttribute("data", repo.getAllPerWorkerSurname(PageRequest.of(page, 12)));
        model.addAttribute("currentPage", page);
        return "workers";
    }

    @PostMapping("/saveW")
    public String save(Worker w) {

        repo.save(w);
        return "redirect:/workers";
    }

    @GetMapping("/findOneW")
    @ResponseBody
    public Optional<Worker> findOne(Long id) {
        return repo.findById(id);
    }
    @GetMapping("/deleteW")
    public String deleteCountry(Long id) {
        repo.deleteById(id);
        return "redirect:/workers";
    }

}
