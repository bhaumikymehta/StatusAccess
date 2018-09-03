package Status.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatusController {

    @RequestMapping("/")
    public String index(){
        StringBuilder builder =new StringBuilder();
        Map<String,String> map=System.getenv();
        map.keySet().stream().forEach(element->
        {   builder.append("Environment name: "+element);
            builder.append("<br>");
            builder.append("Environment Value:"+map.get(element));
            builder.append("<br>");
            builder.append("<br>");
        });
        System.out.println(builder);
        return builder.toString();
    }
    @RequestMapping("/gls")
    public String getGlsVersion(){
        return  "This is GLS project and the version is GLS 2.0";
    }
}
