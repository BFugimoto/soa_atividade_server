package com.projeto.api;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.User;
import com.projeto.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UserApi {
    private UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<User>> listar() {
        return new ResponseEntity<Iterable<User>>(this.userService.listar(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> cadastrar(@RequestBody User user) {
        return new ResponseEntity<User>(this.userService.salvar(user), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<User> getPorId(@PathVariable("id") long id) {
        Optional<User> opUser = this.userService.getPorId(id);
        if (opUser.isPresent()) {
            return new ResponseEntity<User>(opUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<User> alterar(@RequestBody User user) {
        return new ResponseEntity<User>(this.userService.salvar(user), HttpStatus.OK);
    }


}
