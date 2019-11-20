package com.ragnax.politicacomercial.servicio.utilidades;

public enum TipoFormatoFecha {
    DD_MM_YYYY(1),
    HH_MM_SS(2),
    DD_MM_YYYY_HH_MM_SS(3),
    YYYY_MM_DD(4),
    YYYY_MM_ddTHH_MM_SSZ(5),
    SinEspecificar(0);
    
    private int idTipoFormatoFecha;

    private TipoFormatoFecha(int tipoFormatoFecha) {
        this.idTipoFormatoFecha = tipoFormatoFecha;
    }

    public int getTipoFormatoFecha() {
        return this.idTipoFormatoFecha;
    }

    public static TipoFormatoFecha fromInteger(int x) {
        switch (x) {
            case 1: {
                return DD_MM_YYYY;
            }
            case 2: {
                return HH_MM_SS;
            }
            case 3: {
                return DD_MM_YYYY_HH_MM_SS;
            }
            case 4: {
                return YYYY_MM_DD;
            }
            case 5: {
                return YYYY_MM_ddTHH_MM_SSZ;
            }
        }
        return SinEspecificar;
    }
}