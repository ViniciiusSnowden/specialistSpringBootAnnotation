Injeção de dependências é um padrão de design usado em programação para remover dependências diretas entre componentes de um sistema. No contexto do Spring Framework, um dos principais frameworks de desenvolvimento de aplicações Java, a injeção de dependências é uma técnica central.

Basicamente, a injeção de dependências no Spring permite que os objetos dependam de abstrações, em vez de dependerem de implementações concretas. Isso é alcançado através da inversão de controle (IoC), onde o controle sobre a criação e gerenciamento de objetos é transferido para um container IoC, como o ApplicationContext no Spring.

No Spring Framework, você pode definir beans (objetos gerenciados pelo container IoC) em um arquivo de configuração XML, em classes Java com anotações específicas ou através de configuração baseada em Java. O container Spring então injeta as dependências nos objetos conforme necessário, com base nas configurações fornecidas.

Por exemplo, se você tem uma classe A que depende de uma implementação de uma interface B, ao invés de A instanciar diretamente uma implementação de B, o Spring Framework irá criar uma instância de B e injetá-la em A automaticamente.

Isso torna o código mais modular, flexível e facilita a manutenção, pois as dependências entre os componentes são gerenciadas de forma centralizada e transparente.


´´ 
// MessageService.java
public interface MessageService {
    void sendMessage(String message);
}

// EmailService.java
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email enviado: " + message);
    }
}

// SMSService.java
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS enviado: " + message);
    }
}

// NotificationService.java
public class NotificationService {
    private final MessageService messageService;

    // Injeção de dependência via construtor
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message) {
        messageService.sendMessage(message);
    }
}


import org.springframework.context.annotation.*;

// Configuração do Spring
@Configuration
public class AppConfig {

    // Configuração para instanciar o EmailService
    @Bean
    public MessageService emailService() {
        return new EmailService();
    }

    // Configuração para instanciar o SMSService
    @Bean
    public MessageService smsService() {
        return new SMSService();
    }

    // Configuração para instanciar o NotificationService com injeção de dependência
    @Bean
    public NotificationService notificationService(MessageService messageService) {
        return new NotificationService(messageService);
    }
}
``




´´
import org.springframework.context.annotation.*;

public class Main {
    public static void main(String[] args) {
        // Criando o contexto do Spring e obtendo a instância de NotificationService
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NotificationService notificationService = context.getBean(NotificationService.class);

        // Enviando uma notificação usando o NotificationService
        notificationService.sendNotification("Olá! Esta é uma mensagem de teste.");
    }
}


