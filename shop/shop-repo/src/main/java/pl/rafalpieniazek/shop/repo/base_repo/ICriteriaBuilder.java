package pl.rafalpieniazek.shop.repo.base_repo;

import org.hibernate.Criteria;

/**
 * Created by Rafal on 2015-11-22.
 */
public interface ICriteriaBuilder<T> {
    public Criteria build();
}
