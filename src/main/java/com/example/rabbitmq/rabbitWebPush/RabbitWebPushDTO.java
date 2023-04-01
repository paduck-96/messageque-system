//package com.example.rabbitmq.rabbitWebPush;
//
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class RabbitWebPushDTO {
//    private Long user_id;
//    private String user_name;
//    private String room_id;
//    private LocalDateTime start_time;
//
//    protected RabbitWebPushMessage convert(){
//        RabbitWebPushMessage webPushMessage = new RabbitWebPushMessage();
//        String message = String.format("%s 님! %s에 시작하는 %s 방에 입장 신청이 완료되었습니다!",
//                this.getUser_name(), this.getStart_time(), this.getRoom_id());
//
//        webPushMessage.setUserId(this.getUser_id());
//        webPushMessage.setMessage(message);
//
//        return webPushMessage;
//    }
//}
