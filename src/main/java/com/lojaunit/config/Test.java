package com.lojaunit.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lojaunit.entities.Cliente;
import com.lojaunit.repository.ClienteRepository;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "11111111111", "Chaves", "chaves@email.com", Instant.parse("2000-06-01T15:53:07Z"), "M", "Chaves", "Chaves", "(81)1111-2222");
		Cliente c2 = new Cliente(null, "22222222222", "Kiko", "kiko@email.com", Instant.parse("1990-01-15T11:50:03Z"), "M", "Kiko", "Kiko", "(81)2222-3333");
		Cliente c3 = new Cliente(null, "33333333333", "Chiquinha", "chiquinha@email.com", Instant.parse("1989-08-21T20:05:57Z"), "F", "Chiquinha", "Chiquinha", "(81)3333-4444");
		Cliente c4 = new Cliente(null, "44444444444", "Florinda", "florinda@email.com", Instant.parse("2002-09-29T16:33:13Z"), "F", "Dona Florinda", "Dona Florinda", "(81)4444-5555");
		Cliente c5 = new Cliente(null, "55555555555", "Clotilde", "clotilde@email.com", Instant.parse("1986-12-10T03:45:47Z"), "F", "Dona Clotilde", "Bruxa do 71", "(81)5555-6666");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
	}
}
