package com.lojaunit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaunit.entities.Cliente;
import com.lojaunit.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente update(Long id, Cliente cliente) {
		Cliente cli = clienteRepository.getOne(id);
		updateData(cli, cliente);
		return clienteRepository.save(cli);
	}

	private void updateData(Cliente cli, Cliente cliente) {
		cli.setCpf(cliente.getCpf());
		cli.setNome(cliente.getNome());
		cli.setEmail(cliente.getEmail());
		cli.setDataNascimento(cliente.getDataNascimento());
		cli.setSexo(cliente.getSexo());
		cli.setNomeSocial(cliente.getNomeSocial());
		cli.setApelido(cliente.getApelido());
		cli.setTelefone(cliente.getTelefone());
	}
}
