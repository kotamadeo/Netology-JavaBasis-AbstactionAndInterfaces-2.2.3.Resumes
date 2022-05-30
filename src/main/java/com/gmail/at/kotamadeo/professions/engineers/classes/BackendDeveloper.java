package com.gmail.at.kotamadeo.professions.engineers.classes;

import com.gmail.at.kotamadeo.professions.engineers.Engineer;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.DataBases;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.Java;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.Python;
import com.gmail.at.kotamadeo.utils.Utils;

import java.util.List;

public class BackendDeveloper extends Engineer implements Java, Python, DataBases {
    public BackendDeveloper(String name, String language, int age, int experience) {
        super(name, language, age, experience);
    }

    @Override
    public String javaRequired() {
        return "Java: Spring Framework, Collection Framework, Hibernates и JavaCore";
    }

    @Override
    public String pythonRequired() {
        return "Python";
    }

    @Override
    public void whoIAm() {
        System.out.println(Utils.ANSI_BLUE + (isDeveloper() ? "Я - Java-разработчик. Мои данные:\n" + this :
                "Я - Python-разработчик. Мои данные:\n" + this) + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void iCan() {
        System.out.println(Utils.ANSI_GREEN + "Я умею: " + (isDeveloper() ? javaRequired() + ", " +
                dataBasesRequired() + "." : pythonRequired() + ", " + dataBasesRequired() + ".") + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void requiredSkills() {
        System.out.println(Utils.ANSI_PURPLE + (isDeveloper() ? "На должность Java-разработчика " +
                necessarySkills() + javaRequired() + ", " + dataBasesRequired() + "." : "На должность " +
                "Python-разработчика " + necessarySkills() + pythonRequired() + ", " + dataBasesRequired() + ".") +
                Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public String dataBasesRequired() {
        return "mySQL, postgreSQL или другая объектно-реляционная система управления базами данных";
    }

    @Override
    public boolean isDeveloper() {
        return language.equalsIgnoreCase("Java");
    }
}
