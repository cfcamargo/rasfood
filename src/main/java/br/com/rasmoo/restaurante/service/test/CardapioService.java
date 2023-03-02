package br.com.rasmoo.restaurante.service.test;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.model.Cardapio;
import br.com.rasmoo.restaurante.model.Categoria;
import br.com.rasmoo.restaurante.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        cadastrarProdutoCardapio(entityManager, cadastrarCateoria(entityManager));

    }

    private static Categoria cadastrarCateoria(EntityManager entityManager){
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        entityManager.getTransaction().begin();
        categoriaDao.cadastrar(pratoPrincipal);
        entityManager.getTransaction().commit();
        entityManager.clear();

        return pratoPrincipal;
    }

    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria){
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de Frutos do Mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos");
        risoto.setDisponibilidade(true);
        risoto.setCategoria(categoria);
        risoto.setValor(BigDecimal.valueOf(88.50));


        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmao ao molho de maracuja");
        salmao.setDescricao("Salmao grelhado ao molho de maracuja");
        salmao.setDisponibilidade(true);
        salmao.setValor(BigDecimal.valueOf(60.00));
        salmao.setCategoria(categoria);


        CardapioDao cardapioDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);
        entityManager.flush();


//        System.out.println(risoto.toString());
//        System.out.println(salmao);

        cardapioDao.findAll().forEach(element -> System.out.println("O prato é: " + element));


        entityManager.close();
    }
}
