package com.ralsaaran.backendJava.specs;


import com.ralsaaran.backendJava.model.dto.requests.SearchAppointment;
import com.ralsaaran.backendJava.model.entities.Appointments;
import com.ralsaaran.backendJava.util.DateUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
public class AppointmentSpec implements Specification<Appointments> {

    private SearchAppointment query;

    @Override
    public Predicate toPredicate(
            Root<Appointments> root,
            CriteriaQuery<?> cq,
            CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if(StringUtils.isNotBlank(query.getName())){
            predicates.add(criteriaBuilder.equal(root.get("name"), query.getName()));
        }

        if(StringUtils.isNotBlank(query.getDateFrom())){
            Date appointmentDateFrom = DateUtils.convertStringToDate(query.getDateFrom(), "yyyy-MM-dd");
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("appointmentDate"), appointmentDateFrom));
        }

        return andTogether(predicates, criteriaBuilder);
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb){
        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
