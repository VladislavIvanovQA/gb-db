package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Manufacturer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaManufacturerDao implements ManufacturerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Manufacturer> findAll() {
        return entityManager.createQuery("select m from Manufacturer m").getResultList();
    }

    @Override
    public Manufacturer findById(Long id) {
        TypedQuery<Manufacturer> query = entityManager.createNamedQuery("Manufacturer.findById", Manufacturer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> query = entityManager.createNamedQuery("Manufacturer.findNameById", String.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        if (manufacturer.getId() == null) {
            entityManager.persist(manufacturer);
        } else {
            entityManager.merge(manufacturer);
        }
        return manufacturer;
    }

    @Override
    public void deleteById(Long id) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        manufacturer = entityManager.merge(manufacturer);
        entityManager.remove(manufacturer);
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        manufacturer = entityManager.merge(manufacturer);
        entityManager.remove(manufacturer);
    }
}
