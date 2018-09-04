package domain.comportamento;

public class ComportamentoBateria {

    private Integer minutosVideo;

    private Integer minutosRedesSociais;

    private Integer minutosMusica;

    private Integer minutosOutrasOperacoes;

    public Integer getMinutosVideo() {
        return minutosVideo;
    }

    public void setMinutosVideo(final Integer minutosVideo) {
        this.minutosVideo = minutosVideo;
    }

    public Integer getMinutosRedesSociais() {
        return minutosRedesSociais;
    }

    public void setMinutosRedesSociais(final Integer minutosRedesSociais) {
        this.minutosRedesSociais = minutosRedesSociais;
    }

    public Integer getMinutosMusica() {
        return minutosMusica;
    }

    public void setMinutosMusica(final Integer minutosMusica) {
        this.minutosMusica = minutosMusica;
    }

    public Integer getMinutosOutrasOperacoes() {
        return minutosOutrasOperacoes;
    }

    public void setMinutosOutrasOperacoes(final Integer minutosOutrasOperacoes) {
        this.minutosOutrasOperacoes = minutosOutrasOperacoes;
    }
}
