package com.anmv.mapper.specification;

import com.anmv.mapper.entities.Account;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {
    public static Specification<Account> buildWhere(String search){
        if (StringUtils.isEmpty(search)){
            return null;
        }

        search = search.trim();

        CustomSpecification name = new CustomSpecification("username", search);

        return Specification.where(name);
    }
}

@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {
    @NonNull
    private String field;
    @NonNull
    private Object value;

    @Override
    public Predicate toPredicate(Root<Account> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {

        if (field.equalsIgnoreCase("username")) {
            return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%" );
        }



        return null;
    }
}
