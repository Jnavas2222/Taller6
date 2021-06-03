package edu.unbosque.Taler6.resources.pojos;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    private String username;

    private int person_id;

    private String name;

    private String address;

    private String neighborhood;

    private List<Pet> pets = new ArrayList<Pet>();

    public Owner(String user, int person, String name, String address, String neighborhood){
        this.username = user;
        this.person_id = person;
        this.name = name;
        this.address = address;
        this.name = neighborhood;
    }

    public Owner(String username, int person_id, String name, String address, String neighborhood, List<Pet> pets) {
        this.username = username;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
