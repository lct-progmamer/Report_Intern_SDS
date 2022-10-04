package com.sds.app.specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ObjectCreteria {

    private Object field;

    private Object operator;

    private Object value;

    public ObjectCreteria(Object field, Object operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    public ObjectCreteria() {}

    public Object getField() {
        return field;
    }

    public void setField(Object field) {
        this.field = field;
    }

    public Object getOperator() {
        return operator;
    }

    public void setOperator(Object operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
