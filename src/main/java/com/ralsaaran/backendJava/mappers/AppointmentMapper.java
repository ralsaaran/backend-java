package com.ralsaaran.backendJava.mappers;

import com.ralsaaran.backendJava.model.dto.requests.AddAppointment;
import com.ralsaaran.backendJava.model.dto.responses.PatientAppointmentsHistory;
import com.ralsaaran.backendJava.model.dto.responses.SearchAppointmentRespons;
import com.ralsaaran.backendJava.model.entities.Appointments;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper {
    public static Appointments toAppointmentEntity(AddAppointment addAppointment) throws ParseException {
        Appointments entity = new Appointments();
        entity.setIdNumber(addAppointment.getIdNumber());
        entity.setName(addAppointment.getName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date parsed = format.parse(addAppointment.getDate()+":00");
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        entity.setAppointmentDate(sql);
        Date currentSqlDate = new Date(System.currentTimeMillis());
        entity.setCreatedAt(currentSqlDate);
        entity.setCreatedBy("System");
        entity.setActivity(true);
        return entity;
    }

    public static List<PatientAppointmentsHistory> toPatientAppointmentHistoryList(
            List<Appointments> appointmentsList) {
        List<PatientAppointmentsHistory> histories = new ArrayList<>();
        appointmentsList.forEach( appointments -> {
            PatientAppointmentsHistory appointmentsHistory = new PatientAppointmentsHistory();
            appointmentsHistory.setDate(appointments.getAppointmentDate());
            histories.add(appointmentsHistory);
        });
        return histories;
    }

    public static List<SearchAppointmentRespons> toSearchAppointmentResponsList(List<Appointments> appointments) {
        List<SearchAppointmentRespons> respons = new ArrayList<>();
        appointments.forEach( appointment -> {
            SearchAppointmentRespons appointmentRespons = new SearchAppointmentRespons();
            appointmentRespons.setIdNumber(appointment.getIdNumber());
            appointmentRespons.setName(appointment.getName());
            appointmentRespons.setDate(appointment.getAppointmentDate());

            respons.add(appointmentRespons);
        } );

        return respons;
    }
}
