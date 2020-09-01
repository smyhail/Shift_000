package com.sub.controller;

import com.sub.model.Occupancy;
import com.sub.model.Worker;
import com.sub.repository.OccupancyRepository;
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
public class OccupancyController {

    @Autowired
    private OccupancyRepository repoO;

    @GetMapping(value = "occupancy")
    public String showWorkers(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("dateTime", LocalDateTime.now());
        model.addAttribute("data", repoO.findAll(PageRequest.of(page, 12)));
        // model.addAttribute("data", repo.getAllPerWorkerSurname(PageRequest.of(page, 12)));
        model.addAttribute("currentPage", page);
        return "occupancy";
    }

    @PostMapping("/saveO")
    public String save(Occupancy o) {

        repoO.save(o);
        return "redirect:/occupancy";
    }

    @GetMapping("/findOneO")
    @ResponseBody
    public Optional<Occupancy> findOne(Long id) {
        return repoO.findById(id);
    }

    @GetMapping("/deleteO")
    public String deleteCountry(Long id) {
        repoO.deleteById(id);
        return "redirect:/occupancy";
    }

}
