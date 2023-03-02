package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.model.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        this.entityManager.persist(cardapio);
        System.out.println("Entidade Cadastrada: " + cardapio);
    }

    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void delete(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
