package plus.estoque.domain.vendas.enums;

public enum FormaPagamento {

        PIX("Pix"),
        CARTAO_CREDITO("Cartão de crédito"),
        DEBITO("Débito"),
        DINHEIRO("Dinheiro");

        private final String pagamento;

    FormaPagamento(String pagamento) {
            this.pagamento = pagamento;
        }

        public String getPagamento() {
            return pagamento;
        }


}
