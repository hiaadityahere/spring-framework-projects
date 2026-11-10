
package com.amazon.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    /*
     * IMPORTANT:
     * You can use either Field Injection OR Constructor Injection.
     * Do not use both approaches at the same time.
     *
     * To test Field Injection:
     * Uncomment APPROACH 1 and comment out APPROACH 2.
     *
     * To test Constructor Injection:
     * Uncomment APPROACH 2 and comment out APPROACH 1.
     */


    // ==========================================
    // APPROACH 1: FIELD INJECTION
    // ==========================================

    /*
    @Value("123")
    private int id;

    @Value("Alpha")
    private String name;

    @Value("PREMIUM")
    private String band;

    public Employee() {
    }
    */


    // ==========================================
    // APPROACH 2: CONSTRUCTOR INJECTION
    // ==========================================

    private int id;
    private String name;
    private String band;

    public Employee(
            @Value("123") int id,
            @Value("Alpha") String name,
            @Value("PREMIUM") String band) {

        this.id = id;
        this.name = name;
        this.band = band;
    }


    // ==========================================
    // DISPLAY EMPLOYEE INFORMATION
    // ==========================================

    public void displayInfo() {
        System.out.println(
            "id=" + id +
            ", name=" + name +
            ", band=" + band
        );
    }
}
