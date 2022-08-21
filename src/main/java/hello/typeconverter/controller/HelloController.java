package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intValue = Integer.valueOf(data); //숫자 타입으로 변경
        System.out.println("intValue = " + intValue);

        return  "ok";
    }

    /**
     * http://localhost:8080/hello-v2?data=10
     * HTTP 쿼리 스트링으로 전달하는 data=10 부분에서 10은 문자 10이다.
     * @RequestParam을 사용하면 10을 Integer 타입의 숫자 10으로 편리하게 받을 수 있다.
     * "스프링이 중간에서 타입을 변환해주었기 때문.!"
     * @param data
     * @return
     */
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);

        return  "ok";
    }

    @GetMapping("/hello-v3")
    public String helloV3(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort Port = " + ipPort.getPort());

        return "ok";
    }
}
