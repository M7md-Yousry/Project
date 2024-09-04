 package yousry.mohammed.content_calender.model;


 import jakarta.validation.constraints.NotEmpty;
 import org.springframework.data.annotation.Id;

 import java.time.LocalDateTime;

 public record Content(
         @Id
         Integer id,
         @NotEmpty
         String fullname,
         @NotEmpty
         String address,
         MaritalStatus maritalstatus,
         Department department,
         LocalDateTime dataCreated,
         String githuburl
 ) {
 }
