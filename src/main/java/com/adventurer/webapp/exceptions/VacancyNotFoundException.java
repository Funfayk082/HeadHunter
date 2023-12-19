package com.adventurer.webapp.exceptions;

public class VacancyNotFoundException extends RuntimeException{
    public VacancyNotFoundException(String title) {
        super("Не найдена вакансия с названием " + title + "!!!");
    }
}
