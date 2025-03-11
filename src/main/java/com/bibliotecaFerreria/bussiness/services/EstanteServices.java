package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Estante;

import java.util.ArrayList;
import java.util.Optional;

public interface EstanteServices {
    public ArrayList<Estante> getEstantes();
    public Estante saveEstante(Estante estante);
    public Optional<Estante> getById(int id);
    public Estante updateById(Estante request, int id);
    public Boolean deleteEstante(int id);
}
