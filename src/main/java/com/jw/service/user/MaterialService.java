package com.jw.service.user;

import com.jw.model.Material;

public interface MaterialService {

    int createMaterial(Material material);
    int updateMaterial(Material material);
    int deleteMaterial(Material material);
    Material getMaterial(int id);
}
