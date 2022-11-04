package com.solera.ndproyect.ndproyect.service;

import com.solera.ndproyect.ndproyect.entity.FamousOrigin;
import com.solera.ndproyect.ndproyect.repository.IFamousOrigin;
import com.solera.ndproyect.ndproyect.repository.ITripDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFamousServiceImpl implements IFamousOriginService{

    @Autowired
    private IFamousOrigin FODao;

    @Override
    public List<FamousOrigin> listOrigins() {
        return FODao.listOrigins();
    }
}
