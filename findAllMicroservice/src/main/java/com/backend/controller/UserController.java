/*

package com.backend.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.ColaboradorEntity;
import com.backend.repositotory.ColaboradorRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/colaboradorEntitys")
@Validated
class UserController {

   private final ColaboradorRepository repository;

   private final PasswordEncoder passwordEncoder;

   UserController(ColaboradorRepository repository, PasswordEncoder passwordEncoder) {
       this.repository = repository;
       this.passwordEncoder = passwordEncoder;
   }

   @GetMapping
   Page<ColaboradorEntity> all(@PageableDefault(size = Integer.MAX_VALUE) Pageable pageable, OAuth2Authentication authentication) {
       String auth = (String) authentication.getUserAuthentication().getPrincipal();
       String role = authentication.getAuthorities().iterator().next().getAuthority();
//       if (role.equals(ColaboradorEntity.Role.USER.name())) {
//           return repository.findAll();
//       }
       return repository.findAll(pageable);
   }

   @GetMapping("/search")
   Optional<ColaboradorEntity> search(@RequestParam String email, Pageable pageable, OAuth2Authentication authentication) {
       String auth = (String) authentication.getUserAuthentication().getPrincipal();
       String role = authentication.getAuthorities().iterator().next().getAuthority();
//       if (role.equals(ColaboradorEntity.Role.USER.name())) {
//           return repository.findAllByEmailContainsAndEmail(email, auth, pageable);
//       }
       return repository.findByNome(email);
   }

   @GetMapping("/findByNome")
   @PreAuthorize("!hasAuthority('USER') || (authentication.principal == #email)")
   ColaboradorEntity findByNome(@RequestParam String email, OAuth2Authentication authentication) throws Exception {
       return repository.findByNome(email).orElseThrow(() -> new Exception(email));
   }

   @GetMapping("/{id}")
   @PostAuthorize("!hasAuthority('USER') || (returnObject != null && returnObject.email == authentication.principal)")
   ColaboradorEntity one(@PathVariable Integer id) throws Exception {
       return repository.findById(id).orElseThrow(() -> new Exception( "id"));
   }

   @PutMapping("/{id}")
   @PreAuthorize("!hasAuthority('USER') || (authentication.principal == @colaboradorEntityRepository.findById(#id).orElse(new net.reliqs.gleeometer.colaboradorEntitys.ColaboradorEntity()).email)")
   void update(@PathVariable Integer id, @Valid @RequestBody ColaboradorEntity res) throws Exception {
       ColaboradorEntity u = repository.findById(id).orElseThrow(() -> new Exception("id"));
       res.setSenha(u.getSenha());
       repository.save(res);
   }

   @PostMapping
   @PreAuthorize("!hasAuthority('USER')")
   ColaboradorEntity create(@Valid @RequestBody ColaboradorEntity res) {
       return repository.save(res);
   }



   @PutMapping("/{id}/changePassword")
   @PreAuthorize("!hasAuthority('USER') || (#oldPassword != null && !#oldPassword.isEmpty() && authentication.principal == @colaboradorEntityRepository.findById(#id).orElse(new net.reliqs.gleeometer.colaboradorEntitys.ColaboradorEntity()).email)")
   void changePassword(@PathVariable Integer id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) throws Exception {
       ColaboradorEntity colaboradorEntity = repository.findById(id).orElseThrow(() -> new Exception(id.toString()));
       if (oldPassword == null || oldPassword.isEmpty() || passwordEncoder.matches(oldPassword, colaboradorEntity.getSenha())) {
           colaboradorEntity.setSenha(passwordEncoder.encode(newPassword));
           repository.save(colaboradorEntity);
       } else {
           throw new Exception("old password doesn't match");
       }
   }
}

*/