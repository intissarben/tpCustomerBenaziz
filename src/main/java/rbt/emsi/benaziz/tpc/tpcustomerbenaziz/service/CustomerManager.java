/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rbt.emsi.benaziz.tpc.tpcustomerbenaziz.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import rbt.emsi.benaziz.tpc.tpcustomerbenaziz.entity.Customer;

/**
 *
 * @author Intissar BENAZIZ
 */
@RequestScoped
public class CustomerManager {

    /*objet lié à l'unité de persistance référencée
     sert a envoyer requêtes*/
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }
//genere un insert sql dans la bd

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }
}
