package me.motyim.pattern.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        Integer [] x = {2,3,5,8};
//        List<Integer> integers = Arrays.asList(x);
//        ArrayList<Integer> integers1 = new ArrayList<Integer>();

        EmployeeClient client = new EmployeeClient();

        List<Employee> employees = client.getEmployeeList();

        System.out.println(employees);
    }
}
