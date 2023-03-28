package com.example.rabbitmq.rabbitEventMail;

public class RabbitDTOtoEmail {
    public static RabbitEmailMessage DTOtoEmail(RabbitEmailRequestDTO dto){
        RabbitEmailMessage emailMessage = new RabbitEmailMessage();
        emailMessage.setTo(dto.getUserEmail());
        String subject = dto.getRoomId()+"방에 대한 입장 안내 이메일";
        emailMessage.setSubject(subject);
        String text = dto.getUserId()+"님, 안녕하세요. Developers 입니다.";
        String text2 = dto.getRoomId()+"방은 현재 입장 가능합니다";
        String text3 ="입장 경로: "+dto.getRoomUrl();
        String text4 ="시작 시간은 "+dto.getStartTime()+"입니다";
        emailMessage.setText(text+text2+text3+text4);

        return emailMessage;
    }
}
