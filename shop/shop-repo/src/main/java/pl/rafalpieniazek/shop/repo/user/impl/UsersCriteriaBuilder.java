package pl.rafalpieniazek.shop.repo.user.impl;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import pl.rafalpieniazek.shop.repo.base_repo.ICriteriaBuilder;

public class UsersCriteriaBuilder implements ICriteriaBuilder {

    private Criteria criteria;

    @Autowired
    SessionFactory session;

    @Getter
    private Long id;

    @Getter
    private String username;


    public UsersCriteriaBuilder withUserName(String userName) {
        this.username = userName;
        return this;
    }

    public UsersCriteriaBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    // i potem UsersCriteriaBuilder.findAll().withUsername("Rafal").withID(3).build()).list();
    public static UsersCriteriaBuilder findAll() {
        return new UsersCriteriaBuilder();
    }

    public Criteria build() {
        criteria = session.getCurrentSession().createCriteria(UserRepo.class);
        if (id != null) {
            criteria.add(Restrictions.eq("id", id));
        }
        if (username != null) {
            criteria.add(Restrictions.eq("firstname", username));
        }
        // zwraca criteria z której potem mogę sobie po prostu zrobić
        // criteria.list();
        // i dostaję listę obiektów na podstawie kryterii
        return criteria;
    }
}