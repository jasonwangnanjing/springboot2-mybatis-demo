package com.jw.model;

import java.io.Serializable;
import java.util.List;

public class Role  implements Serializable {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permission) {
        this.permissions = permission;
    }

    private  int id;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private  String roleName;
    private  int roleCode;
    private List<Permission> permissions;


}
