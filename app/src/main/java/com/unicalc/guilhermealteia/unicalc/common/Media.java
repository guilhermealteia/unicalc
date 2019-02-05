package com.unicalc.guilhermealteia.unicalc.common;

import com.unicalc.guilhermealteia.unicalc.CategoriasDeEnsino;
import com.unicalc.guilhermealteia.unicalc.Universidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Media {

    public static final int DEFAULT_SCALE = 2;
    private Boolean exame;
    private Double notaP1;
    private Double notaP2;
    private Double notaExame = 0.0;
    private Double mediaFinal;

    public Boolean getExame(String universidade, String categoriaDeEnsino) {
        if(Universidades.UNINOVE.toString().equals(universidade) &&  CategoriasDeEnsino.GRADUACAO.toString().equals(categoriaDeEnsino) ){
            exame = (notaP1 + notaP2) / 2 < 6;
            return exame;
        }else if(Universidades.UNINOVE.toString().equals(universidade)&& CategoriasDeEnsino.TECNOLOGO.toString().equals(categoriaDeEnsino)){
            exame = (notaP1 + notaP2) / 2 < 5;
            return exame;
        }

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
        BigDecimal bd = new BigDecimal(notaP1).setScale(DEFAULT_SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setNotaP1(Double notaP1) {
        this.notaP1 = notaP1;
    }

    public Double getNotaP2() {
        BigDecimal bd = new BigDecimal(notaP2).setScale(DEFAULT_SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setNotaP2(Double notaP2) {
        this.notaP2 = notaP2;
    }

    public Double getNotaExame() {
        BigDecimal bd = new BigDecimal(notaExame).setScale(DEFAULT_SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setNotaExame(Double notaExame) {
        this.notaExame = notaExame;
    }

    public Double getMediaFinal(String universidade, String categoriaDeEnsino, Boolean consideraExame) {
        if(consideraExame && getExame(universidade, categoriaDeEnsino)) {
            mediaFinal = (((getNotaP1() + getNotaP2())/2 ) + getNotaExame())/2;
        } else
        {
            mediaFinal = (notaP1 + notaP2)/2;
        }
        BigDecimal bd = new BigDecimal(mediaFinal).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
