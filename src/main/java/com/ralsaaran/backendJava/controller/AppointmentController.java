package com.ralsaaran.backendJava.controller;

import com.ralsaaran.backendJava.model.dto.requests.AddAppointment;
import com.ralsaaran.backendJava.model.dto.requests.CancelAppointment;
import com.ralsaaran.backendJava.model.dto.requests.Patient;
import com.ralsaaran.backendJava.model.dto.requests.SearchAppointment;
import com.ralsaaran.backendJava.model.dto.responses.PatientAppointmentsHistory;
import com.ralsaaran.backendJava.model.dto.responses.SearchAppointmentRespons;
import com.ralsaaran.backendJava.service.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@Slf4j
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    //@PostMapping("create")
    @RequestMapping(method = RequestMethod.POST, value = "create")
    @ResponseStatus(HttpStatus.OK)
    public void addAppointment(
            @RequestBody
            @Valid
            AddAppointment addAppointment) throws ParseException {
        appointmentService.create(addAppointment);
    }

    //@GetMapping("home")
    @RequestMapping(method = RequestMethod.GET, value = "home")
    public List<SearchAppointmentRespons> todayAppointment(){
        return appointmentService.getTodayAppointment();
    }

//    @GetMapping("search")
    @RequestMapping(method = RequestMethod.GET, value = "search")
    public List<SearchAppointmentRespons> searchAppointment(
            @Valid
            SearchAppointment searchAppointment
    ){
        return appointmentService.getAllAvailableAppointments(searchAppointment);
    }

//    @GetMapping("history")
    @RequestMapping(method = RequestMethod.GET, value = "history")
    public List<PatientAppointmentsHistory> appointmentsHistories(
            @Valid
            Patient patient
    ){
        return appointmentService.getPatientAppointmentsHistory(patient);
    }

    //@PatchMapping("cancel")
    @RequestMapping(method = RequestMethod.PATCH, value = "cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelAppointment(
            @RequestBody
            @Valid
            CancelAppointment cancelAppointment) {
        appointmentService.cancelAppointment(cancelAppointment);
    }

}
