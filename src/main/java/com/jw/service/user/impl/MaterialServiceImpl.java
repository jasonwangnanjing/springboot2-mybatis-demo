package com.jw.service.user.impl;

import com.jw.dao.MaterialDao;
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
        return materialDao.updateMaterial(material);
    }

    @Override
    public int deleteMaterial(Material material) {
        return materialDao.deleteMaterial(material);
    }

    @Override
    public Material getMaterial(int id) {
        return materialDao.getMaterial(id);
    }
}
