package com.cdk.carbuy.dao;

/**
 * Created by guptah on 9/1/2016.
 */
import com.cdk.carbuy.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by guptah on 8/24/2016.
 */
@Component
public class CustomerDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Customer addCustomer(Customer customer) {
        com.cdk.carbuy.domain.Customer customer1 = new com.cdk.carbuy.domain.Customer(customer);
        hibernateTemplate.save(customer1);
        return customer;
    }

    public void deleteCustomer(int customerId) {
        com.cdk.carbuy.domain.Customer customer = (com.cdk.carbuy.domain.Customer) hibernateTemplate.get(com.cdk.carbuy.domain.Customer.class,customerId);
        hibernateTemplate.delete(customer);
    }

    public Customer get(int customerId) {
        return new Customer(hibernateTemplate.get(com.cdk.carbuy.domain.Customer.class,customerId));
    }

}
