package com.ralsaaran.backendJava.model.dto.requests;

import lombok.Data;

@Data
public class CancelAppointment {
    Long id;
    String reason;
}
