package co.istad.chhaya.fswd_sbapp;

import lombok.Builder;

import java.nio.file.FileStore;
@Builder
public record Student(
        String name,
        String gender,
        String Course


){
}
