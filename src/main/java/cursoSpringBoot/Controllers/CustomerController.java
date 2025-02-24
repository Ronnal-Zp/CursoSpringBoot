package cursoSpringBoot.Controllers;

import cursoSpringBoot.Domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Customer>> getCostumers() {
        return ResponseEntity.ok(customers);
    }

    //@GetMapping("/{username}")
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public ResponseEntity<?> getCustomerByUsername(@PathVariable String username) {
        for (Customer c: customers) {
            if(c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el usuario '" + username + "'");
    }

    //@PostMapping()
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    //@PutMapping()
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        for (Customer c: customers) {
            if(c.getId() == customer.getId()) {
              c.setName(customer.getName());
              c.setUsername(customer.getUsername());
              c.setPassword(customer.getPassword());
              return ResponseEntity.status(HttpStatus.OK).body(c);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);
    }

    //@DeleteMapping("/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        for (Customer c: customers) {
            if(c.getId() == id) {
                customers.remove(c);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
