package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class User {
    private long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String webside;
    private Address address;
    private Company company;

    public User(long id,
                String name,
                String username,
                String email,
                String phone,
                String website,
                String street,
                String suite,
                String city,
                String zipcode,
                double lat,
                double lnt,
                String name2,
                String catchPhrase,
                String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.webside = website;
        this.address = new Address(street, suite, city, zipcode, lat, lnt);
        this.company = new Company(name2, catchPhrase, bs);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
    return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
    return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}


