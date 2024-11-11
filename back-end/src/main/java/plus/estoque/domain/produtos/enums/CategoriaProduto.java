package plus.estoque.domain.produtos.enums;

public enum CategoriaProduto {
    ELETRONICOS("Eletrônicos"),
    ROUPAS_E_ACESSORIOS("Roupas e Acessórios"),
    ALIMENTOS_E_BEBIDAS("Alimentos e Bebidas"),
    MOVEIS("Móveis"),
    ELETRODOMESTICOS("Eletrodomésticos"),
    BRINQUEDOS_E_JOGOS("Brinquedos e Jogos"),
    LIVROS("Livros"),
    FERRAMENTAS_E_MATERIAIS_DE_CONSTRUCAO("Ferramentas e Materiais de Construção"),
    PRODUTOS_DE_BELEZA_E_CUIDADOS_PESSOAIS("Produtos de Beleza e Cuidados Pessoais"),
    EQUIPAMENTOS_ESPOTIVOS("Equipamentos Esportivos"),
    SAUDE_E_BEM_ESTAR("Saúde e Bem-estar"),
    PRODUTOS_PARA_ANIMAIS_DE_ESTIMACAO("Produtos para Animais de Estimação"),
    INFORMATICA_E_ACESSORIOS("Informática e Acessórios"),
    AUTOMOTIVO("Automotivo"),
    JARDINAGEM("Jardinagem"),
    ARTIGOS_DE_PAPELARIA("Artigos de Papelaria"),
    JOIAS_E_RELOGIOS("Joias e Relógios"),
    INSTRUMENTOS_MUSICAIS("Instrumentos Musicais"),
    PRODUTOS_PARA_BEBES("Produtos para Bebês"),
    PRODUTOS_DE_LIMPEZA("Produtos de Limpeza"),
    MATERIAL_DE_ESCRITORIO("Material de Escritório"),
    EQUIPAMENTOS_INDUSTRIAIS("Equipamentos Industriais"),
    DECORACAO("Decoração"),
    CASA_E_COZINHA("Casa e Cozinha"),
    SEGURANCA_E_VIGILANCIA("Segurança e Vigilância"),
    VIAGEM_E_LAZER("Viagem e Lazer"),
    PRODUTOS_DE_FESTA("Produtos de Festa"),
    ARTIGOS_RELIGIOSOS("Artigos Religiosos"),
    PRODUTOS_SUSTENTAVEIS("Produtos Sustentáveis"),
    SOFTWARE("Software"),
    EQUIPAMENTOS_DE_FOTOGRAFIA("Equipamentos de Fotografia"),
    MODA_INTIMA("Moda Íntima"),
    PRODUTOS_EROTICOS("Produtos Eróticos"),
    BEBIDAS_ALCOOLICAS("Bebidas Alcoólicas"),
    ARTESANATO("Artesanato"),
    PRODUTOS_DE_COLECIONADOR("Produtos de Colecionador"),
    UTILIDADES_DOMESTICAS("Utilidades Domésticas"),
    PRODUTOS_DE_FARMACIA("Produtos de Farmácia"),
    MODA_PRAIA("Moda Praia"),
    MATERIAL_ESCOLAR("Material Escolar"),
    PRODUTOS_HOSPITALARES("Produtos Hospitalares"),
    PRODUTOS_NATURAIS("Produtos Naturais"),
    PRODUTOS_PARA_CABELOS("Produtos para Cabelos"),
    ACESSORIOS_DE_VEICULOS("Acessórios de Veículos"),
    COMPONENTES_ELETRONICOS("Componentes Eletrônicos"),
    ARTIGOS_MILITARES("Artigos Militares"),
    PRODUTOS_PARA_BANHO("Produtos para Banho"),
    CALCADOS("Calçados"),
    BEBIDAS_NAO_ALCOOLICAS("Bebidas Não Alcoólicas"),
    ALIMENTOS_ORGANICOS("Alimentos Orgânicos");

    private final String descricao;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

