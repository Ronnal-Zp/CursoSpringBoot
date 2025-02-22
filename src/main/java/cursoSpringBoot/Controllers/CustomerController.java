package cursoSpringBoot.Controllers;

import cursoSpringBoot.Domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers =  new ArrayList<>(Arrays.asList(
            new Customer(1,"Aldahir Zamora", "azamora", "12345"),
            new Customer(2,"Ronny Pluas", "rpluas", "12345"),
            new Customer(3,"Jose Moran", "jmoran", "12345"),
            new Customer(4,"Josue Londono", "jlondono", "12345")
    ));


    //@GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCostumers() {
        return  customers;
    }

    //@GetMapping("/{username}")
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public Customer getCustomerByUsername(@PathVariable String username) {
        for (Customer c: customers) {
            if(c.getUsername().equalsIgnoreCase(username)) {
                return  c;
            }
        }

        return null;
    }

    //@PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return  customer;
    }

    //@PutMapping()
    @RequestMapping(method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer) {
        for (Customer c: customers) {
            if(c.getId() == customer.getId()) {
              c.setName(customer.getName());
              c.setUsername(customer.getUsername());
              c.setPassword(customer.getPassword());
              return c;
            }
        }

        return null;
    }

    //@DeleteMapping("/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public Customer deleteCustomer(@PathVariable int id) {
        for (Customer c: customers) {
            if(c.getId() == id) {
                customers.remove(c);
                return c;
            }
        }

        return null;
    }

}
