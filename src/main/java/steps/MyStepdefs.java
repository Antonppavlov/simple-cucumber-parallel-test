package steps;

import cucumber.api.java.ru.И;

public class MyStepdefs {
    @И("^Скажу в каком я потоке \"([^\"]*)\"$")
    public void printCurrentThread(String name) {
        System.out.println(name + ", поток: " + Thread.currentThread().getName());
    }
}
