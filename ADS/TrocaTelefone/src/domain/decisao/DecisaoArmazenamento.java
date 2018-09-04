package domain.decisao;

public class DecisaoArmazenamento {

    private Integer fotosSalvasEsperado;

    private Integer videosGravadosEsperado;

    private Integer mediasBaixadasEsperado;

    public DecisaoArmazenamento(final Integer fotosSalvasEsperado, final Integer videosGravadosEsperado,
        final Integer mediasBaixadasEsperado) {
        this.fotosSalvasEsperado = fotosSalvasEsperado;
        this.videosGravadosEsperado = videosGravadosEsperado;
        this.mediasBaixadasEsperado = mediasBaixadasEsperado;
    }

    public Integer getFotosSalvasEsperado() {
        return fotosSalvasEsperado;
    }

    public void setFotosSalvasEsperado(final Integer fotosSalvasEsperado) {
        this.fotosSalvasEsperado = fotosSalvasEsperado;
    }

    public Integer getVideosGravadosEsperado() {
        return videosGravadosEsperado;
    }

    public void setVideosGravadosEsperado(final Integer videosGravadosEsperado) {
        this.videosGravadosEsperado = videosGravadosEsperado;
    }

    public Integer getMediasBaixadasEsperado() {
        return mediasBaixadasEsperado;
    }

    public void setMediasBaixadasEsperado(final Integer mediasBaixadasEsperado) {
        this.mediasBaixadasEsperado = mediasBaixadasEsperado;
    }
}
