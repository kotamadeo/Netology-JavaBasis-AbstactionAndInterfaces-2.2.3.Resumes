# **Задача № 3 Резюме инженеров**

## **Цель**:
1. Создать HR-систему с базой резюме. У вас есть база кандидатов. У всех кандидатов разные специализации и навыки.
2. Создать навыки виде интерфейсов: **Css, Html, Databases** и другие;
3. Создать иерархию классов профессий на основе базового класса **Engineer**;
4. Каждая профессия должна реализовывать любые подходящие интерфейсы из пункта 2 и наследовать общий интерфейс **Engineer**.

### *Пример*:

``` Пример 1
1. Для этой иерархии вам нужен базовый класс, например, Engineer.
2. Также нужны наследники, представляющие собой отдельные професии: FrontEndDeveloper, FullStackDesigner, PythonDeveloper, WebDeveloper.
И интерфейсы, представляющие собой навыки. Они могут быть общими у разных профессий. Например, Css, Html, Databases и другие. 
Это более творческое задание, вы можете отклоняться от предложенных выше сущностей, если у вас есть другие идеи. 
Требуется только иерархия классов и интерфейсов с названиями методов.
```

### **Моя реализация**:
1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов и интерфейсов:

* **Program** - класс, отвечающий за запуск программы, путем инициирования метода *start()* с инициированием внутри себя
  вспомогательных ```void``` методов: 
  * *printMenu()* - выводит меню команд программы на экран; 
  * *printList()* - выводит списки резюме на экран;

#### Класс **Program**:
``` java
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
```

* **Engineer** - абстрактный класс, описывающий инженера в целом и являющийся суперклассом для классов: **MobileDeveloper, FrontendDeveloper,  и BackendDeveloper**. 
Имеет следующие важные ```void``` методы: *whoIAm()*, который моделирует рассказ разработчика о себе,  и *iCan()*, который моделирует рассказ об умениях разработчика. ```boolean``` метод *isDeveloper()*, позволяющий с помощью тернарного оператора менять логику в вышеуказанных методах.
 Также класс имеет переопределенный метод *toString()*

#### Класс **Engineer**:
``` java   
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
```
* **Интерфейсы навыков: CSS, DataBases, HTML, Java, JavaScript, Kotlin, Python и Swift.** 
* **BackendDeveloper** - класс, описывающий бэкэнд-разработчика. Реализуется путем переопределения методов **Engineer** и реализации интерфейсов: **EngineerInterface, Java, Python и DataBases**;
* **MobileDeveloper** - класс, описывающий мобильного-разработчика. Реализуется путем переопределения методов **Engineer** и реализации интерфейсов: **EngineerInterface, Kotlin, Swift и DataBases**;
* **FrontendDeveloper** - класс, описывающий фронтэнд-разработчика. Реализуется путем переопределения методов **Engineer** и реализации интерфейсов: **CSS, HTML и JavaScript**;
* **FullstackDeveloper** - класс, описывающий фуллстак-разработчика. Реализуется путем переопределения методов **Engineer** и реализации интерфейсов: **JavaScript, Java, Python, CSS, HTML, DataBases**;
* **EngineerInterface** - интерфейс, описывающий необходимые и требуемые навыки для разработчика. Имеет ```void``` метод *requiredSkills()*, позволяющий сказать какие навыки ему необходимы и метод *necessarySkill()*, возвращающий строковое значение.

#### Класс **EngineerInterface**:
``` java   
public interface EngineerInterface {
    default String necessarySkills() {
        return "Необходимы следующие навыки: ";
    }

    void requiredSkills();
}
```

2. Использовал кодирование цвета текста (ANSI).

#### Класс **Utils**:
``` java
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }
}
```

3. Использовал ```try-catch```, чтобы избежать падение программы в исключения.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        var program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
Эта программа эмулирует работу HR-менеджера!
Возможные команды программы:
0 или выход: выход из программы.
1: добавить разработчика в список:
2: вывести список разработчиков:
3: демонстрация работы методов:
```

* Демонстрация работы:
```
1
Введите отрасль разработки (мобильная, бэк, фронт или фулл):
мобильная
Введите имя разработчика, язык программирования (Java, Kotlin, etc), его возраст и опыт в годах через "_":
Эрик Темницкий_Swift_26_1

1
Введите отрасль разработки (мобильная, бэк, фронт или фулл):
бэк
Введите имя разработчика, язык программирования (Java, Kotlin, etc), его возраст и опыт в годах через "_":
Филипп Воронов_Java_30_6

1
Введите отрасль разработки (мобильная, бэк, фронт или фулл):
бэк
Введите имя разработчика, язык программирования (Java, Kotlin, etc), его возраст и опыт в годах через "_":
Анна Иванова_Python_30_5

2
1.
1. Имя: Эрик Темницкий
2. Возраст: 25
3. Опыт работы: 1.
*********************************************
2.
1. Имя: Филипп Воронов
2. Возраст: 30
3. Опыт работы: 6.
*********************************************
3.
1. Имя: Анна Иванова
2. Возраст: 30
3. Опыт работы: 5.
*********************************************

3
Мобильные разработчики:
Я - IOS. Мои данные:
1. Имя: Эрик Темницкий
2. Возраст: 25
3. Опыт работы: 1
*********************************************
Я умею: Swift, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
На должность IOS-разработчика Необходимы следующие навыки: Swift, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
Бэкэнд-разработчики:
Я - Java-разработчик. Мои данные:
1. Имя: Филипп Воронов
2. Возраст: 30
3. Опыт работы: 6
*********************************************
Я умею: Java: Spring Framework, Collection Framework, Hibernates и JavaCore, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
На должность Java-разработчика Необходимы следующие навыки: Java: Spring Framework, Collection Framework, Hibernates и JavaCore, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
Я - Python-разработчик. Мои данные:
1. Имя: Анна Иванова
2. Возраст: 30
3. Опыт работы: 5
*********************************************
Я умею: Python, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
На должность Python-разработчика Необходимы следующие навыки: Python, mySQL, postgreSQL или другая объектно-реляционная система управления базами данных.
*********************************************
```