package com.jw.service.user.impl;

import com.jw.dao.MaterialDao;
import com.jw.exception.ParameterInvalidException;
import com.jw.model.Material;
import com.jw.service.user.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "materialService")
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDao materialDao;

    @Override
    public int createMaterial(Material material) {

        return materialDao.createMaterial(material);
    }

    @Override
    public int updateMaterial(Material material) {
        //check material id is not null
        if (material.getId() == null) {

            throw new ParameterInvalidException();
        }


        return materialDao.updateMaterial(material);
    }

    @Override
    public int deleteMaterial(int id) {
        return materialDao.deleteMaterial(id);
    }

    @Override
    public Material getMaterial(int id) {
        return materialDao.getMaterial(id);
    }
}
