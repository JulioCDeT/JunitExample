package io.juliocdet.service;

import io.juliocdet.model.Contacto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendaService {

    private List<Contacto> contactos;

    public AgendaService(Contacto... contactos) {
        this.contactos = new ArrayList<>();
        for (Contacto contacto: contactos) {
            this.contactos.add(contacto);
        }
    }

    public List<Contacto> getContactos() {
        return this.contactos;
    }

    public void limpiarAgenda() {
        contactos.clear();
    }

    public Contacto findContacto(String name) {
        Optional<Contacto> optionalContacto = contactos
                .stream()
                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(name))
                .findFirst();
        return optionalContacto.isPresent() ? optionalContacto.get() : null;
    }

    public Contacto findContactoByNumber(String telefono) {
        Optional<Contacto> optionalContacto = contactos
                .stream()
                .filter(contacto -> contacto.getTelefono().equals(telefono))
                .findFirst();
        return optionalContacto.isPresent() ? optionalContacto.get() : null;
    }

}
