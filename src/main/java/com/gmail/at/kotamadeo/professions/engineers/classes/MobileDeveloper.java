package com.gmail.at.kotamadeo.professions.engineers.classes;

import com.gmail.at.kotamadeo.professions.engineers.Engineer;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.DataBases;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.Kotlin;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.Swift;
import com.gmail.at.kotamadeo.utils.Utils;

public class MobileDeveloper extends Engineer implements Kotlin, Swift, DataBases {
    public MobileDeveloper(String name, String language, int age, int experience) {
        super(name, language, age, experience);
    }

    @Override
    public void whoIAm() {
        System.out.println(Utils.ANSI_BLUE + (isDeveloper() ? "Я - IOS-разработчик. Мои данные:\n" + this :
                "Я - Android-разработчик. Мои данные:\n" + this) + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void iCan() {
        System.out.println(Utils.ANSI_GREEN + "Я умею: " + (isDeveloper() ? swiftRequired() + ", " +
                dataBasesRequired() + "." : kotlinRequired() + ", " + dataBasesRequired() + ".") + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void requiredSkills() {
        System.out.println(Utils.ANSI_PURPLE + (isDeveloper() ? "На должность IOS-разработчика " +
                necessarySkills() + swiftRequired() + ", " + dataBasesRequired() + "." : "На должность " +
                "Android-разработчика " + necessarySkills() + kotlinRequired() + ", " + dataBasesRequired() + ".") +
                Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public boolean isDeveloper() {
        return language.equalsIgnoreCase("Swift");
    }

    @Override
    public String kotlinRequired() {
        return "Kotlin, Java";
    }

    @Override
    public String swiftRequired() {
        return "Swift";
    }

    @Override
    public String dataBasesRequired() {
        return "mySQL, postgreSQL или другая объектно-реляционная система управления базами данных";
    }
}
