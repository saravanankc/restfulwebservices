package com.kc.learnings.spring.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> FindAll(){
        return UserDaoService.users;
    }

    public User FindOne(int id){
        for (User user: UserDaoService.users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User save(User user){
        if(user.getId() == 0){
            user.setId(++usersCount);
        }
        UserDaoService.users.add(user);
        return user;
    }

    public User delete(int id){
        Iterator<User> userIterator = UserDaoService.users.iterator();

        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getId() == id){
                userIterator.remove();
                return user;
            }
        }
        return null;

    }
}
