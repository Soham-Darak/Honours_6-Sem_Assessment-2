package com.rcoem.devops.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/devops")
public class DevopsController {

    @Value("${source.path}")
    private String path;

    @Value("${environment}")
    private String env;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Online");
    }

    @GetMapping("/env-path")
    public String getPath() {

        // Using env logic (from HEAD)
        if (env != null && env.equalsIgnoreCase("prod")) {
            return "invoked in prod";
        }

        // Using path logic (from other branch)
        if (path != null && (path.equals("dev") || path.equals("qa"))) {
            Random random = new Random();
            return String.valueOf(random.nextInt(1000));
        } else if (path != null && path.equals("prod")) {
            return "Invoke in prod";
        }

        return "invoked in " + env;
    }
}