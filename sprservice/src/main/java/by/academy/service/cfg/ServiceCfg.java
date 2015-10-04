package by.academy.service.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.academy.cfg.DaoCfg;

@Configuration
@ComponentScan("by.academy.service.impl")
@Import(DaoCfg.class)
public class ServiceCfg {

}
