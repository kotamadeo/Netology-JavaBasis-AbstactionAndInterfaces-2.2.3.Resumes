package com.gmail.at.kotamadeo.professions.engineers.interfaces;

public interface EngineerInterface {
    default String necessarySkills() {
        return "Необходимы следующие навыки: ";
    }

    void requiredSkills();
}
