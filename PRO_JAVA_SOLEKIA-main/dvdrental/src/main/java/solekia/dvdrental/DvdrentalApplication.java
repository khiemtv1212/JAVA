package solekia.dvdrental;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("solekia.dvdrental.repository")
public class DvdrentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdrentalApplication.class, args);
	}

}
