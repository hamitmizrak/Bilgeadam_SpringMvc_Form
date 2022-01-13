package com.bilgeadam;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BuilderTuto {
    private String adi;
    private String soyadi;

    public static void main(String[] args) {
        BuilderTuto builderTuto=BuilderTuto.builder()
                .adi("Hamit")
                .soyadi("Mızrak")
                .build();
        System.out.println(builderTuto);
    }
}
