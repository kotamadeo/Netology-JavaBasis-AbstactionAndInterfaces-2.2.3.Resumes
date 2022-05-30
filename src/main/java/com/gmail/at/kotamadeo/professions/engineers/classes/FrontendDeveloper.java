package com.gmail.at.kotamadeo.professions.engineers.classes;

import com.gmail.at.kotamadeo.professions.engineers.Engineer;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.CSS;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.HTML;
import com.gmail.at.kotamadeo.professions.engineers.interfaces.JavaScript;
import com.gmail.at.kotamadeo.utils.Utils;

public class FrontendDeveloper extends Engineer implements CSS, HTML, JavaScript {
    public FrontendDeveloper(String name, String language, int age, int experience) {
        super(name, language, age, experience);
    }

    @Override
    public void whoIAm() {
        System.out.println(Utils.ANSI_BLUE + "Я фронтэнд-разработчик. Мои данные:\n" + this + "\nЯ пишу на " +
                (isDeveloper() ? "React." : "Vue.") + Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void iCan() {
        System.out.println(Utils.ANSI_GREEN + "Я умею: " + cssRequired() + ", " + htmlRequired() + ", " +
                javaScriptRequired() + ", а также знаю фреймворк " + (isDeveloper() ? "React." : "Vue.") +
                Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public void requiredSkills() {
        System.out.println(Utils.ANSI_PURPLE + (isDeveloper() ? "На должность React-разработчика " +
                necessarySkills() + javaScriptRequired() + ", " + htmlRequired() + ", " + cssRequired() +
                ", а также знание React." : "На должность " + "Vue-разработчика " + necessarySkills() +
                javaScriptRequired() + ", " + htmlRequired() + ", " + cssRequired() + ", а также знание Vue.") +
                Utils.ANSI_RESET);
        Utils.printDelim();
    }

    @Override
    public boolean isDeveloper() {
        return language.equals("React");
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
    public String javaScriptRequired() {
        return "JavaScript";
    }
}
