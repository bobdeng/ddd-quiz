package cn.bobdeng.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhiguodeng on 2017/7/3.
 */
@RestController
public class VersionControler {
    @Value("${build.version}")
    String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
