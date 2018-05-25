package kr.ac.jejunu.spring;


import kr.ac.jejunu.hello.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestUserController {
    @GetMapping("{id}")
    public User get(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setName("ming");
        user.setPassword("1234");
        return user;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return user;
    }


    @PutMapping
    public User update(@RequestBody User user) {
        return user;
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id){

    }

}
