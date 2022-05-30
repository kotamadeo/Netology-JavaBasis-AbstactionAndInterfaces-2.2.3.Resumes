package com.gmail.at.kotamadeo.professions.engineers;

import com.gmail.at.kotamadeo.professions.engineers.interfaces.EngineerInterface;

public abstract class Engineer implements EngineerInterface {
    protected String name;
    protected String language;
    protected int age;
    protected int experience;

    protected Engineer(String name, String language, int age, int experience) {
        this.name = name;
        this.language = language;
        this.age = age;
        this.experience = experience;
    }

    protected abstract void whoIAm();

    protected abstract void iCan();

    protected abstract boolean isDeveloper();

    @Override
    public String toString() {
        return "1. Имя: " + name + "\n2. Возраст: " + age + "\n3. Опыт работы: " + experience;
    }
}
