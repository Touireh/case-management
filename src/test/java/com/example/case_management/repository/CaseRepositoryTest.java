package com.example.case_management.repository;
import com.example.case_management.model.Case;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;

    @Test
    public void shouldSaveAndRetrieveCase() {
        // Arrange
        Case newCase = new Case(null, "Test Case", "Description test", null, null);
        
        // Act
        Case savedCase = caseRepository.save(newCase);
        Optional<Case> foundCase = caseRepository.findById(savedCase.getCaseId());

        // Assert
        assertThat(foundCase).isPresent();
        assertThat(foundCase.get().getTitle()).isEqualTo("Test Case");
    }
}
