package com.gmail.at.kotamadeo.professions.engineers.classes;

import com.gmail.at.kotamadeo.professions.engineers.Engineer;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.*;
import com.gmail.at.kotamadeo.utils.Utils;

public class FullstackDeveloper extends Engineer implements JavaScript, Java, Python, CSS, HTML, DataBases {
    public FullstackDeveloper(String name, String language, int age, int experience) {
        super(name, language, age, experience);
    }

    @Override
    public void whoIAm() {
        System.out.println(Utils.ANSI_BLUE + "Я фуллстак-разработчик. Мои данные:\n" + this + "\nЯ пишу бэк на " +
                (isDeveloper() ? "Java." : "Python.") + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void iCan() {
        System.out.println(Utils.ANSI_GREEN + "Я умею: " + (isDeveloper() ? javaRequired() + ", " +
                dataBasesRequired() + "," + javaScriptRequired() + ", " + cssRequired() + ", " + htmlRequired() + "." :
                pythonRequired() + ", " + dataBasesRequired() + "," + javaScriptRequired() + ", " + cssRequired() +
                        ", " + htmlRequired() + ".") + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void requiredSkills() {
        System.out.println(Utils.ANSI_PURPLE + "На должность фуллстак-разработчика " + necessarySkills() +
                javaScriptRequired() + ", " + cssRequired() + ", " + htmlRequired() + (isDeveloper()) +
                Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public boolean isDeveloper() {
        return language.equalsIgnoreCase("Java");
    }

    @Override
    public String javaRequired() {
        return "java: Spring Framework, Collection Framework, Hibernates и JavaCore";
    }

    @Override
    public String javaScriptRequired() {
        return "JavaScript";
    }

    @Override
    public String pythonRequired() {
        return "Python";
    }

    @Override
    public String cssRequired() {
        return "CSS";
    }

    @Override
    public String htmlRequired() {
        return "HTML";
    }

    @Override
    public String dataBasesRequired() {
        return "mySQL, postgreSQL или другая объектно-реляционная система управления базами данных";
    }
}
