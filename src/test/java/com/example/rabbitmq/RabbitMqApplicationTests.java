package com.example.rabbitmq;

import com.example.rabbitmq.dto.RequestDTO;
import com.example.rabbitmq.javamailsend.MailService;
import com.example.rabbitmq.rabbitmail.MailProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RabbitMqApplicationTests {

    @Autowired
    private MailService mailService;

    @MockBean
    private JavaMailSender mailSender;

    @Mock
    private AmqpTemplate amqpTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // 메일 전송 테스트
    @Test
    void sendEmail() throws Exception{
        //given
        RequestDTO dto = new RequestDTO();
        dto.setTo("test@test.com");
        dto.setSubject("Test Email");
        dto.setText("This is a test email.");

        //when
        mailService.sendMail(dto);

        //then
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));

        Assertions.assertEquals("test@test.com", dto.getTo());
        Assertions.assertEquals("Test Email", dto.getSubject());
        Assertions.assertEquals("This is a test email.", dto.getText());
    }

    // rabbitMq testCode
    @Autowired
    private MailProducer mailProducer;

    @Test
    public void sendEmailTest() throws Exception{

        //given
        RequestDTO dto = new RequestDTO();
        dto.setTo("test@test.com");
        dto.setSubject("Test Email");
        dto.setText("This is a test email.");

        //when
        mailService.sendMail(dto);

        // then
        ArgumentCaptor<Message> argumentCaptor = ArgumentCaptor.forClass(Message.class);
        verify(amqpTemplate).convertAndSend(eq("email"), argumentCaptor.capture());

        Message message = argumentCaptor.getValue();
        RequestDTO requestDto = (RequestDTO) SerializationUtils.deserialize(message.getBody());

        Assertions.assertEquals("test@test.com", requestDto.getTo());
        Assertions.assertEquals("Test Email", requestDto.getTo());
        Assertions.assertEquals("This is a test email.", requestDto.getTo());
    }
}
