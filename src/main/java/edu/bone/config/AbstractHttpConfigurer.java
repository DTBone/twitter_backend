package edu.bone.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;

public class AbstractHttpConfigurer {
    public static void disable(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
    }
}
