package domain;

public enum AvaliacaoTravamento {

    TRAVAMENTO_1(1),
    TRAVAMENTO_2(2),
    TRAVAMENTO_3(3),
    TRAVAMENTO_4(4),
    TRAVAMENTO_5(5);

    private Integer avaliacao;

    AvaliacaoTravamento(final Integer avaliacao){
        this.avaliacao = avaliacao;
    }

    public Integer getAvaliacao(){
        return avaliacao;
    }


    public static AvaliacaoTravamento toEnum(final Integer avaliacao) {
        if( avaliacao == null) {
            return null;
        }

        for( AvaliacaoTravamento a : AvaliacaoTravamento.values()) {
            if(avaliacao.equals(a.getAvaliacao())) {
                return a;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + avaliacao);
    }
}
