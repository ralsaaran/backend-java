package com.ralsaaran.backendJava.model.dto.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddAppointment {

    @NotNull
    String idNumber;
    @NotNull
    String name;
    @NotNull
    @Pattern(regexp = "yyyy-MM-dd HH:mm")
    String date;
}
