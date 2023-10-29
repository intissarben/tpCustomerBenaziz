/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rbt.emsi.benaziz.tpc.tpcustomerbenaziz.service;

import rbt.emsi.benaziz.tpc.tpcustomerbenaziz.entity.Discount;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


/**
 *
 * @author Intissar BENAZIZ
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext
    private EntityManager em;
    
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }
}
