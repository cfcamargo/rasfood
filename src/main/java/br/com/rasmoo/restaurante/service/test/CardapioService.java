package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.model.Cardapio;
import br.com.rasmoo.restaurante.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {

        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de Frutos do Mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponibilidade(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponibilidade(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();

        CardapioDao cardapioDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O prato consuldato foi: "+ cardapioDao.consultar(2));


        cardapioDao.delete(salmao);
        System.out.println("O prato consuldato foi: "+ cardapioDao.consultar(2));
//        entityManager.getTransaction().commit();
        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(75.50));
        cardapioDao.atualizar(risoto);
        System.out.println("O prato consuldato foi: "+ cardapioDao.consultar(1));
    }
}
