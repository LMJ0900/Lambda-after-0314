package com.turing.api.menu;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor



public class Menu {
    private Long id;
    private String item;
    private String category;

    @Builder(builderMethodName = "builder")
    public Menu(Long id, String item, String category){
        this.id = id;
        this.item = item;
        this.category = category;
    }
}
