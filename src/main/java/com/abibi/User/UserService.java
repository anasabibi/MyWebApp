package com.abibi.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> ListAll(){
        return (List<User>) repo.findAll();
    }


    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserElementException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserElementException("could not find any users wid ID "+ id);
    }


    public void delete(Integer id) throws UserElementException {
        Long count = repo.countById(id);
        if (count == null || count ==0){
            throw new UserElementException("could not find any users wid ID "+ id);

        }

        repo.deleteById(id);
    }

}
