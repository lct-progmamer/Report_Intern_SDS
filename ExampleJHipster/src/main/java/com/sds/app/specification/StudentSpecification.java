package com.sds.app.specification;

import com.sds.app.domain.Student;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification implements Specification<Student> {

    private ObjectCreteria objectCreteria;

    public StudentSpecification(ObjectCreteria objectCreteria) {
        this.objectCreteria = objectCreteria;
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (objectCreteria.getOperator().equals("like")) return criteriaBuilder.like(
            root.get(objectCreteria.getField().toString()),
            "%" + objectCreteria.getValue() + "%"
        );
        if (objectCreteria.getOperator().equals(">=")) return criteriaBuilder.greaterThanOrEqualTo(
            root.get(objectCreteria.getField().toString()),
            objectCreteria.getValue().toString()
        );
        if (objectCreteria.getOperator().equals("<=")) return criteriaBuilder.lessThanOrEqualTo(
            root.get(objectCreteria.getField().toString()),
            objectCreteria.getValue().toString()
        );
        return null;
    }
}
