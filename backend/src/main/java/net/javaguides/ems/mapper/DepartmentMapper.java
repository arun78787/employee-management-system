package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.dto.EmployeeDto;

public class DepartmentMapper {

    //convert department JPA entity into department Dto
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription()

        );
    }
    //convert department Dto into department JPA entity
    public static Department mapToDepartment(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }

}
