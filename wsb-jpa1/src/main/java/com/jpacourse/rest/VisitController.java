package com.jpacourse.rest;

import com.jpacourse.dto.VisitsDTO;
import com.jpacourse.service.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {this.visitService = visitService;}

    @GetMapping("/listofvisits/{id}")
    List<VisitsDTO> findVisits(@PathVariable final Long id) {
        final List<VisitsDTO> visitList = visitService.patientVisits(id);
        if (visitList.isEmpty()){
            throw new NoSuchElementException("No visits found with id: " + id);
        }
        return visitList;
    }
}
