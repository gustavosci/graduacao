package domain.comportamento;

public class ComportamentoArmazenamento {

    private Integer fotosMes;

    private Integer minutosVideosMes;

    private Integer quantidadeMediasDownload;

    public ComportamentoArmazenamento(final Integer fotosMes, final Integer minutosVideosMes,
        final Integer quantidadeMediasDownload) {

        this.fotosMes = fotosMes;
        this.minutosVideosMes = minutosVideosMes;
        this.quantidadeMediasDownload = quantidadeMediasDownload;
    }

    public Integer getFotosMes() {
        return fotosMes;
    }

    public void setFotosMes(final Integer fotosMes) {
        this.fotosMes = fotosMes;
    }

    public Integer getMinutosVideosMes() {
        return minutosVideosMes;
    }

    public void setMinutosVideosMes(final Integer minutosVideosMes) {
        this.minutosVideosMes = minutosVideosMes;
    }

    public Integer getQuantidadeMediasDownload() {
        return quantidadeMediasDownload;
    }

    public void setQuantidadeMediasDownload(final Integer quantidadeMediasDownload) {
        this.quantidadeMediasDownload = quantidadeMediasDownload;
    }
}
