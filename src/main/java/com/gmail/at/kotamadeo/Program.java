package com.gmail.at.kotamadeo;

import com.gmail.at.kotamadeo.professions.engineers.classes.BackendDeveloper;
import com.gmail.at.kotamadeo.professions.engineers.classes.FrontendDeveloper;
import com.gmail.at.kotamadeo.professions.engineers.classes.FullstackDeveloper;
import com.gmail.at.kotamadeo.professions.engineers.classes.MobileDeveloper;
import com.gmail.at.kotamadeo.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);
    private final List<MobileDeveloper> mobileDevelopers = new ArrayList<>();
    private final List<FullstackDeveloper> fullstackDevelopers = new ArrayList<>();
    private final List<FrontendDeveloper> frontendDevelopers = new ArrayList<>();
    private final List<BackendDeveloper> backendDevelopers = new ArrayList<>();

    public void start() {
        String input;
        String[] allInput;
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                if ("выход".equalsIgnoreCase(input) || "0".equals(input)) {
                    scanner.close();
                    break;
                } else {
                    var operationNumber = Integer.parseInt(input);
                    switch (operationNumber) {
                        case 1:
                            System.out.println(Utils.ANSI_BLUE + "Введите отрасль разработки (мобильная, бэк, фронт " +
                                    "или фулл):" + Utils.ANSI_RESET);
                            input = scanner.nextLine();
                            if ("мобильная".equalsIgnoreCase(input) ||
                                    "мобильная разработка".equalsIgnoreCase(input)) {
                                System.out.println(Utils.ANSI_BLUE + "Введите имя разработчика, язык " +
                                        "программирования (Java, Kotlin, etc), его возраст и опыт в годах через \"_\"" +
                                        ":" + Utils.ANSI_RESET);
                                allInput = scanner.nextLine().split("_");
                                mobileDevelopers.add(new MobileDeveloper(allInput[0], allInput[1],
                                        Integer.parseInt(allInput[2]), Integer.parseInt(allInput[3])));
                            } else if ("фулл".equalsIgnoreCase(input) ||
                                    "фуллстак разработка".equalsIgnoreCase(input)) {
                                System.out.println(Utils.ANSI_BLUE + "Введите имя разработчика, язык " +
                                        "программирования (Java, Kotlin, etc), его возраст и опыт в годах через \"_\"" +
                                        ":" + Utils.ANSI_RESET);
                                allInput = scanner.nextLine().split("_");
                                fullstackDevelopers.add(new FullstackDeveloper(allInput[0], allInput[1],
                                        Integer.parseInt(allInput[2]), Integer.parseInt(allInput[3])));
                            } else if ("фронт".equalsIgnoreCase(input) ||
                                    "фронтэнд разработка".equalsIgnoreCase(input)) {
                                System.out.println(Utils.ANSI_BLUE + "Введите имя разработчика, язык " +
                                        "программирования (Java, Kotlin, etc), его возраст и опыт в годах через \"_\"" +
                                        ":" + Utils.ANSI_RESET);
                                allInput = scanner.nextLine().split("_");
                                frontendDevelopers.add(new FrontendDeveloper(allInput[0], allInput[1],
                                        Integer.parseInt(allInput[2]), Integer.parseInt(allInput[3])));
                            } else if ("бэк".equalsIgnoreCase(input) ||
                                    "бэкэнд разработка".equalsIgnoreCase(input)) {
                                System.out.println(Utils.ANSI_BLUE + "Введите имя разработчика, язык " +
                                        "программирования (Java, Kotlin, etc), его возраст и опыт в годах через \"_\"" +
                                        ":" + Utils.ANSI_RESET);
                                allInput = scanner.nextLine().split("_");
                                backendDevelopers.add(new BackendDeveloper(allInput[0], allInput[1],
                                        Integer.parseInt(allInput[2]), Integer.parseInt(allInput[3])));
                            } else {
                                System.out.println(Utils.ANSI_RED + "Ошибка выбора отрасли разработки!" +
                                        Utils.ANSI_RESET);
                            }
                            break;
                        case 2:
                            printList();
                            break;
                        case 3:
                            if (!mobileDevelopers.isEmpty()) {
                                System.out.println(Utils.ANSI_BLUE + "Мобильные разработчики:");
                                for (MobileDeveloper mobileDeveloper : mobileDevelopers) {
                                    mobileDeveloper.whoIAm();
                                    mobileDeveloper.iCan();
                                    mobileDeveloper.requiredSkills();
                                }
                            }
                            if (!fullstackDevelopers.isEmpty()) {
                                System.out.println(Utils.ANSI_BLUE + "Фуллстак-разработчики:");
                                for (FullstackDeveloper fullstackDeveloper : fullstackDevelopers) {
                                    fullstackDeveloper.whoIAm();
                                    fullstackDeveloper.iCan();
                                    fullstackDeveloper.requiredSkills();
                                }
                            }
                            if (!frontendDevelopers.isEmpty()) {
                                System.out.println(Utils.ANSI_BLUE + "Фронтэнд-разработчики:");
                                for (FrontendDeveloper frontendDeveloper : frontendDevelopers) {
                                    frontendDeveloper.whoIAm();
                                    frontendDeveloper.iCan();
                                    frontendDeveloper.requiredSkills();
                                }
                            }
                            if (!backendDevelopers.isEmpty()) {
                                System.out.println(Utils.ANSI_BLUE + "Бэкэнд-разработчики:");
                                for (BackendDeveloper backendDeveloper : backendDevelopers) {
                                    backendDeveloper.whoIAm();
                                    backendDeveloper.iCan();
                                    backendDeveloper.requiredSkills();
                                }
                            }
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println(Utils.ANSI_RED + "Ошибка ввода!" + Utils.ANSI_RESET);
            }
        }
    }

    private static void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Эта программа эмулирует работу HR-менеджера!" + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные команды программы:" + Utils.ANSI_RESET);
        System.out.println("0 или выход: выход из программы.");
        System.out.println("1: добавить разработчика в список:");
        System.out.println("2: вывести список разработчиков:");
        System.out.println("3: демонстрация работы методов:");
    }

    private void printList() {
        var counter = 0;
        if (!mobileDevelopers.isEmpty()) {
            for (var i = 0; i < mobileDevelopers.size(); i++) {
                counter++;
                System.out.printf("%s%s.%n%s.%s%n", Utils.ANSI_CYAN, (counter), mobileDevelopers.get(i), Utils.ANSI_RESET);
                Utils.printDelim();
            }
        }
        if (!fullstackDevelopers.isEmpty()) {
            for (var i = 0; i < fullstackDevelopers.size(); i++) {
                counter++;
                System.out.printf("%s%s.%n%s.%s%n", Utils.ANSI_CYAN, (counter), fullstackDevelopers.get(i),
                        Utils.ANSI_RESET);
                Utils.printDelim();
            }
        }
        if (!frontendDevelopers.isEmpty()) {
            for (var i = 0; i < frontendDevelopers.size(); i++) {
                counter++;
                System.out.printf("%s%s.%n%s.%s%n", Utils.ANSI_CYAN, (counter), frontendDevelopers.get(i),
                        Utils.ANSI_RESET);
                Utils.printDelim();
            }
        }
        if (!backendDevelopers.isEmpty()) {
            for (var i = 0; i < backendDevelopers.size(); i++) {
                counter++;
                System.out.printf("%s%s.%n%s.%s%n", Utils.ANSI_CYAN, (counter), backendDevelopers.get(i),
                        Utils.ANSI_RESET);
                Utils.printDelim();
            }
        }
    }
}
