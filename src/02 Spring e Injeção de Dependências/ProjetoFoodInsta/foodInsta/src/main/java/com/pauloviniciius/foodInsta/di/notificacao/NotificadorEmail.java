package com.pauloviniciius.foodInsta.di.notificacao;

import com.pauloviniciius.foodInsta.di.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail {

    public void notificar(Cliente cliente, String mensagem){
        System.out.printf("Notificação %s através do e-mail %s : %",
                cliente.getNome(), cliente.getEmail(), mensagem);

    }

}
