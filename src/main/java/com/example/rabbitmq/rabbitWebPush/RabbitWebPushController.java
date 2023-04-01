//package com.example.rabbitmq.rabbitWebPush;
//
//import com.example.rabbitmq.rabbitEventMail.RabbitSender;
//import lombok.AllArgsConstructor;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.codec.ServerSentEvent;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Mono;
//
//import java.time.LocalDateTime;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/test")
//public class RabbitWebPushController {
//    private final RabbitSender rabbitSender;
//    private final RabbitWebPushSender webPushSender;
////    @PostMapping("/push")
////    public ResponseEntity<String> sendPush(@RequestBody RabbitWebPushDTO dto){
////
////        return ResponseEntity.ok("웹 푸시 발송!");
////    }
//
//    @GetMapping("/sse")
//    public ResponseEntity<String> sendSSEPush(@RequestParam("user_id") Long userId,
//                                              @RequestParam("user_name") String userName,
//                                              @RequestParam("room_id") String roomId,
//                                              @RequestParam("start_time") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime){
//
//    RabbitWebPushDTO dto = new RabbitWebPushDTO();
//    dto.setUser_id(userId);
//    dto.setUser_name(userName);
//    dto.setRoom_id(roomId);
//    dto.setStart_time(startTime);
//        rabbitSender.sendPush(dto.convert());
//        return ResponseEntity.ok("푸시 발송 완료!");
//    }
//}
//
//
