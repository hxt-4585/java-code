package com.powernode.bank.pojo;

import lombok.Data;

/*集成以下注解
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode*/
@Data
public class Account {
    private Long id;
    private String actno;
    private Double balance;
}
