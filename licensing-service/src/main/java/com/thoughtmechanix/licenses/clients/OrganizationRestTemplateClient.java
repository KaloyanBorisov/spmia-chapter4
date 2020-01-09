package com.thoughtmechanix.licenses.clients;

import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrganizationRestTemplateClient {
    @Autowired
    RestTemplate restTemplate;

    public Organization getOrganization(String organizationId){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://192.168.99.100:8086/v1/organizations/{organizationId}",
                        HttpMethod.GET,
                        null, Organization.class, organizationId);
        return restExchange.getBody();
    }

    public List<Organization> getOrganizations(){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://192.168.99.100:8086/v1/organizations/",
                        HttpMethod.GET,
                        null, Organization.class);
        return null;//restExchange.getBody();
    }

    public int postOrganization(Organization organization){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://192.168.99.100:8086/v1/organizations/dummy",
                        HttpMethod.POST,
                        null, Organization.class, organization);
        return restExchange.getStatusCode().value();
    }


    public int updateOrganization(Organization organization){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://192.168.99.100:8086/v1/organizations/dummy",
                        HttpMethod.PUT,
                        null, Organization.class, organization);
        return restExchange.getStatusCode().value();
    }

    public int deleteOrganization(String organizationId){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://192.168.99.100:8086/v1/organizations/{organizationId}",
                        HttpMethod.DELETE,
                        null, Organization.class, organizationId);
        return restExchange.getStatusCode().value();
    }
}
