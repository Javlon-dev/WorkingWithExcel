package com.company;

import com.company.controller.Controller;
import com.company.service.Service;

public class Main {

    public static void main(String[] args) {

        Controller.writeStudent("UniversityNames.xlsx", Service.universityOfUzbekistan());

    }

}