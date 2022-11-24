package com.ralsaaran.backendJava.service;

import com.ralsaaran.backendJava.model.dto.requests.AddAppointment;
import com.ralsaaran.backendJava.model.dto.requests.CancelAppointment;
import com.ralsaaran.backendJava.model.dto.requests.Patient;
import com.ralsaaran.backendJava.model.dto.requests.SearchAppointment;
import com.ralsaaran.backendJava.model.dto.responses.PatientAppointmentsHistory;
import com.ralsaaran.backendJava.model.dto.responses.SearchAppointmentRespons;

import java.util.List;

public interface AppointmentService {
    void create(AddAppointment addAppointment);

    List<SearchAppointmentRespons> getAllAvailableAppointments(SearchAppointment searchAppointment);

    List<PatientAppointmentsHistory> getPatientAppointmentsHistory(Patient patient);

    void cancelAppointment(CancelAppointment cancelAppointment);

}
