package com.ralsaaran.backendJava.model.dto.responses;

import lombok.Data;

import java.sql.Date;

@Data
public class SearchAppointmentRespons {
    String idNumber;
    String name;
    Date date;
}
