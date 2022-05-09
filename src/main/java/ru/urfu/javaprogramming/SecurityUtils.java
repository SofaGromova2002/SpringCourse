package ru.urfu.javaprogramming;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ru.urfu.javaprogramming.config.UsersProperties;
import ru.urfu.javaprogramming.model.LoggedUserResponse;

import java.util.Collection;
import java.util.stream.Collectors;

public class SecurityUtils {
    public static LoggedUserResponse getLoggedUserResponse() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        LoggedUserResponse loggedUserResponse = new LoggedUserResponse();
        loggedUserResponse.setUsername(principal.getUsername());
        loggedUserResponse.setRoles(authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return loggedUserResponse;
    }
}
