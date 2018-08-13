package ru.pavlovap.cucumber.steps;

import cucumber.api.java.ru.И;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyStepdefs {
    @И("^Скажу в каком я потоке \"([^\"]*)\"$")
    public void printCurrentThread(String name) throws InterruptedException {
        log.debug(name + ", поток: " + Thread.currentThread().getName());
    }
}
