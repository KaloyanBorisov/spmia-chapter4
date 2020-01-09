package com.thoughtmechanix.licenses.clients;

import com.thoughtmechanix.licenses.model.Organization;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="organizationservice",url="http://192.168.99.100:8086")
public interface OrganizationFeignClient {

    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/organizations/",
            consumes="application/json")
    List<Organization> getOrganizations();

    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/organizations/{organizationId}",
            consumes="application/json")
    Organization getOrganization(@PathVariable("organizationId") String organizationId);

    @RequestMapping(
            method= RequestMethod.POST,
            value="/v1/organizations/dummy",
            consumes="application/json")
    void saveOrganization(@RequestBody Organization organization);

    @RequestMapping(
            method= RequestMethod.PUT,
            value="/v1/organizations/dummy",
            consumes="application/json")
    Organization updateOrganization(@RequestBody Organization organization);

    @RequestMapping(method = RequestMethod.DELETE,
            value="/v1/organizations/{organizationId}",
            consumes="application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrganization( @PathVariable("organizationId") String licenseId);
}
