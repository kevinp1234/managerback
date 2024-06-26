package com.football.managerback.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public static String localDateToString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }

    public static LocalDate stringToLocalDate(String dateString) {
        // Parse the dateString to a LocalDate object
        return LocalDate.parse(dateString);
    }

}
