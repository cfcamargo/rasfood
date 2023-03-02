package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.model.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

public class CardapioDao {

    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> findAll(){
        String sql = "SELECT c FROM Cardapio c";

        return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void delete(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
