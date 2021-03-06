package com.jw.dao;

import com.jw.model.Material;

public interface MaterialDao {

    int createMaterial(Material material);
    int updateMaterial(Material material);
    int deleteMaterial(int id);
    Material getMaterial(Integer id);
}
