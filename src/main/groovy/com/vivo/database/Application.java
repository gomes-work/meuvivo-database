package com.vivo.database;

import com.vivo.database.repository.ProcConsultaDadosCliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class Application
{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*@Autowired
	ProcConsultaDadosCliente consultaDadosCliente;*/

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		log.info("Sample App");
		//Map<String, Object> objectMap = consultaDadosCliente.execute("teste@xpto.com", null, null, null, null);
		//System.out.println(objectMap);
	}

	@Bean
	ProcConsultaDadosCliente dadosCliente(DataSource dataSource) {
		return new ProcConsultaDadosCliente(dataSource);
	}
}
