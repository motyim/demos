package me.motyim.lean.DemoGraphQL.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninPayload {
    String token ;
    User user;
}
