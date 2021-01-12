package io.juliocdet.service;

import io.juliocdet.model.Contacto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgendaServiceTest {

    private AgendaService agendaService;

    @Before
    public void setup() {
        agendaService = new AgendaService(
                new Contacto("Juan", "123-345-567"),
                new Contacto("Maria", "111-222-333"),
                new Contacto("Pancho", "321-654-987"),
                new Contacto("Pepe", "331-136-223")
        );
    }

    @Test
    public void limpiarAgenda_Test() {
        agendaService.limpiarAgenda();
        Assert.assertTrue("Verificamos que la agenda este vacia tras limpiarla",
            agendaService.getContactos().isEmpty());
    }

    @Test
    public void AgendaService() {
        Assert.assertEquals("Verificamos que la agenda tenda 4 contanctos",
                4, agendaService.getContactos().size());
    }

    @Test
    public void findContacto_byNameLowerCase_Test() {
        Contacto juan = Contacto.builder()
                .nombre("Juan")
                .telefono("123-345-567")
                .build();

        Contacto contactoEncontrado = agendaService.findContacto("juan");
        Assert.assertEquals("Verificamos que el contacto encontrado sea juan", juan, contactoEncontrado);
    }

    @Test
    public void findContacto_byNameUpperCase_Test() {
        Contacto juan = Contacto.builder()
                .nombre("Juan")
                .telefono("123-345-567")
                .build();

        Contacto contactoEncontrado = agendaService.findContacto("JUAN");
        Assert.assertEquals("Verificamos que el contacto encontrado sea juan", juan, contactoEncontrado);
    }

    @Test
    public void findContacto_nonFound_Test() {
        Contacto contactoEncontrado = agendaService.findContacto("jua");
        Assert.assertNull("Verificamos que el no encontramos el contacto y obtenermos null", contactoEncontrado);
    }

    @Test
    public void findContactoByNumber_positive_Test() {
        Contacto pancho = Contacto.builder()
                .nombre("Pancho")
                .telefono("321-654-987")
                .build();

        Contacto contactoEncontrado = agendaService.findContactoByNumber("321-654-987");
        Assert.assertNotNull("Verificamos que el contacto no sea null", contactoEncontrado);
        Assert.assertEquals("Verificamos que pancho sea el contacto encontrado", pancho, contactoEncontrado);
    }

    @Test
    public void findContactoByNumber_nonFound_Test() {
        Contacto contactoEncontrado = agendaService.findContactoByNumber("222-222-222");
        Assert.assertNull("Verificamos que el contacto sea null", contactoEncontrado);
    }
}
