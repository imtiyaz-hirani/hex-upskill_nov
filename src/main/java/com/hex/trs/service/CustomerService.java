package com.hex.trs.service;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.enums.Role;
import com.hex.trs.exception.InvalidIdException;
import com.hex.trs.model.Customer;
import com.hex.trs.model.User;
import com.hex.trs.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public Customer getById(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new InvalidIdException("Customer Id Invalid"));
        return customer;
    }

    public void signUp(CustomerDto customerDto) {
        // Extract username and password from Base64 AuthCode
        // Get the decoder instance
        Base64.Decoder decoder = Base64.getDecoder();
        // Decode the string into a byte array
        byte[] decodedBytes = decoder.decode(customerDto.authCode());
        // Convert the byte array back to a string using the standard UTF-8 charset
        String clearText = new String(decodedBytes, StandardCharsets.UTF_8);

        String username = clearText.split(":")[0];
        String password = clearText.split(":")[1];

        // Convert Customerdto to Customer entity
        Customer customer = new Customer();
        customer.setName(customerDto.name());
        customer.setCty(customerDto.city());
        User user = new User();
        //check if this username is unique
        userService.checkUniqueness(username);
        user.setUsername(username);

        //encrypt/encode the password
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole(Role.CUSTOMER);

        //save User in db
        user = userService.save(user);

        // Attach user to customer
        customer.setUser(user);

        // Save customer in DB
        customerRepository.save(customer);
    }
}
// Crypto : DES RSA  --> Dont reinvent the wheel :- BcryptPasswordEncoder
/*
* PasswordEncoder
*    |
* BcryptPasswordEncoder
*    |
* NewPasswordEncoder
* */