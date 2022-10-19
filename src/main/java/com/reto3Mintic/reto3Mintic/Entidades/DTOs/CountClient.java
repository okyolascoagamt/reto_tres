package com.reto3Mintic.reto3Mintic.Entidades.DTOs;

import com.reto3Mintic.reto3Mintic.Entidades.Client;

public class CountClient {

    private Long total;
    private Client client;

    public CountClient() {
    }

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CountClient{" +
                "total=" + total +
                ", client=" + client +
                '}';
    }
}
