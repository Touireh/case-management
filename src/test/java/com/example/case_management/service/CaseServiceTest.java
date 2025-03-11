package com.example.case_management.service;

import com.example.case_management.model.Case;
import com.example.case_management.repository.CaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaseServiceTest {

    @Mock
    private CaseRepository caseRepository;

    @InjectMocks
    private CaseService caseService;

    private Case testCase;

    @BeforeEach
    void setup() {
        testCase = new Case(1L, "Test Case", "Test Description", null, null);
    }

    @Test
    public void shouldReturnCaseWhenIdExists() {
        when(caseRepository.findById(1L)).thenReturn(Optional.of(testCase));

        Case foundCase = caseService.getCaseById(1L);

        assertThat(foundCase).isNotNull();
        assertThat(foundCase.getTitle()).isEqualTo("Test Case");
    }


    @Test
    public void shouldDeleteCaseSuccessfully() {
        when(caseRepository.findById(1L)).thenReturn(Optional.of(testCase));
        doNothing().when(caseRepository).delete(testCase);

        caseService.deleteCase(1L);

        verify(caseRepository, times(1)).delete(testCase);
    }

}
