package com.jpacourse.service;

import com.jpacourse.dto.VisitsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VisitServiceTest {

        @Autowired
        private VisitService visitService;

        @Transactional
        @Test
        public void testShouldFindPatientById() {
            // given
            // when
            List<VisitsDTO> visitlist = visitService.patientVisits(1L);
            // then
            assertThat(visitlist).isNotNull();

        }
}
