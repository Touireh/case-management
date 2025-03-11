package com.example.case_management.controller;

import com.example.case_management.model.Case;
import com.example.case_management.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Case> getCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(caseService.getCaseById(id));
    }

    @PostMapping
    public ResponseEntity<Case> createCase(@RequestBody Case newCase) {
        return new ResponseEntity<>(caseService.createCase(newCase), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Case> updateCase(@PathVariable Long id, @RequestBody Case updatedCase) {
        return ResponseEntity.ok(caseService.updateCase(id, updatedCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable Long id) {
        caseService.deleteCase(id);
        return ResponseEntity.noContent().build();
    }
}
