package com.mini.anuualwork.dto;

import com.mini.anuualwork.entity.Member;
import com.mini.anuualwork.entity.Work;
import com.mini.anuualwork.entity.type.AnnualStatus;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AdminDto {

    /* 집계 쿼리가 포함된 JPQL Projection 결과를 Converting 하기 위해서는 interface + Getter 사용 */
    public interface ResponseMemberEntity {
        Long getId();
        String getName();
        String getEmail();
        String getEmployeeNumber();
        Integer getRestAnnual();
        Integer getWorkDay();
    }

    @Getter
    @Builder
    public static class ResponseMember {
        private Long id;
        private String name;
        private String email;
        private String employeeNumber;
        private Integer restAnnual;
        private Integer workDay;

        public static ResponseMember fromEntity(ResponseMemberEntity entity) {
            return ResponseMember.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .email(entity.getEmail())
                    .employeeNumber("#" + entity.getEmployeeNumber().substring(4, 8))
                    .restAnnual(entity.getRestAnnual())
                    .workDay(entity.getWorkDay())
                    .build();
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class ResponseSuccess {
        private String message;
    }

    @Data
    public static class RequestCreateWork {
        @NotNull
        private Long id;

        @NotNull
        @Future
        private Timestamp date;

        public Work toEntity(Member member) {
            Work work = new Work();
            work.setMember(member);
            work.setDate(this.date.toLocalDateTime());

            return work;
        }
    }

    /* Projection 결과를 받아서 @Value()에서 Client 에서 원하는 데이터로 가공 */
    public interface ResponseAnnualEntity {
        Long getAnnualId();
        String getName();
        String getEmployeeNumber();
        LocalDateTime getDate();
        AnnualStatus getStatus();
    }

    @Getter
    @Builder
    public static class ResponseAnnual {
        private Long annualId;
        private String name;
        private String employeeNumber;
        private String date;
        private AnnualStatus status;

        public static ResponseAnnual fromEntity(ResponseAnnualEntity entity) {
            String formattedEmployeeNumber = "#" + entity.getEmployeeNumber().substring(4, 8);
            String formattedDate = entity.getDate().toLocalDate().toString();

            return ResponseAnnual.builder()
                    .annualId(entity.getAnnualId())
                    .name(entity.getName())
                    .employeeNumber(formattedEmployeeNumber)
                    .date(formattedDate)
                    .status(entity.getStatus())
                    .build();
        }
    }
}
