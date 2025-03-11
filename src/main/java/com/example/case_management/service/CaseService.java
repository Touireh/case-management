package com.example.case_management.service;

import com.example.case_management.model.Case;
import com.example.case_management.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    @Autowired
    private CaseRepository caseRepository;

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case getCaseById(Long id) {
        return caseRepository.findById(id)
                .orElseThrow();
    }

    public Case createCase(Case newCase) {
        return caseRepository.save(newCase);
    }

    public Case updateCase(Long id, Case updatedCase) {
        Case existingCase = getCaseById(id);
        existingCase.setTitle(updatedCase.getTitle());
        existingCase.setDescription(updatedCase.getDescription());
        return caseRepository.save(existingCase);
    }

    public void deleteCase(Long id) {
        Case existingCase = getCaseById(id);
        caseRepository.delete(existingCase);
    }
}
