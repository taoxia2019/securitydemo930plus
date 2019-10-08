package com.lena.dto;

import com.lena.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleDTO extends Role {

    private List<Integer> permissionIds;
}
