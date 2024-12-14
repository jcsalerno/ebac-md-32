package cesar.salerno.ebac;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class Main {
	public static void main(String[] args) {
		// Criando o EntityManager
		EntityManagerFactory emf = createEntityManagerFactory("produtoPU");
		EntityManager em = emf.createEntityManager();

		try {
			// Iniciando a transação
			em.getTransaction().begin();

			// Criando um novo Produto
			Produto produto = new Produto();
			produto.setNome("Notebook");
			produto.setValor(new BigDecimal("3500.00"));
			produto.setDescricao("Notebook potente para programadores.");

			// Salvando no banco de dados
			em.persist(produto);

			// Finalizando a transação
			em.getTransaction().commit();

			System.out.println("Produto salvo com sucesso!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
