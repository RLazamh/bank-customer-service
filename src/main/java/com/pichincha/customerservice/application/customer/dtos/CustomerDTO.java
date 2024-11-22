package com.pichincha.customerservice.application.customer.dtos;
import com.pichincha.customerservice.application.person.dtos.PersonDTO;

public class CustomerDTO extends PersonDTO {
    private Long clientId;
    private String password;
    private Boolean status;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}