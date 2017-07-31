package com.example.demo.Controller;

import com.example.demo.Model.Users;
import com.example.demo.Repository.UserJpaRespository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.annotation.ExceptionProxy;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Andriansyah YR on 7/29/2017.
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserJpaRespository userJpaRepository;
//    @Autowired
//    private UserDAO userDAO;

    @GetMapping(value = "/all")
    public List<Users> findAll(){
        return userJpaRepository.findAll();
    }

    @GetMapping(value = "/teamname/{team_name}")
    public List<Users> findByTeamName(@PathVariable String team_name){
        return userJpaRepository.findByTeamName(team_name);
    }
    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name){
        return userJpaRepository.findByName(name);
    }

    @PostMapping(value = "/load")
//    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public Users load(@RequestBody final Users users){
        userJpaRepository.save(users);
        return  userJpaRepository.findByName(users.getName());
    }

    @GetMapping(value = "/delete/{Id}")
    public String deleteUser(@PathVariable long id){
        try{
            Users user = new Users();
            user = userJpaRepository.findOne(id);
            userJpaRepository.delete(user);
        }catch (Exception e) {
            return "Error deleting id : " + id;
        }
        return "Success deleting id : "+id;
    }

    @PostMapping(value = "/update")
    public String updateUsers(@RequestBody final Users users){
        try{
            Users u = new Users();
            u = userJpaRepository.findByName(users.getName());
            u.setName(users.getName());
            u.setSalary(users.getSalary());
            u.setTeamName(users.getTeamName());
            u.setIsDeleted(users.getIsDeleted());
            userJpaRepository.save(u);
        }catch (Exception e){
            return "Error Updating";
        }
        return "Success Update";
    }

}
