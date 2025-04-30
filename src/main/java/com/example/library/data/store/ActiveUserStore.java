package com.example.library.data.store;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class ActiveUserStore {

    public List<String> users;

    @Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }

    public ActiveUserStore() {
        users = new ArrayList<>();
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

}
