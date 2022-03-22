package net.setlog.json.sample.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestController
public class SampleController {

    @RequestMapping(value = "/sample", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public Map<String, Object> getSample(HttpServletRequest request, @RequestBody Map<String, Object> payload) {
        log.info("-----requestURI : {}", request.getRequestURI());
        log.info("-----request-method : {}", request.getMethod());
        log.info("-----payload : {}", payload);
        Map<String, Object> map = new LinkedHashMap<>(payload);
        map.put("requestURI", request.getRequestURI());
        map.put("request-method", request.getMethod());
        return map;
    }

}
