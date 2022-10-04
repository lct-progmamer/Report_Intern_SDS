package com.sds.app.specification;

import com.sds.app.domain.Student;
import com.sds.app.params.SearchAndFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class StudentSpecificationBuilder {

    private SearchAndFilter param;

    public StudentSpecificationBuilder(SearchAndFilter param) {
        this.param = param;
    }

    public Specification<Student> build() {
        ObjectCreteria search = new ObjectCreteria("name", "like", param.getSearch());
        ObjectCreteria minID = new ObjectCreteria("maSv", ">=", param.getMinId());
        ObjectCreteria MaxID = new ObjectCreteria("maSv", "<=", param.getMaxId());

        Specification<Student> where = null;
        if (!StringUtils.isEmpty(param.getSearch()) && param.getSearch() != null) where = new StudentSpecification(search);
        if (param.getMinId() >= 0) {
            if (where != null) where = where.and(new StudentSpecification(minID)); else where = new StudentSpecification(minID);
        }

        if (param.getMaxId() > 0) {
            if (where != null) where = where.and(new StudentSpecification(MaxID)); else where = new StudentSpecification(MaxID);
        }
        return where;
    }
}
