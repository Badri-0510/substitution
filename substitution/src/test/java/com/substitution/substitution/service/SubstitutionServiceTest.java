package com.substitution.substitution.service;


import com.substitution.substitution.SubstitutionApplication;
import com.substitution.substitution.repository.SubstitutionRepository;
import com.substitution.substitution.repository.TimetableRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.substitution.substitution.model.Substitution;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SubstitutionApplication.class)
class SubstitutionServiceTest {

    @Autowired
    private AttendanceService substitutionService;

    @MockBean
    private TimetableRepository timetableRepository;

    @MockBean
    private SubstitutionRepository substitutionRecordRepository;

    @Test
    void testAvailableTeacherIds() {

        String day = "Monday";
        List<Integer> availableTeacherIds = List.of(104, 105, 107, 108);


        Mockito.when(timetableRepository.findTeacherIdsByDayAndP1IsNull(day.trim(), List.of(101, 103, 109)))
                .thenReturn(availableTeacherIds);


        List<Integer> result = timetableRepository.findTeacherIdsByDayAndP1IsNull(day.trim(), List.of(101, 103, 109));


        assertTrue(result.equals(availableTeacherIds), "The available teacher IDs should match the mocked data.");
    }
}
