package Status.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "Status controller",description = "Description for status codes")
@RequestMapping("/status")
public class StatusController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
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
    @RequestMapping(value="/gls",method = RequestMethod.GET)
    public String getGlsVersion(){
        return  "This is GLS project and the version is GLS 2.0";
    }
    @RequestMapping(value="/show",method = RequestMethod.GET)
    public ResponseEntity showResponse(){
        return  new ResponseEntity("Positive Response", HttpStatus.OK);
    }
}
