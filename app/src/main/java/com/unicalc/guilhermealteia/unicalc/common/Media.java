package com.unicalc.guilhermealteia.unicalc.common;

import com.unicalc.guilhermealteia.unicalc.CategoriasDeEnsino;
import com.unicalc.guilhermealteia.unicalc.Universidades;

public class Media {

    private Boolean exame;
    private Double notaP1;
    private Double notaP2;
    private Double notaExame;
    private Double mediaFinal;

    public Boolean getExame(String universidade, String categoriaDeEnsino) {
        //UNIP GRADUACAO
        if (Universidades.UNIP.toString().equals(universidade) && CategoriasDeEnsino.GRADUACAO.toString().equals(categoriaDeEnsino))
        {
            exame = (notaP1 + notaP2) / 2 < 7;
            return exame;
        } else //UNIP TECNOLOGO
            if (Universidades.UNIP.toString().equals(universidade) && CategoriasDeEnsino.TECNOLOGO.toString().equals(categoriaDeEnsino))
            {
                exame = (notaP1 + notaP2) / 2 < 6;
                return exame;
            }
        else
        {
            return false;
        }
    }

    public void setExame(Boolean exame) {
        this.exame = exame;
    }

    public Double getNotaP1() {
        return notaP1;
    }

    public void setNotaP1(Double notaP1) {
        this.notaP1 = notaP1;
    }

    public Double getNotaP2() {
        return notaP2;
    }

    public void setNotaP2(Double notaP2) {
        this.notaP2 = notaP2;
    }

    public Double getNotaExame() {
        return notaExame;
    }

    public void setNotaExame(Double notaExame) {
        this.notaExame = notaExame;
    }

    public Double getMediaFinal(String universidade, String categoriaDeEnsino) {

        if(getExame(universidade, categoriaDeEnsino)) {
            mediaFinal = ((notaP1 + notaP2)/2) + notaExame;
        } else
        {
            mediaFinal = (notaP1 + notaP2)/2;
        }
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
