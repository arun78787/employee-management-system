package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
//@Service
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    //build create of add department rest api
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    //build get Department rest api
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }
    //build get all departments rest api
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    //build update department rest api
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId,
                                                          @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto departmentDto = departmentService.updateDepartment(departmentId, updatedDepartment);

        return ResponseEntity.ok(departmentDto);
    }
    //build delete department rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully.");
    }

}
