package com.pauloviniciius.foodInsta.di.service;

import com.pauloviniciius.foodInsta.di.modelo.Cliente;
import com.pauloviniciius.foodInsta.di.notificacao.NotificadorEmail;

public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public void ativar(Cliente cliente){
        cliente.ativar();
         this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }

}
