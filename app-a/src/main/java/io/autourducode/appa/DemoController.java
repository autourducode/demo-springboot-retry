package io.autourducode.appa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rickenbazolo
 */
@RestController
@RequestMapping("/app-a")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/service/app-b")
    public ResponseEntity<String> getAppB() {
        return ResponseEntity.ok(demoService.serviceAppB());
    }
}
