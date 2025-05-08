package com.jpacourse.service.impl;

import com.jpacourse.dto.VisitsDTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao vVisitDao) {visitDao = vVisitDao;};

    @Override
    public List<VisitsDTO> patientVisits(Long id) {
        List<VisitEntity> visitEntityList = visitDao.findByPatientId(id);
        List<VisitsDTO> visitsDTOList = new ArrayList<>();
        for(VisitEntity visitEntity : visitEntityList){
            visitsDTOList.add(VisitMapper.mapToTO(visitEntity));
        }
        return visitsDTOList;
    }
}
