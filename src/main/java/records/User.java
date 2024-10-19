package records;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import records.Address;
import records.Company;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(Long id,
                   String name,
                   String username,
                   String email,
                   Address address,
                   String phone,
                   String website,
                   Company company) {}




