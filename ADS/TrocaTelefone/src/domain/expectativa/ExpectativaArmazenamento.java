package domain.expectativa;

public class ExpectativaArmazenamento {
	
	private Integer qtdMesesEsperado;

    private Integer fotosSalvasEsperado;

    private Integer videosGravadosEsperado;

    private Integer mediasBaixadasEsperado;

    public Integer getQtdMesesEsperado() {
		return qtdMesesEsperado;
	}

	public void setQtdMesesEsperado(Integer qtdMesesEsperado) {
		this.qtdMesesEsperado = qtdMesesEsperado;
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
