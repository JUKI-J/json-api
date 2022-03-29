package net.setlog.json.sample.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    @RequestMapping(value = "/empty", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity emptyLogFile(HttpServletRequest request) throws IOException {
        FileChannel.open(Paths.get("./logs/json-api.log"), StandardOpenOption.WRITE).truncate(0).close();
        return new ResponseEntity(HttpStatus.OK);
    }

}
