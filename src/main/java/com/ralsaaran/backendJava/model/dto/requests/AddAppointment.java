package com.ralsaaran.backendJava.model.dto.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class AddAppointment {

    @NotNull
    String idNumber;
    @NotNull
    String name;
    Date date;
}
