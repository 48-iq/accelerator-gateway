package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.accelerator.sdt.gateway.exceptions.ValidationException;
import ru.accelerator.sdt.gateway.security.UserDetailsImpl;
import ru.accelerator.sdt.gateway.services.interf.AreaValidationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaValidationServiceImpl implements AreaValidationService {
    private final RestTemplate restTemplate;
    @Value("${hosts.services.area}")
    private String areaHost;
    @Value("${mappings.services.area.user}")
    private String userMapping;

    @Override
    public void validateUser(Integer areaId) {
        try {
            UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication();
            ResponseEntity<List<Integer>> response = restTemplate.exchange(
                    areaHost + userMapping + "/" + user.getUser().getId(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Integer>>() {
                    });
            List<Integer> queries = response.getBody();
            if (!queries.contains(areaId)) {
                throw new ValidationException("this area from another user");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
