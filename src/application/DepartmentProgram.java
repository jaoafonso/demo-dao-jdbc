package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Department;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DepartmentProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDAO();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "D5");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(2);
        department.setName("D2");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
        DB.getConnection();
    }
}
