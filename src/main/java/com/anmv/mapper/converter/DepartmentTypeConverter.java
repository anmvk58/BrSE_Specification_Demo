package com.anmv.mapper.converter;

import com.anmv.mapper.entities.Type;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentTypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getStatus();
    }

    @Override
    public Type convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Type.sqlToEnum(dbData);
    }
}
