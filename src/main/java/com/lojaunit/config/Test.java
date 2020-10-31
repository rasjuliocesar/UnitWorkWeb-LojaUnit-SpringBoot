package com.lojaunit.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lojaunit.entities.Categoria;
import com.lojaunit.entities.Cliente;
import com.lojaunit.entities.Faq;
import com.lojaunit.entities.FormaPagamento;
import com.lojaunit.entities.Fornecedor;
import com.lojaunit.entities.ItensVenda;
import com.lojaunit.entities.Marca;
import com.lojaunit.entities.Produto;
import com.lojaunit.entities.Venda;
import com.lojaunit.repository.CategoriaRepository;
import com.lojaunit.repository.ClienteRepository;
import com.lojaunit.repository.FaqRepository;
import com.lojaunit.repository.FormaPagamentoRepository;
import com.lojaunit.repository.FornecedorRepository;
import com.lojaunit.repository.ItensVendaRepository;
import com.lojaunit.repository.MarcaRepository;
import com.lojaunit.repository.ProdutoRepository;
import com.lojaunit.repository.VendaRepository;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private FaqRepository faqRepository;
	
	@Autowired
	private ItensVendaRepository itensVendaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(null, "11111111111", "Chaves", "chaves@email.com", Instant.parse("2000-06-01T15:53:07Z"), "M", "Chaves", "Chaves", "(81)1111-2222");
		Cliente c2 = new Cliente(null, "22222222222", "Kiko", "kiko@email.com", Instant.parse("1990-01-15T11:50:03Z"), "M", "Kiko", "Kiko", "(81)2222-3333");
		Cliente c3 = new Cliente(null, "33333333333", "Chiquinha", "chiquinha@email.com", Instant.parse("1989-08-21T20:05:57Z"), "F", "Chiquinha", "Chiquinha", "(81)3333-4444");
		Cliente c4 = new Cliente(null, "44444444444", "Florinda", "florinda@email.com", Instant.parse("2002-09-29T16:33:13Z"), "F", "Dona Florinda", "Dona Florinda", "(81)4444-5555");
		Cliente c5 = new Cliente(null, "55555555555", "Clotilde", "clotilde@email.com", Instant.parse("1986-12-10T03:45:47Z"), "F", "Dona Clotilde", "Bruxa do 71", "(81)5555-6666");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		
		Categoria ct1 = new Categoria(null, "Cozinha e Acessórios", true);
		Categoria ct2 = new Categoria(null, "Cama, Mesa e Banho", true);
		Categoria ct3 = new Categoria(null, "Esportes", true);
		Categoria ct4 = new Categoria(null, "Material de Limpeza", true);
		Categoria ct5 = new Categoria(null, "Calçados", true);
		
		categoriaRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5));
		
		FormaPagamento fp1 = new FormaPagamento(null, "Dinheiro", "Pagamento realizado em dinheiro.", true);
		FormaPagamento fp2 = new FormaPagamento(null, "Cartão Débito", "Pagamento realizado com cartão de débito.", true);
		FormaPagamento fp3 = new FormaPagamento(null, "Cartão Crédito", "Pagamento realizado com cartão de crédito.", true);
		FormaPagamento fp4 = new FormaPagamento(null, "Crediário", "Pagamento realizado com crediário da loja.", true);
		
		formaPagamentoRepository.saveAll(Arrays.asList(fp1, fp2, fp3, fp4));
		
		Fornecedor f1 = new Fornecedor(null, "ABC de Letras LTDA", "Rua do Livro Vermelho n 5", "()91111-1111", "00111222000100", "abc.letras@email.com");
		Fornecedor f2 = new Fornecedor(null, "Padaria Miramar", "Avenida da Praia n 10", "()92222-2222", "11222333000111", "miramar@email.com");
		Fornecedor f3 = new Fornecedor(null, "Veraneio Vascaina LTDA", "Rodovia BR 002", "()93333-3333", "22333444000122", "veraneio@email.com");
		Fornecedor f4 = new Fornecedor(null, "Leilão de Mesa S/A", "Estrada Carneiro Arão s/n", "()94444-4444", "33444555000133", "leilao@email.com");
		Fornecedor f5 = new Fornecedor(null, "Universidade Porto False Dig.", "Rua das Mulheres n 14", "()95555-5555", "44555666000144", "uni.porto@email.com");
		
		fornecedorRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5));
		
		Marca m1 = new Marca(null, "Niko", "Material Esportivo");
		Marca m2 = new Marca(null, "Adoidas", "Material de Limpeza e Acessórios");
		Marca m3 = new Marca(null, "Pão de Ló", "Tecidos e Papéis para Embrulhos");
		Marca m4 = new Marca(null, "Carmalaty", "Produto Líquido com teor de álcool");
		Marca m5 = new Marca(null, "CNC", "Materiais Náuticos");
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
		Faq fq1 = new Faq(null, Instant.parse("2018-06-16T16:53:07Z"), "Ótimo Produto!");
		Faq fq2= new Faq(null, Instant.parse("2010-03-15T11:29:38Z"), "Problemas com Garantia");
		Faq fq3 = new Faq(null, Instant.parse("2020-10-01T21:35:22Z"), "Produto razoável");
		
		faqRepository.saveAll(Arrays.asList(fq1, fq2, fq3));
		
		ItensVenda i1 = new ItensVenda(null, 3, 22.90);
		ItensVenda i2 = new ItensVenda(null, 1, 39.99);
		ItensVenda i3 = new ItensVenda(null, 5, 104.49);
		
		itensVendaRepository.saveAll(Arrays.asList(i1, i2, i3));
		
		Produto p1 = new Produto(null, "Camisa Polo", "Camisa Polo Azul", 99.99, "UND");
		Produto p2 = new Produto(null, "Mouse sem fio", "Mouse sem fio para notebook", 59.99, "PC");
		Produto p3 = new Produto(null, "Meias", "Par de meias brancas", 39.99, "PAR");
		Produto p4 = new Produto(null, "João Andante", "Litro bebida com malte", 89.99, "LT");
		Produto p5 = new Produto(null, "TV 50'", "Televisão", 1599.99, "UND");
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Venda v1 = new Venda(null, Instant.parse("2020-03-15T16:53:07Z"), 59.99);
		Venda v2 = new Venda(null, Instant.parse("2020-05-26T09:36:24Z"), 128.56);
		Venda v3 = new Venda(null, Instant.parse("2020-06-10T15:22:17Z"), 437.27);
		
		vendaRepository.saveAll(Arrays.asList(v1, v2, v3));
	}
}
