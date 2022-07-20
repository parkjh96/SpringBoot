package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // @RequestParam(name = "name", required= True||false) default = True이기 때문에 값을 넣어줘야함
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // http body 부분에 직접 넣어주겠다 라는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name; // hello 문자(string) 으로 변환 예정 view가 없고 문자가 그대로 내려감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String nmae){
        Hello hello = new Hello(); // ctrl + shift + enter 자동완성
        hello.setName(nmae);
        return hello;
    }

    static class Hello{
        private String name;

        // alt + insert 입력
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
