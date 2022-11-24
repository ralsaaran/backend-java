package com.ralsaaran.backendJava.service.impl;

import com.ralsaaran.backendJava.mappers.AppointmentMapper;
import com.ralsaaran.backendJava.model.dto.requests.AddAppointment;
import com.ralsaaran.backendJava.model.dto.requests.CancelAppointment;
import com.ralsaaran.backendJava.model.dto.requests.Patient;
import com.ralsaaran.backendJava.model.dto.requests.SearchAppointment;
import com.ralsaaran.backendJava.model.dto.responses.PatientAppointmentsHistory;
import com.ralsaaran.backendJava.model.dto.responses.SearchAppointmentRespons;
import com.ralsaaran.backendJava.model.entities.Appointments;
import com.ralsaaran.backendJava.repository.AppointmentRepository;
import com.ralsaaran.backendJava.service.AppointmentService;
import com.ralsaaran.backendJava.specs.AppointmentSpec;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    @Override
    public void create(AddAppointment addAppointment) throws ParseException {
        Appointments appointment = AppointmentMapper.toAppointmentEntity(addAppointment);
        repository.save(appointment);
    }

    @Override
    public List<SearchAppointmentRespons> getAllAvailableAppointments(
            SearchAppointment searchAppointment
    ) {
        AppointmentSpec spec = new AppointmentSpec(searchAppointment);

        return AppointmentMapper.toSearchAppointmentResponsList(
                repository.findAll(spec)
        );
    }

    @Override
    public List<PatientAppointmentsHistory> getPatientAppointmentsHistory(
            Patient patient) {
        return AppointmentMapper.toPatientAppointmentHistoryList(
                repository.findByIdNumber(patient.getIdNumber())
        );
    }

    @Override
    public void cancelAppointment(
            CancelAppointment cancelAppointment) {
        Appointments appointments = repository.findById(cancelAppointment.getId()).get();
        appointments.setCancelReason(cancelAppointment.getReason());
        appointments.setActivity(false);
        repository.save(appointments);
    }
}
