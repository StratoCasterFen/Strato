package by.academy.service.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.academy.cfg.DaoCfg;

@Configuration
@ComponentScan(basePackages = {"by.academy.service"})
@Import(DaoCfg.class)
public class ServiceCfg {

}
