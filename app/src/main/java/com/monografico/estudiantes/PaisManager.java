package com.monografico.estudiantes;

import com.monografico.estudiantes.modelos.Pais;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PaisManager {

    public List<Pais> paises(){
        List<Pais> paisList = new ArrayList<>();

        String[] locales = Locale.getISOCountries();

        for (String codigoPais :
                locales) {
            Locale loca = new Locale("", codigoPais);

            paisList.add(new Pais(loca.getCountry(), loca.getDisplayName(),
                    String.format("https://www.countryflags.io/%s/flat/64.png", loca.getCountry())));
        }

        return paisList;
    }
}

