package com.example.case_management.controller;
import com.example.case_management.model.Case;
import com.example.case_management.service.CaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CaseControllerTest {

    @Mock
    private CaseService caseService;

    @InjectMocks
    private CaseController caseController;

    private MockMvc mockMvc;

    @Test
    public void shouldReturnListOfCases() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(caseController).build();
        
        List<Case> caseList = Arrays.asList(
                new Case(1L, "Test Case 1", "Description 1", null, null),
                new Case(2L, "Test Case 2", "Description 2", null, null)
        );

        when(caseService.getAllCases()).thenReturn(caseList);

        mockMvc.perform(get("/cases")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].title").value("Test Case 1"));
    }
}
