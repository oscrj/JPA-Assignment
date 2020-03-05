package ec.ecutb.JPAAssignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CommandLine implements CommandLineRunner {

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
